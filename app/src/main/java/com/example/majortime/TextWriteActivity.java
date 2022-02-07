package com.example.majortime;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TextWriteActivity extends AppCompatActivity {
    private MyDBHelper helper;
    SQLiteDatabase database;
    static String user="";
    Cursor cursor;
    EditText editTitle,editMain;
    TextView signtext;
    Button btncomplete,btnback;
    String title,text;
    Editable stitle;
    Editable stext;
    static Integer textnum= 0;

    private final static int DATABASE_VERSION = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textwrite);
        helper = new MyDBHelper(this);
        database = helper.getWritableDatabase();
        final List<String> list = new ArrayList<>();
        btncomplete=(Button)findViewById(R.id.btnfinish);
        editTitle=(EditText)findViewById(R.id.maintitle);
        editMain=(EditText)findViewById(R.id.mainttext);
        signtext=(TextView)findViewById(R.id.signtext);
        signtext.setText(Login_Activity.sign);



        btncomplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("하" + signtext.getText().toString());

                if (signtext.getText().toString().equals("관리자")) {
                    textnum = textnum + 1;
                    title = editTitle.getText().toString();
                    text = editMain.getText().toString();
                    database.execSQL("INSERT INTO Text(title , maintext) values('" + title + "' , '" + text + "')");
                    Toast.makeText(TextWriteActivity.this, "글쓰기 완료!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), TextListviewActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "관리자만 글을 작성할 수 있습니다.", Toast.LENGTH_SHORT).show();
                }
            }
            
        });





    }
}