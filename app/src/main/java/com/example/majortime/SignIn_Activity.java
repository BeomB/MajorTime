package com.example.majortime;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SignIn_Activity extends AppCompatActivity {
    private MyDBHelper helper;
    SQLiteDatabase database;
    static String tname;
    static String sign;

    EditText nameEditText;
    EditText emailEditText;
    EditText idEditText;
    EditText pwEditText;
    EditText CKpwEditText;

    Button CKid_Btn;
    Button SignIn_Success_Btn;

    Cursor cursor;

    String name;
    String email;
    String id;
    String pw;
    String CKpw;


    private final static int DATABASE_VERSION = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        nameEditText = (EditText) findViewById(R.id.Sign_name);
        emailEditText = (EditText) findViewById(R.id.Sign_email);
        idEditText = (EditText) findViewById(R.id.Sign_id);
        pwEditText = (EditText) findViewById(R.id.Sign_pw);
        CKpwEditText = (EditText) findViewById(R.id.Sign_CKpw);       //비밀번호 일치 확인

        pwEditText.setInputType( InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD );
        pwEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        CKpwEditText.setInputType( InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD );
        CKpwEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());

        SignIn_Success_Btn = (Button) findViewById(R.id.SignIn_Success_Btn);
        CKid_Btn = (Button) findViewById(R.id.Sign_CKid);

        helper = new MyDBHelper(this);
        database = helper.getWritableDatabase();
//        helper.onUpgrade(database, 1,2);

        final List<String> list = new ArrayList<>();

        cursor = database.rawQuery("SELECT ID FROM majorjoin", null );
        tname = "";

        while (cursor.moveToNext()) {
            String idkey = cursor.getString(0);
            tname += idkey;
            list.add(tname);
            tname = "";
        }

        CKid_Btn.setOnClickListener(new View.OnClickListener() {        //아이디 중복 체
            @Override
            public void onClick(View v) {
                id = idEditText.getText().toString();
                sign=id;///회원 보기
                if (id.equals("")) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (list.toString().contains(id)){     //db에서 id 값을 비교해서 같은 것이 존재한다면!
                    //존재하는 아이디입니다.
                    Toast.makeText(getApplicationContext(), "이미 존재하는 아이디입니다.", Toast.LENGTH_SHORT).show();
                } else if (!list.toString().contains(id)){
                    Toast.makeText(getApplicationContext(), "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        SignIn_Success_Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                name = nameEditText.getText().toString();
                email = emailEditText.getText().toString();
                pw = pwEditText.getText().toString();
                CKpw = CKpwEditText.getText().toString();
                id = idEditText.getText().toString();

                if(id.equals("") || pw.equals("") || name.equals("") || email.equals("") || CKpw.equals("")) {
                    Toast.makeText(SignIn_Activity.this, "입력 칸을 모두 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!pw.equals(CKpw)){
                    Toast.makeText(getApplicationContext(), "비밀번호를 동일하게 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    database.execSQL("INSERT INTO majorjoin (NAME, EMAIL, ID, PW) values('" + name + "','" + email + "', '" + id + "', '" + pw + "');");
                    //helper.insertUser(database, name, email, id,pw);
                    Toast.makeText(SignIn_Activity.this, "가입이 완료되었습니다. 로그인을 해주세요.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Login_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }
}