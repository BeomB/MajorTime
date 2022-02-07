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

public class ExamWriteActivity extends AppCompatActivity {
    private MyDBHelper helper;
    SQLiteDatabase database;
    static String tname;
    Cursor cursor;
    EditText editTitle,editanswer,editboki1,editboki2,editboki3,editboki4,editboki5;
    Button btncomplete,btnback;
    String title,user,answer,boki1,boki2,boki3,boki4,boki5;
    Editable stitle;
    Editable stext;
    TextView signtext;
    static Integer examtextnum= 0;

    private final static int DATABASE_VERSION = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examwrite);
        helper = new MyDBHelper(this);
        database = helper.getWritableDatabase();
        final List<String> list = new ArrayList<>();
        btncomplete=(Button)findViewById(R.id.btnfinish);
        editTitle=(EditText)findViewById(R.id.examtitle);
        editboki1=(EditText)findViewById(R.id.examboki1);
        editboki2=(EditText)findViewById(R.id.examboki2);
        editboki3=(EditText)findViewById(R.id.examboki3);
        editboki4=(EditText)findViewById(R.id.examboki4);
        editboki5=(EditText)findViewById(R.id.examboki5);
        editanswer=(EditText)findViewById(R.id.examanswer);
        signtext=(TextView)findViewById(R.id.signtext);
        signtext.setText(Login_Activity.sign);
        user=Login_Activity.sign;


        btncomplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                examtextnum=examtextnum+1;
                title=editTitle.getText().toString();
                boki1=editboki1.getText().toString();
                boki2=editboki2.getText().toString();
                boki3=editboki3.getText().toString();
                boki4=editboki4.getText().toString();
                boki5=editboki5.getText().toString();
                answer=editanswer.getText().toString();

                database.execSQL("INSERT INTO Exam(user,title,boki1,boki2,boki3,boki4,boki5,answer) values('" + user + "','" + title + "' ,'" + boki1 + "','" + boki2 + "','" + boki3 + "','" + boki4 + "','" + boki5 + "','" + answer + "' )");
                if (title.equals("")){
                    Toast.makeText(ExamWriteActivity.this, "제목을 입력해주세요!", Toast.LENGTH_SHORT).show();
                }else{
                Toast.makeText(ExamWriteActivity.this, "문제쓰기 완료!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ExamListviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);}
            }
        });





    }
}