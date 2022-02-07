package com.example.majortime;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalcuActivity extends AppCompatActivity {
    int length=0,num=0;
    String totalscoretext;
    double totalscore=1,score1=0,score2=0,score3=0,score4=0,score5=0,score6=0,score7=0,score8=0;
    Button btn1;
    Spinner s1,s2,s3,s4,s5,s6,s7,s8;
    EditText subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8;
    EditText editsubject1,editsubject2,editsubject3,editsubject4,editsubject5,editsubject6,editsubject7,editsubject8,editsubject9;
    TextView text1,text2,text3;
    String sgrade1="0",sgrade2="0",sgrade3="0",sgrade4="0",sgrade5="0",sgrade6="0",sgrade7="0",sgrade8="0";
    double grade1=0,grade2=0,grade3=0,grade4=0,grade5=0,grade6=0,grade7=0,grade8=0;
    double point1,point2,point3,point4,point5,point6,point7,point8,point9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu);
        s1=(Spinner)findViewById(R.id.s1); s2=(Spinner)findViewById(R.id.s2); s3=(Spinner)findViewById(R.id.s3); s4=(Spinner)findViewById(R.id.s4); s5=(Spinner)findViewById(R.id.s5); s6=(Spinner)findViewById(R.id.s6); s7=(Spinner)findViewById(R.id.s7); s8=(Spinner)findViewById(R.id.s8);
        subject1=(EditText)findViewById(R.id.subject1); subject2=(EditText)findViewById(R.id.subject2); subject3=(EditText)findViewById(R.id.subject3); subject4=(EditText)findViewById(R.id.subject4); subject5=(EditText)findViewById(R.id.subject5); subject6=(EditText)findViewById(R.id.subject6); subject7=(EditText)findViewById(R.id.subject7); subject8=(EditText)findViewById(R.id.subject8);
        editsubject1=(EditText)findViewById(R.id.editsubject1); editsubject2=(EditText)findViewById(R.id.editsubject2); editsubject3=(EditText)findViewById(R.id.editsubject3); editsubject4=(EditText)findViewById(R.id.editsubject4); editsubject5=(EditText)findViewById(R.id.editsubject5); editsubject6=(EditText)findViewById(R.id.editsubject6); editsubject7=(EditText)findViewById(R.id.editsubject7); editsubject8=(EditText)findViewById(R.id.editsubject8);
        text1=(TextView)findViewById(R.id.score1); text2=(TextView)findViewById(R.id.score2);
        btn1=(Button)findViewById(R.id.btn);



        //스피너 값
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    point1= (float) 0;
                }else if (position==1){
                    point1= (float) 4.5;
                }else if (position==2){
                    point1= (float) 4.0;
                }else if (position==3){
                    point1= (float) 3.5;
                }else if (position==4){
                    point1= (float) 3.0;
                }else if (position==5){
                    point1= (float) 2.5;
                }else if (position==6){
                    point1= (float) 2.0;
                }else if (position==7){
                    point1= (float) 1.5;
                }else if (position==8){
                    point1= (float) 1.0;
                }else if (position==9){
                    point1= (float) 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    point2= (float) 0;
                }else if (position==1){
                    point2= (float) 4.5;
                }else if (position==2){
                    point2= (float) 4.0;
                }else if (position==3){
                    point2= (float) 3.5;
                }else if (position==4){
                    point2= (float) 3.0;
                }else if (position==5){
                    point2= (float) 2.5;
                }else if (position==6){
                    point2= (float) 2.0;
                }else if (position==7){
                    point2= (float) 1.5;
                }else if (position==8){
                    point2= (float) 1.0;
                }else if (position==9){
                    point2= (float) 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    point3= (float) 0;
                }else if (position==1){
                    point3= (float) 4.5;
                }else if (position==2){
                    point3= (float) 4.0;
                }else if (position==3){
                    point3= (float) 3.5;
                }else if (position==4){
                    point3= (float) 3.0;
                }else if (position==5){
                    point3= (float) 2.5;
                }else if (position==6){
                    point3= (float) 2.0;
                }else if (position==7){
                    point3= (float) 1.5;
                }else if (position==8){
                    point3= (float) 1.0;
                }else if (position==9){
                    point3= (float) 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    point4= (float) 0;
                }else if (position==1){
                    point4= (float) 4.5;
                }else if (position==2){
                    point4= (float) 4.0;
                }else if (position==3){
                    point4= (float) 3.5;
                }else if (position==4){
                    point4= (float) 3.0;
                }else if (position==5){
                    point4= (float) 2.5;
                }else if (position==6){
                    point4= (float) 2.0;
                }else if (position==7){
                    point4= (float) 1.5;
                }else if (position==8){
                    point4= (float) 1.0;
                }else if (position==9){
                    point4= (float) 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    point5= (float) 0;
                }else if (position==1){
                    point5= (float) 4.5;
                }else if (position==2){
                    point5= (float) 4.0;
                }else if (position==3){
                    point5= (float) 3.5;
                }else if (position==4){
                    point5= (float) 3.0;
                }else if (position==5){
                    point5= (float) 2.5;
                }else if (position==6){
                    point5= (float) 2.0;
                }else if (position==7){
                    point5= (float) 1.5;
                }else if (position==8){
                    point5= (float) 1.0;
                }else if (position==9){
                    point5= (float) 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    point6= (float) 0;
                }else if (position==1){
                    point6= (float) 4.5;
                }else if (position==2){
                    point6= (float) 4.0;
                }else if (position==3){
                    point6= (float) 3.5;
                }else if (position==4){
                    point6= (float) 3.0;
                }else if (position==5){
                    point6= (float) 2.5;
                }else if (position==6){
                    point6= (float) 2.0;
                }else if (position==7){
                    point6= (float) 1.5;
                }else if (position==8){
                    point6= (float) 1.0;
                }else if (position==9){
                    point6= (float) 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    point7= (float) 0;
                }else if (position==1){
                    point7= (float) 4.5;
                }else if (position==2){
                    point7= (float) 4.0;
                }else if (position==3){
                    point7= (float) 3.5;
                }else if (position==4){
                    point7= (float) 3.0;
                }else if (position==5){
                    point7= (float) 2.5;
                }else if (position==6){
                    point7= (float) 2.0;
                }else if (position==7){
                    point7= (float) 1.5;
                }else if (position==8){
                    point7= (float) 1.0;
                }else if (position==9){
                    point7= (float) 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    point8= (float) 0;
                }else if (position==1){
                    point8= (float) 4.5;
                }else if (position==2){
                    point8= (float) 4.0;
                }else if (position==3){
                    point8= (float) 3.5;
                }else if (position==4){
                    point8= (float) 3.0;
                }else if (position==5){
                    point8= (float) 2.5;
                }else if (position==6){
                    point8= (float) 2.0;
                }else if (position==7){
                    point8= (float) 1.5;
                }else if (position==8){
                    point8= (float) 1.0;
                }else if (position==9){
                    point8= (float) 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//버튼클릭시
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                length=0;

                sgrade1=editsubject1.getText().toString();
                sgrade2=editsubject2.getText().toString();
                sgrade3=editsubject3.getText().toString();
                sgrade4=editsubject4.getText().toString();
                sgrade5=editsubject5.getText().toString();
                sgrade6=editsubject6.getText().toString();
                sgrade7=editsubject7.getText().toString();
                sgrade8=editsubject8.getText().toString();

                if (sgrade1.equals("")){ grade1=0; }else {grade1=Float.parseFloat(sgrade1);}
                if (sgrade2.equals("")){ grade2=0; }else {grade2=Float.parseFloat(sgrade2);}
                if (sgrade3.equals("")){ grade3=0; }else {grade3=Float.parseFloat(sgrade3);}
                if (sgrade4.equals("")){ grade4=0; }else {grade4=Float.parseFloat(sgrade4);}
                if (sgrade5.equals("")){ grade5=0; }else {grade5=Float.parseFloat(sgrade5);}
                if (sgrade6.equals("")){ grade6=0; }else {grade6=Float.parseFloat(sgrade6);}
                if (sgrade7.equals("")){ grade7=0; }else {grade7=Float.parseFloat(sgrade7);}
                if (sgrade8.equals("")){ grade8=0; }else {grade7=Float.parseFloat(sgrade8);}

                String sarr[]={sgrade1,sgrade2,sgrade3,sgrade4,sgrade5,sgrade6,sgrade7,sgrade8};
                double arr[]={grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8};

                for (int i=0; i<sarr.length; i++){
                    if(arr[i]!=0){
                        length += 1;
                    }

                }

                score1=grade1*point1; score2=grade2*point2; score3=grade3*point3; score4=grade4*point4;
                score5=grade5*point5; score6=grade6*point6; score7=grade7*point7; score8=grade8*point8;
//                System.out.println("안녕하세요 : " + grade1+grade2+grade3+grade4+grade5+grade6+grade7+grade8);
//                totalscore=((score1+score2+score3+score4+score5+score6+score7+score8)/(grade1+grade2+grade3+grade4+grade5+grade6+grade7+grade8));
                totalscore=((point1+point2+point3+point4+point5+point6+point7+point8)/length);
                System.out.println(totalscore);

                //이수학점 총 계산하기

//                totalscoretext=String.valueOf(totalscore);
                totalscoretext=String.format("%.2f", totalscore);
                text1.setText(totalscoretext);
                String text2text = String.valueOf(grade1+grade2+grade3+grade4+grade5+grade6+grade7+grade8);
                text2.setText(text2text);



            }
        });
//        System.out.println(length);









    }
}