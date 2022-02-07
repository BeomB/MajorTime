package com.example.majortime;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class Login_Activity extends AppCompatActivity {

    private final static int DATABASE_VERSION = 1;
    MyDBHelper helper;
    SQLiteDatabase database;
    static String sign="test";
    static String tid;
    static String tpw;

    EditText idEditText;
    EditText pwEditText;
    Button btnLogin;
    Button btnSign;

    int count;      //로그인 성공시 증가
    String id_, pw_;
    Cursor cursor1, cursor2,cursor3;
    String shared = "sungjae";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEditText = (EditText) findViewById(R.id.Id);
        pwEditText = (EditText) findViewById(R.id.Passwd);

        int counter = 0;
        List<Integer> list = new ArrayList<Integer>();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);

        final String value_id = sharedPreferences.getString("ID", "");
        final String value_pw = sharedPreferences.getString("PW", "");
//        final Integer value_count = sharedPreferences.getInt("count", 0);

        btnLogin = (Button) findViewById(R.id.Login_Btn);
        btnSign = (Button) findViewById(R.id.Signin_Btn);

        helper = new MyDBHelper(this);
        database = helper.getWritableDatabase();

        //        if (value_count > 0) {
//            cursor3 = database.rawQuery("select NUM from editid where ID = '" + value_id + "' ", null);
//
//            while (cursor3.moveToNext()){
//                Integer num_count = cursor3.getInt(0);
//                counter += num_count;
//                list.add(counter);
//                counter = 0;
//            }
//
//            if (list.size() > 0) {
        idEditText.setText(value_id);
        pwEditText.setText(value_pw);
//            }
//        }

        final List<String> list1 = new ArrayList<>();
        final List<String> list2 = new ArrayList<>();

        pwEditText.setInputType( InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD );
        pwEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());

        cursor1 = database.rawQuery("SELECT ID FROM majorjoin", null );
        cursor2 = database.rawQuery("SELECT PW FROM majorjoin", null);

        while (cursor1.moveToNext()) {
            String idkey = cursor1.getString(0);
            tid += idkey;
            list1.add(tid);
            tid = "";
        }

        while (cursor2.moveToNext()) {
            String pwkey = cursor2.getString(0);
            tpw += pwkey;
            list2.add(tpw);
            tpw = "";
        }

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                id_ = idEditText.getText().toString();
                pw_ = pwEditText.getText().toString();

                if(id_.length() == 0 || pw_.length() == 0) {
                    Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!list1.toString().contains(id_)){     //cursor에 일치하는 id 값이 들어가지 않았기 때`
                    //아이디가 틀렸습니다.
                    Toast.makeText(getApplicationContext(), "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!list2.toString().contains(pw_)){    //db에서 가져온 값과 입력 값이 일치하지 않으면!
                    //비밀번호가 틀렸습니다.
                    Toast.makeText(getApplicationContext(), "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    //로그인성공
                    Toast.makeText(getApplicationContext(), "로그인 완료", Toast.LENGTH_SHORT).show();
                    //인텐트 생성 및 호출



                    sign=id_;
                    Intent intent = new Intent(getApplicationContext(), Home_Activity.class);     //Home 화면으로 이동하자~
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("IIIDDD", id_);

                    startActivity(intent);
                    finish();
                }
            }
        });

        btnSign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //회원가입 버튼 클릭
                Intent intent = new Intent(getApplicationContext(),SignIn_Activity.class);
                startActivity(intent);
                //finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value_id = idEditText.getText().toString();
        String value_pw = pwEditText.getText().toString();
        int value_count = count;
        editor.putString("ID", value_id);
        editor.putString("PW", value_pw);
//        editor.putInt("count", value_count);
        editor.commit();
    }
}