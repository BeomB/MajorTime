package com.example.majortime;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActiveMaintextActivity extends AppCompatActivity {
        TextView Titletext,Maintext,signtext;
        ImageView imgv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activetext);

        Intent intent = new Intent(this.getIntent());

        signtext=(TextView)findViewById(R.id.signtext);
        Titletext=(TextView)findViewById(R.id.maintitle);
        Maintext=(TextView)findViewById(R.id.mainttext);
        Titletext.setText(ActiveListviewActivity.texttitle);
        Maintext.setText(ActiveListviewActivity.textmaintext);


    }
}