package com.example.majortime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHelper extends SQLiteOpenHelper {
    public static final String Join = "Users";

    public MyDBHelper(Context context) {
        super(context, "Major", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("tag", "db 생성_db가 없을때만 최초로 실행함");
        // createTable(db);
        db.execSQL("create table Active(textnum integer primary key autoincrement, title text,maintext text);");
        db.execSQL("create table Circle(textnum integer primary key autoincrement, title text,maintext text);");
        db.execSQL("create table Text(textnum integer primary key autoincrement, title text,maintext text);");
        db.execSQL("create table Exam(user text,title text,boki1 text,boki2 text,boki3 text,boki4 text,boki5 text,answer text);");
        db.execSQL("CREATE TABLE IF NOT EXISTS majorjoin (NAME text , EMAIL text, ID text PRIMARY KEY, PW text);");
        db.execSQL("CREATE TABLE IF NOT EXISTS majortimetable (NUM integer PRIMARY KEY AUTOINCREMENT, SUBJECT text, CLASSROOM text, PROFESSOR text, DAY text, HOUR_START integer, MIN_START integer, HOUR_END integer, MIN_END integer, TOTAL_MINUTE integer, COLORFILL integer,GYOSI text, COLORVALUE integer);");
        db.execSQL("CREATE TABLE IF NOT EXISTS majortimetable_exist (NUM integer PRIMARY KEY AUTOINCREMENT, SUBJECT text, CLASSROOM text, PROFESSOR text, DAY text, HOUR_START integer, MIN_START integer, HOUR_END integer, MIN_END integer, GYOSI text);");
        db.execSQL("create table News(textnum text,title1 text,newstext1 text,url1 text,title2 text,newstext2 text,url2 text);"); //추가
        db.execSQL("INSERT INTO News Values('" + 1 + "' , '" + 1 + "' , '" + 1 + "' ,'" + "www.naver.com" + "' ,'" + 1 + "' , '"  + 1 + "','" + "www.daum.net" + "')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS Text");
        db.execSQL("DROP TABLE IF EXISTS Exam");
        db.execSQL("DROP TABLE IF EXISTS majorjoin");
        db.execSQL("DROP TABLE IF EXISTS majortimetable");
        onCreate(db);

    }


    public void insertUser(SQLiteDatabase db, String name, String email, String id, String pw) {
        Log.i("tag", "회원가입을 했을 때 실행함");
        db.beginTransaction();

        db.execSQL("INSERT INTO majorjoin(NAME, EMAIL, ID, PW) values('" + name + "' , '" + email + "' , '" + id + "' , '" + pw + "')");
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public void insertTimeTable(SQLiteDatabase db, String subject, String classroom, String professor, String day, Integer hour_start, Integer min_start, Integer hour_end, Integer min_end, Integer total_minute, Integer colorfill) {
        Log.i("tag", "시간표 설정을 했을 때 실행함") ;
        db.beginTransaction();

        db.execSQL("INSERT INTO majortimetable(SUBJECT, CLASSROOM, PROFESSOR, DAY, HOUR_START, MIN_START, HOUR_END, MIN_END, TOTAL_MINUTE, COLORFILL ) values('" + subject + "' , '" + classroom + "' , '" + professor + "' , '"  + day + "', '"  + hour_start + "' , '"  + min_start + "' , '" + hour_end + "', '" + min_end + "', '" + total_minute + "', '" + colorfill + "' )");

        db.setTransactionSuccessful();
        db.endTransaction();
    }
}

