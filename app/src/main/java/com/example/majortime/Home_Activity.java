package com.example.majortime;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_Activity extends AppCompatActivity {
    LinearLayout timeTableSET_Mon,timeTableSET_Tue,timeTableSET_Wed,timeTableSET_Thu,timeTableSET_Fri;
    LinearLayout.LayoutParams params;
    ImageButton btn;
    private static final float FONT_SIZE = 15;

    String id;
    String hs,ms,he,me;
    String sbj, pro, cla, daaay, gyo;

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Home_Fragment fragmentHome = new Home_Fragment();
    private TimeTable_Fragment fragmentTime = new TimeTable_Fragment();
    private CategoryFragment fragmentCate = new CategoryFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kkk);

        Intent intent = new Intent();
        id = intent.getStringExtra("IIIDDD");
        hs = intent.getStringExtra("hour_start_R");
        he = intent.getStringExtra("hour_end_R");
        ms = intent.getStringExtra("min_start_R");
        me = intent.getStringExtra("min_end_R");
        sbj = intent.getStringExtra("subject_R");
        pro = intent.getStringExtra("professor");
        cla = intent.getStringExtra("classroom");
        daaay = intent.getStringExtra("Rday");
        gyo = intent.getStringExtra("Rgyosi");

        ImageButton btn = (ImageButton) findViewById(R.id.timetableAdd2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimeTable_Setting.class);
                intent.putExtra("IIIDDD", id);
                intent.putExtra("hour_start_R", hs);
                intent.putExtra("hour_end_R", he);
                intent.putExtra("min_start_R", ms);
                intent.putExtra("min_end_R", me);
                intent.putExtra("subject_R", sbj);
                intent.putExtra("Rgyosi", gyo);
                intent.putExtra("Rday", daaay);
                intent.putExtra("classroom", cla);
                intent.putExtra("professor", pro);
                startActivity(intent);
            }
        });

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        getSupportFragmentManager().beginTransaction().replace(R.id.home_frag, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_bottom: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_frag, fragmentHome).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.time_bottom: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_frag, fragmentTime).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.category_bottom: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_frag, fragmentCate).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });




