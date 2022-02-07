package com.example.majortime;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ExamListviewActivity extends AppCompatActivity {
    Button btnSearch,btnwrite;
    static String ttitle,user;
    String a;
    static String euser,examtitle,examtext,examanswer,eboki1,eboki2,eboki3,eboki4,eboki5;
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION =1;
    private Button btnsearch;
    private AutoCompleteTextView autoCompleteTextView;
    View dialogView;
    TextView signtext;


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_examlistview);
                mHelper = new MyDBHelper(this);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                btnwrite=(Button)findViewById(R.id.examwrite);
                Cursor cursor;
                signtext=(TextView)findViewById(R.id.signtext);
                signtext.setText(Login_Activity.sign);
                user=Login_Activity.sign;
                final ListView listView =(ListView)findViewById(R.id.listview);
                final List<String> list = new ArrayList<>();

                ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simpleitem,list);
                cursor=db.rawQuery("select title from Exam where user ='" + user + "' ",null);
                ttitle="";
                while (cursor.moveToNext()){
                    String title =cursor.getString(0);
                    ttitle+=""+title;
                    list.add(ttitle);
                    ttitle="";
                }

                listView.setAdapter(adapter);
                /////////////////////////////////////////////////////여기까지
                autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
                ArrayAdapter<String> searchList = new ArrayAdapter<String>(this,R.layout.simpleitem, list);
                autoCompleteTextView.setAdapter(searchList);

                autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                            a = autoCompleteTextView.getText().toString();
                            autoCompleteTextView.setText("");


                            if (a.equals("")) {
                                Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                            } else if (a.equals(" ")) {
                                Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                            } else if (!list.toString().contains(a)) {
                                Toast.makeText(getApplicationContext(), "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
                            }else {
                                SQLiteDatabase db;
                                Intent intent = new Intent(getApplicationContext(), ExamMaintextActivity.class);
                                startActivity(intent);
                                db = mHelper.getWritableDatabase();
                                Cursor cursor;
                                cursor = db.rawQuery("select " +
                                        "title,boki1,boki2,boki3,boki4,boki5,answer from Exam WHERE title='" + a + "' ",null);

                                examtitle="";
                                examtext="";
                                examanswer="";
                                eboki1=""; eboki2=""; eboki3=""; eboki4=""; eboki5="";


                                while (cursor.moveToNext()) {

                                    String title = cursor.getString(0);
                                    String boki1= cursor.getString(1);
                                    String boki2= cursor.getString(2);
                                    String boki3 = cursor.getString(3);
                                    String boki4 = cursor.getString(4);
                                    String boki5 = cursor.getString(5);
                                    String answer = cursor.getString(6);


                                    if (title == null) { title = ""; }
                                    if (boki1 == null) { boki1 = ""; } if (boki2 == null) { boki2 = ""; }
                                    if (boki3 == null) { boki3 = ""; } if (boki4 == null) { boki4 = ""; }
                                    if (boki5 == null) { boki5 = ""; } if (answer == null) { answer = ""; }

                                    examtitle+=title;
                                    examanswer+=answer;
                                    eboki1+=boki1; eboki2+=boki2; eboki3+=boki3; eboki4+=boki4; eboki5+=boki5;


                                    cursor.close();
                                    mHelper.close();
                                }
                            }
                            return true;
                        }
                        return false;
                    }
                });

                btnSearch = (Button) findViewById(R.id.edtBtn);
                btnSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a = autoCompleteTextView.getText().toString();
                        autoCompleteTextView.setText("");

                        if (a.equals("")) {
                            Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                        } else if (a.equals(" ")) {
                            Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                        } else if (!list.toString().contains(a)) {
                            Toast.makeText(getApplicationContext(), "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            SQLiteDatabase db;
                            Intent intent = new Intent(getApplicationContext(), ExamMaintextActivity.class);
                            startActivity(intent);
                            db = mHelper.getWritableDatabase();
                            Cursor cursor;
                            cursor = db.rawQuery("select title, boki1,boki2,boki3,boki4,boki5,answer from Exam WHERE title='" + a + "' ",null);
                            examtitle="";
                            examtext="";
                            examanswer="";
                            eboki1=""; eboki2=""; eboki3=""; eboki4=""; eboki5="";


                            while (cursor.moveToNext()) {

                                String title = cursor.getString(0);
                                String boki1= cursor.getString(1);
                                String boki2= cursor.getString(2);
                                String boki3 = cursor.getString(3);
                                String boki4 = cursor.getString(4);
                                String boki5 = cursor.getString(5);
                                String answer = cursor.getString(6);


                                if (title == null) { title = ""; }
                                if (boki1 == null) { boki1 = ""; } if (boki2 == null) { boki2 = ""; }
                                if (boki3 == null) { boki3 = ""; } if (boki4 == null) { boki4 = ""; }
                                if (boki5 == null) { boki5 = ""; } if (answer == null) { answer = ""; }

                                examtitle+=title;
                                examanswer+=answer;
                                eboki1+=boki1; eboki2+=boki2; eboki3+=boki3; eboki4+=boki4; eboki5+=boki5;


                                cursor.close();
                                mHelper.close();
                            }
                        }
                    }
            });


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override   // position 으로 몇번째 것이 선택됐는지 값을 넘겨준다
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object ob = (Object) parent.getAdapter().getItem(position);
                        Intent it = new Intent(ExamListviewActivity.this, ExamMaintextActivity.class);   // 인텐트 처리
                        it.putExtra("list", list.get(position));
                        startActivity(it);
                        SQLiteDatabase db;
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select title,boki1,boki2,boki3,boki4,boki5,answer from Exam WHERE title='" + ob + "' ",null);
                        examtitle="";
                        examtext="";
                        examanswer="";
                        eboki1=""; eboki2=""; eboki3=""; eboki4=""; eboki5="";

                        while (cursor.moveToNext()) {

                            String title = cursor.getString(0);
                            String boki1= cursor.getString(1);
                            String boki2= cursor.getString(2);
                            String boki3 = cursor.getString(3);
                            String boki4 = cursor.getString(4);
                            String boki5 = cursor.getString(5);
                            String answer = cursor.getString(6);


                            if (title == null) { title = ""; }
                            if (boki1 == null) { boki1 = ""; } if (boki2 == null) { boki2 = ""; }
                            if (boki3 == null) { boki3 = ""; } if (boki4 == null) { boki4 = ""; }
                            if (boki5 == null) { boki5 = ""; } if (answer == null) { answer = ""; }

                            examtitle+=title;
                            examanswer+=answer;
                            eboki1+=boki1; eboki2+=boki2; eboki3+=boki3; eboki4+=boki4; eboki5+=boki5;


                            cursor.close();
                            mHelper.close();

                        }

                    }
                });


                ////////////////////////////////////////////////////삭제
                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        final Object ob = (Object) parent.getAdapter().getItem(position);
