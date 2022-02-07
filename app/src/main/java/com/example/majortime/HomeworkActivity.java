package com.example.majortime;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class HomeworkActivity extends AppCompatActivity{

    private PendingIntent pendingIntent;
    private  PendingIntent pendingIntent2;
    private ListView listView;
    private hwListAdapter adapter;
    private ArrayList<hwListViewItem> data=null;
    private AlarmManager alarmManager;
    hwDBHelper dbHelper;
    SQLiteDatabase db = null;
    Cursor cursor;
    List yearlist=new ArrayList();
    List monthlist=new ArrayList();
    List daylist=new ArrayList();
    List hourlist=new ArrayList();
    List minutelist=new ArrayList();


    private void selectDB() {
        String sql;
        db=dbHelper.getWritableDatabase();
        sql = "SELECT * FROM homework;";

        cursor=db.rawQuery(sql,null);

        if (cursor.getCount()>=0) {
            startManagingCursor(cursor);
            hwDBAdapter dbAdapter=new hwDBAdapter(this,cursor);
            listView.setAdapter(dbAdapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeworkactivity);
        setTitle("과제");
        Button btnPlus = (Button)findViewById(R.id.plus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HomeworkWriteActivity.class);
                startActivity(intent);
            }
        });
        Button btnRefresh = (Button)findViewById(R.id.refresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDB();
                cursor = db.rawQuery("select _id from homework", null);;
                hwListViewItem LV = new hwListViewItem();
                while (cursor.moveToNext()){
                    LV.setId(cursor.getInt(0));
                }

            }
        });
        adapter = new hwListAdapter();

        listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dbHelper=new hwDBHelper(this,4);
        db=dbHelper.getWritableDatabase();
        selectDB();


        //===============================================================


        String sql;
        sql = "SELECT * FROM homework;";
        Calendar calendar = Calendar.getInstance();
        int year,month,day,hour,minute=0;
        Cursor cs = db.rawQuery(sql, null);
        try {

            Log.i("testLog","데이터갯수:"+cs.getCount());
            while (cs.moveToNext()) {
                yearlist.add(cs.getInt(cs.getColumnIndex("year")));
                monthlist.add(cs.getInt(cs.getColumnIndex("month")));
                daylist.add(cs.getInt(cs.getColumnIndex("day")));
                hourlist.add(cs.getInt(cs.getColumnIndex("hour")));
                minutelist.add(cs.getInt(cs.getColumnIndex("minute")));
            }

        }catch (Exception e) {
            Log.e("timelist","Exception in query_SQL",e);
        }

        long now = System.currentTimeMillis();
        Date mDate=new Date(now);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");

//        for(int i=0; i<yearlist.size(); i++) {
//
//
//            year = Integer.parseInt(yearlist.get(i).toString());
//             month = Integer.parseInt(monthlist.get(i).toString());
//           day = Integer.parseInt(daylist.get(i).toString());
//            hour = Integer.parseInt(hourlist.get(i).toString());
//           minute = Integer.parseInt(minutelist.get(i).toString());
//
//            calendar.set(Calendar.YEAR,year);
//            calendar.set(Calendar.MONTH,month-1);
//            calendar.set(Calendar.DAY_OF_MONTH,day);
//            calendar.set(Calendar.HOUR_OF_DAY,hour);
//            calendar.set(Calendar.MINUTE,minute);
//
//            System.out.println(minute+"=================");
//            }

//        calendar.set(Calendar.YEAR,2020);
//        calendar.set(Calendar.MONTH,6-1);
//        calendar.set(Calendar.DAY_OF_MONTH,17);
//        calendar.set(Calendar.HOUR_OF_DAY,10);
//        calendar.set(Calendar.MINUTE,32);
//        calendar.set(Calendar.SECOND,0);


//        System.out.println(minute+"=================");
//
//        Intent intent = new Intent(this, AlarmReceiver.class);
//        intent.putExtra("state","on");
//
//        this.alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        this.pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);


        Button off = (Button)findViewById(R.id.alarmoff);
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
                Toast.makeText(getApplicationContext(), "알람이 종료되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void stop() {
        Intent intent = new Intent(getApplicationContext(), hwAlarmReceiver.class);
        intent.putExtra("state","off");
        sendBroadcast(intent);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.homeworkmenu, menu);
//        return true;
//    }

}