//        if (list != null) {     //timetable에서 넘어온 list에 값이 제대로 들어있다면!
//            for (Schedule_VO svo : list) {
//                Rgyosi = svo.getGyosi();
//                Rday = svo.getDay();
//                int color_random = Integer.parseInt(svo.getColorvalue());
//                int color_fill_R = Integer.parseInt(svo.getColorfill());
//                RSubject = svo.getSubject();
//                RProfessor = svo.getProfessor();
//                RClassroom = svo.getClassroom();
//                Rhour_start = Integer.parseInt(svo.getHour_start());
//                Rhour_end = Integer.parseInt(svo.getHour_end());
//                Rmin_start = Integer.parseInt(svo.getMin_start());
//                Rmin_end = Integer.parseInt(svo.getMin_end());
//
//
//                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                LinearLayout add = new LinearLayout(Home_Activity.this);
//                add.setLayoutParams(params);
//                add.setOrientation(LinearLayout.VERTICAL);
//                add.setBackgroundResource(R.drawable.line_timetable_detail);
//                TextView subject = new TextView(Home_Activity.this);
//                TextView professor = new TextView(Home_Activity.this);
//                TextView classroom = new TextView(Home_Activity.this);
//                TextView gyosi = new TextView(Home_Activity.this);
//                TextView day = new TextView(Home_Activity.this);
//                TextView time = new TextView(Home_Activity.this);
//
////                int MON_colorValue = Color.parseColor("E6E6FA");
////                int TUE_colorValue = Color.parseColor("FAF0E6");
////                int WED_colorValue = Color.parseColor("E0FFFF");
////                int THU_colorValue = Color.parseColor("F0F8FF");
////                int FRI_colorValue = Color.parseColor("FFE4E1");
//
//
//
//                if (daaay.equals("월요일")){
//                    day.setText(daaay + "        " + sbj);
//                    day.setTextSize(FONT_SIZE);
//                    day.setTextColor(Color.parseColor("#6495ED"));
//                    day.setPadding(70, 15,0,0);
//                    professor.setText(pro + "    " + cla);
//                    professor.setTextSize(FONT_SIZE);
//                    professor.setTextColor(Color.BLACK);
//                    professor.setPadding(70, 5, 0,0);
//                    gyosi.setText(gyo + "    " + "(" + hs + "시 " + ms + "분 ~ " + he + "시 " + me + "분" + ")");
//                    gyosi.setTextSize(FONT_SIZE);
//                    gyosi.setTextColor(Color.BLACK);
//                    gyosi.setPadding(70, 5,0,15);
//
//                    cvalues.put("SUBJECT", sbj);
//                    cvalues.put("CLASSROOM", cla);
//                    cvalues.put("PROFESSOR", pro);
//                    cvalues.put("DAY", daaay);
//                    cvalues.put("HOUR_START", hs);
//                    cvalues.put("MIN_START", ms);
//                    cvalues.put("HOUR_END", he);
//                    cvalues.put("MIN_END", me);
//                    database.insert("majortimetable_exist", null, cvalues);
//
//                    add.addView(day);
//                    add.addView(professor);
//                    add.addView(gyosi);
//                    add.setBackgroundResource(R.drawable.line_timetable);
//                    add.setBackgroundColor(Color.parseColor("#E6E6FA"));
//                    timeTableSET_Mon.addView(add);
//
//                } else if (daaay.equals("화요일")){
//                    day.setText(daaay + "        " + sbj);
//                    day.setTextSize(FONT_SIZE);
//                    day.setTextColor(Color.parseColor("#6495ED"));
//                    day.setPadding(70, 15,0,0);
//                    professor.setText(pro + "    " + cla);
//                    professor.setTextSize(FONT_SIZE);
//                    professor.setTextColor(Color.BLACK);
//                    professor.setPadding(70, 5, 0,0);
//                    gyosi.setText(gyo + "    " + "(" + hs + "시 " + ms + "분 ~ " + he + "시 " + me + "분" + ")");
//                    gyosi.setTextSize(FONT_SIZE);
//                    gyosi.setTextColor(Color.BLACK);
//                    gyosi.setPadding(70, 5,0,15);
//
//                    cvalues.put("SUBJECT", sbj);
//                    cvalues.put("CLASSROOM", cla);
//                    cvalues.put("PROFESSOR", pro);
//                    cvalues.put("DAY", daaay);
//                    cvalues.put("HOUR_START", hs);
//                    cvalues.put("MIN_START", ms);
//                    cvalues.put("HOUR_END", he);
//                    cvalues.put("MIN_END", me);
//                    database.insert("majortimetable_exist", null, cvalues);
//
//                    add.addView(day);
//                    add.addView(professor);
//                    add.addView(gyosi);
//                    add.setBackgroundResource(R.drawable.line_timetable);
//                    add.setBackgroundColor(Color.parseColor("#FAF0E6"));
//                    timeTableSET_Tue.addView(add);
//
//                } else if (daaay.equals("수요일")) {
//                    day.setText(daaay + "        " + sbj);
//                    day.setTextSize(FONT_SIZE);
//                    day.setTextColor(Color.parseColor("#6495ED"));
//                    day.setPadding(70, 15,0,0);
//                    professor.setText(pro + "    " + cla);
//                    professor.setTextSize(FONT_SIZE);
//                    professor.setTextColor(Color.BLACK);
//                    professor.setPadding(70, 5, 0,0);
//                    gyosi.setText(gyo + "    " + "(" + hs + "시 " + ms + "분 ~ " + he + "시 " + me + "분" + ")");
//                    gyosi.setTextSize(FONT_SIZE);
//                    gyosi.setTextColor(Color.BLACK);
//                    gyosi.setPadding(70, 5,0,15);
//
//                    cvalues.put("SUBJECT", sbj);
//                    cvalues.put("CLASSROOM", cla);
//                    cvalues.put("PROFESSOR", pro);
//                    cvalues.put("DAY", daaay);
//                    cvalues.put("HOUR_START", hs);
//                    cvalues.put("MIN_START", ms);
//                    cvalues.put("HOUR_END", he);
//                    cvalues.put("MIN_END", me);
//                    database.insert("majortimetable_exist", null, cvalues);
//
//                    add.addView(day);
//                    add.addView(professor);
//                    add.addView(gyosi);
//                    add.setBackgroundResource(R.drawable.line_timetable);
//                    add.setBackgroundColor(Color.parseColor("#FFE4E1"));
//                    timeTableSET_Wed.addView(add);
//
//                } else if (daaay.equals("목요일")) {
//                    day.setText(daaay + "        " + sbj);
//                    day.setTextSize(FONT_SIZE);
//                    day.setTextColor(Color.parseColor("#6495ED"));
//                    day.setPadding(70, 15,0,0);
//                    professor.setText(pro + "    " + cla);
//                    professor.setTextSize(FONT_SIZE);
//                    professor.setTextColor(Color.BLACK);
//                    professor.setPadding(70, 5, 0,0);
//                    gyosi.setText(gyo + "    " + "(" + hs + "시 " + ms + "분 ~ " + he + "시 " + me + "분" + ")");
//                    gyosi.setTextSize(FONT_SIZE);
//                    gyosi.setTextColor(Color.BLACK);
//                    gyosi.setPadding(70, 5,0,15);
//
//                    cvalues.put("SUBJECT", sbj);
//                    cvalues.put("CLASSROOM", cla);
//                    cvalues.put("PROFESSOR", pro);
//                    cvalues.put("DAY", daaay);
//                    cvalues.put("HOUR_START", hs);
//                    cvalues.put("MIN_START", ms);
//                    cvalues.put("HOUR_END", he);
//                    cvalues.put("MIN_END", me);
//                    database.insert("majortimetable_exist", null, cvalues);
//
//                    add.addView(day);
//                    add.addView(professor);
//                    add.addView(gyosi);
//                    add.setBackgroundResource(R.drawable.line_timetable);
//                    add.setBackgroundColor(Color.parseColor("#E0FFFF"));
//                    timeTableSET_Thu.addView(add);
//
//                } else if (daaay.equals("금요일")){
//                    day.setText(daaay + "        " + sbj);
//                    day.setTextSize(FONT_SIZE);
//                    day.setTextColor(Color.parseColor("#6495ED"));
//                    day.setPadding(70, 15,0,0);
//                    professor.setText(pro + "    " + cla);
//                    professor.setTextSize(FONT_SIZE);
//                    professor.setTextColor(Color.BLACK);
//                    professor.setPadding(70, 5, 0,0);
//                    gyosi.setText(gyo + "    " + "(" + hs + "시 " + ms + "분 ~ " + he + "시 " + me + "분" + ")");
//                    gyosi.setTextSize(FONT_SIZE);
//                    gyosi.setTextColor(Color.BLACK);
//                    gyosi.setPadding(70, 5,0,15);
//
//                    cvalues.put("SUBJECT", sbj);
//                    cvalues.put("CLASSROOM", cla);
//                    cvalues.put("PROFESSOR", pro);
//                    cvalues.put("DAY", daaay);
//                    cvalues.put("HOUR_START", hs);
//                    cvalues.put("MIN_START", ms);
//                    cvalues.put("HOUR_END", he);
//                    cvalues.put("MIN_END", me);
//                    database.insert("majortimetable_exist", null, cvalues);
//
//                    add.addView(day);
//                    add.addView(professor);
//                    add.addView(gyosi);
//                    add.setBackgroundResource(R.drawable.line_timetable);
//                    add.setBackgroundColor(Color.parseColor("#F0F8FF"));
//                    timeTableSET_Fri.addView(add);
//                }
//            }
//        }
    }
    public String[] mColors = {
            "FFA07A", "FFDAB9", "FFDEAD", "FFA500", "FFFF00", "98FB98", "B0E0E6",
            "AFEEEE", "87CEEB", "E6E6FA", "DDA0DD", "FFB6C1", "FFE4E1", "FFFFE0",
            "FFF8DC", "FAF0E6", "E0FFFF", "F0F8FF", "FFF0F5", "F8F8FF", "FFF5EE",
    };
}