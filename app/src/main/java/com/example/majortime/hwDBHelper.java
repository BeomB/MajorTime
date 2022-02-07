package com.example.majortime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class hwDBHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "Major_homework.db";
    //static final int DATABASE_VERSION = 2;

    public hwDBHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    /*
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
    */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS homework (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT , content TEXT,year INTEGER, month INTEGER, day INTEGER, hour INTEGER, minute INTEGER);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS homework");
        onCreate(db);
    }


}