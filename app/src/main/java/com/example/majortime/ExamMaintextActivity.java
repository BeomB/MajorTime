package com.example.majortime;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExamMaintextActivity extends AppCompatActivity {
        TextView Titletext,Bokitext,answer,signtext;
        static int shownum=0;
        Button btnshow;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examtext);
        answer=(TextView)findViewById(R.id.examanswer);
        Titletext=(TextView)findViewById(R.id.examtitle);
        Bokitext=(TextView)findViewById(R.id.examboki);
        btnshow=(Button)findViewById(R.id.btnshow);

        Titletext.setText("  문제. "+ExamListviewActivity.examtitle);
        Bokitext.setText(" 1. "+ExamListviewActivity.eboki1+"\n\n"+" 2. "+ExamListviewActivity.eboki2+"\n\n"+" 3. "+ExamListviewActivity.eboki3+"\n\n"+" 4. "+ExamListviewActivity.eboki4+"\n\n"+" 5. "+ExamListviewActivity.eboki5+"\n");
        answer.setText(ExamListviewActivity.examanswer);
        signtext=(TextView)findViewById(R.id.signtext);

        Bokitext.setTextSize(16);
        Bokitext.setPadding(30,50, 0,30);

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shownum=shownum+1;
                if (shownum%2==0){
                    answer.setVisibility(View.INVISIBLE);
                    btnshow.setText("정답 보기");
                }else  if (shownum%2==1){
                    answer.setVisibility(View.VISIBLE);
                    btnshow.setText("정답 가리기");
                }

            }
        });
    }
}