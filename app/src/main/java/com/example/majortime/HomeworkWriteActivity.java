package com.example.majortime;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class HomeworkWriteActivity extends AppCompatActivity{

    hwDBHelper dbHelper;
    SQLiteDatabase db = null;

    private TimePicker timePicker;
    private AlarmManager alarmManager;
    private DatePicker datePicker;
    private PendingIntent pendingIntent;

    @Override
    public void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeworkwrite);

        this.timePicker = findViewById(R.id.time_picker);
        this.alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        this.datePicker = findViewById(R.id.date_picker);

        final EditText EtTitle =(EditText)findViewById(R.id.titleedit);
        final EditText EtContent = (EditText)findViewById(R.id.contentedit);
        final TextView ID = (TextView)findViewById(R.id.id);

        Button btnback = (Button) findViewById(R.id.back);
        Button btnselect = (Button) findViewById(R.id.select);

        dbHelper = new hwDBHelper(this, 4);
        db = dbHelper.getWritableDatabase();

        btnselect.setOnClickListener(new View.OnClickListener() {
            public void insert() {
                String title = EtTitle.getText().toString();
                String content=EtContent.getText().toString();
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                int year = datePicker.getYear();
                int month = datePicker.getMonth()+1;
                int day = datePicker.getDayOfMonth();

                db.execSQL("INSERT INTO homework (title,content,year,month,day,hour,minute) VALUES ('" +title+ "','" +content+ "',"+year+","+month+","+day+","+hour+","+minute+");");
                Toast.makeText(getApplicationContext(),"과제를 추가했습니다.",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onClick(View v) {
                start();
                insert();
                finish();
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void start() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, this.timePicker.getHour());
        calendar.set(Calendar.MINUTE, this.timePicker.getMinute());
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.YEAR, this.datePicker.getYear());
        calendar.set(Calendar.DAY_OF_MONTH, this.datePicker.getDayOfMonth()-1);
        calendar.set(Calendar.MONTH, this.datePicker.getMonth());


        //현재시간보다 이전이면 다음날로 지정
        if(calendar.before(Calendar.getInstance())) {
            calendar.add(Calendar.DATE, 1);
        }

        Intent intent = new Intent(this, hwAlarmReceiver.class);
        intent.putExtra("state","on");

        this.pendingIntent=PendingIntent.getBroadcast(this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT);
        this.alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);
    }

}
