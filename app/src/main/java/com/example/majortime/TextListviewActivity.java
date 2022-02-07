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

public class TextListviewActivity extends AppCompatActivity {
    Button btnSearch;
    static int haha=0;
    View dialogView;
    TextView signtext;
    static String ttitle;
    String a;
    static String texttextnum,texttitle,textmaintext;
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION =1;
    private Button btnwrite;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textlistview);
        signtext=(TextView)findViewById(R.id.signtext);
        mHelper = new MyDBHelper(this);
        btnSearch=(Button)findViewById(R.id.edtBtn);
        btnwrite=(Button)findViewById(R.id.textwrite);
        SQLiteDatabase db;
        signtext.setText(Login_Activity.sign);
        db = mHelper.getWritableDatabase();
        Cursor cursor;

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        final ListView listView =(ListView)findViewById(R.id.listview);
        final List<String> list = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        cursor=db.rawQuery("select title from Text",null);
        ttitle="";
        while (cursor.moveToNext()){
            String title =cursor.getString(0);
            ttitle+=title;
            list.add(ttitle);
            ttitle="";
        }

        listView.setAdapter(adapter);
        /////////////////////////////////////////////////////여기까지
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        ArrayAdapter<String> searchList = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
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
                        Intent intent = new Intent(getApplicationContext(), TextMaintextActivity.class);
                        startActivity(intent);
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select textnum, title , maintext from Text WHERE title='" + a + "' ",null);



                        while (cursor.moveToNext()) {
                            String textnum = cursor.getString(0);
                            String title = cursor.getString(1);
                            String maintext = cursor.getString(2);

                            textnum="";
                            title="";
                            maintext="";


                            texttextnum+= textnum;
                            texttitle += title;
                            textmaintext += maintext;

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
                    Intent intent = new Intent(getApplicationContext(), TextMaintextActivity.class);
                    startActivity(intent);
                    db = mHelper.getWritableDatabase();
                    Cursor cursor;
                    cursor = db.rawQuery("select textnum, title , maintext from Text WHERE title='" + a + "' ", null);
                    texttextnum="";
                    texttitle="";
                    textmaintext="";


                    while (cursor.moveToNext()) {
                        String textnum = cursor.getString(0);
                        String title = cursor.getString(1);
                        String maintext = cursor.getString(2);



                        texttextnum += textnum;
                        texttitle += title;
                        textmaintext += maintext;


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
                Intent it = new Intent(TextListviewActivity.this, TextMaintextActivity.class);   // 인텐트 처리
                it.putExtra("list", list.get(position));
                startActivity(it);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                Cursor cursor;
                cursor = db.rawQuery("select textnum, title , maintext from Text WHERE title='" + ob + "' ", null);
                texttextnum="";
                texttitle="";
                textmaintext="";

                while (cursor.moveToNext()) {
                    String textnum = cursor.getString(0);
                    String title = cursor.getString(1);
                    String maintext = cursor.getString(2);


                    texttextnum+= textnum;
                    texttitle += title;
                    textmaintext += maintext;
                    cursor.close();
                    mHelper.close();

                }

            }
        });


        ////////////////////////////////////////////////////삭제

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                haha=haha+1;
                final Object ob = (Object) parent.getAdapter().getItem(position);
//                        Intent it = new Intent(ListviewActivity.this, maintext.class);   // 인텐트 처리
//                        it.putExtra("list", list.get(position));
//                        startActivity(it);
                dialogView = (View)View.inflate(TextListviewActivity.this,R.layout.dialog1,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(TextListviewActivity.this);
                dlg.setView(dialogView);
                dlg.setIcon(R.drawable.i_delete);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase db;
                        db = mHelper.getWritableDatabase();
                        db.execSQL("DELETE FROM Text WHERE title = '" + ob + "';");
                        listView.deferNotifyDataSetChanged();
                        Toast.makeText(getApplicationContext(),"삭제 완료!!!!",Toast.LENGTH_SHORT).show();
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                        haha=haha+1;
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
                if (signtext.getText().toString().equals("관리자")) {
                    Intent intent = new Intent(TextListviewActivity.this, TextWriteActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "관리자만 글을 작성할 수 있습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }


}