//                         final Object ob = (Object) parent.getAdapter().getItem(position);
//                        Intent it = new Intent(ListviewActivity.this, maintext.class);   // 인텐트 처리
//                        it.putExtra("list", list.get(position));
//                        startActivity(it);
                        dialogView = (View)View.inflate(ExamListviewActivity.this,R.layout.dialog1,null);
                        AlertDialog.Builder dlg = new AlertDialog.Builder(ExamListviewActivity.this);
                        dlg.setView(dialogView);
                        dlg.setIcon(R.drawable.i_delete);
                        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SQLiteDatabase db;
                                db = mHelper.getWritableDatabase();
                                db.execSQL("DELETE FROM Exam WHERE title = '" + ob + "';");
                                listView.deferNotifyDataSetChanged();
                                Toast.makeText(getApplicationContext(),"삭제 완료!!!!",Toast.LENGTH_SHORT).show();
                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);


//                                Intent it = new Intent(ExamListviewActivity.this, Home_Activity.class);   // 인텐트 처리
//                                startActivity(it);
//                                finish();


                            }
                        });
                        dlg.setNegativeButton("취소",null);
                        dlg.show();

//                        SQLiteDatabase db;
//                        db = mHelper.getWritableDatabase();
//                        db.execSQL("DELETE FROM Text WHERE title = '" + ob + "';");
//                        Toast.makeText(getApplicationContext(),"삭제 완료!!!!",Toast.LENGTH_SHORT).show();
//                        Intent it = new Intent(TextListviewActivity.this, Home_Activity.class);   // 인텐트 처리
//                        startActivity(it);
                        return false;
                    }
                });

                ////////////////////////////////////////////////////가능

                btnwrite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ExamListviewActivity.this, ExamWriteActivity.class);
                        startActivity(intent);
                    }
                });




            }
}