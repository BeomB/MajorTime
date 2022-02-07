package com.example.majortime;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.majortime.VO.Schedule_VO;

import java.util.ArrayList;
import java.util.List;

public class TimeTable_Fragment extends Fragment {
    private static int ONE_MINUTE = 5626;

    LinearLayout timeTableSET_Mon,timeTableSET_Tue,timeTableSET_Wed,timeTableSET_Thu,timeTableSET_Fri;
    LinearLayout.LayoutParams params;
    private static final float FONT_SIZE = 15;
    private static final float FONT_SIZE2 = 17;

    MyDBHelper myDBHelper;
    SQLiteDatabase database;
    String id;
    View v;
    Cursor cursor1;
    static String tid = "";
    String shared = "sungjae";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = (View) inflater.inflate(R.layout.schedule_fragment,container,false);

        timeTableSET_Mon = (LinearLayout) v.findViewById(R.id.timeTablaSET_Mon);
        timeTableSET_Tue = (LinearLayout) v.findViewById(R.id.timeTablaSET_Tue);
        timeTableSET_Wed = (LinearLayout) v.findViewById(R.id.timeTablaSET_Wed);
        timeTableSET_Thu = (LinearLayout) v.findViewById(R.id.timeTablaSET_Thu);
        timeTableSET_Fri = (LinearLayout) v.findViewById(R.id.timeTablaSET_Fri);
        Button cal = (Button) v.findViewById(R.id.calbtn);
//        ToggleButton TB = (ToggleButton) v.findViewById(R.id.AlarmSetBtn);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentcal = new Intent(getActivity(), CalcuActivity.class);
                startActivity(intentcal);
            }
        });

        schedule();

        return v;
    }

    private void schedule() {

        Intent intent = new Intent(this.getActivity().getIntent());

        Intent it = new Intent(getActivity().getIntent());
        String value_id = it.getStringExtra("IIIDDD");

        myDBHelper = new MyDBHelper(getActivity());
        database = myDBHelper.getWritableDatabase();
        final ContentValues cvalues = new ContentValues();

        Schedule_VO SVO = new Schedule_VO();
        ArrayList<Schedule_VO> list = (ArrayList<Schedule_VO>) intent.getSerializableExtra("list");

        final List<String> list1 = new ArrayList<>();
        cursor1 = database.rawQuery("SELECT ID FROM majorjoin", null );
        while (cursor1.moveToNext()) {
            String idkey = cursor1.getString(0);
            tid += idkey;
            list1.add(tid);
            tid = "";
        }
        Cursor cursor3 = database.rawQuery("select NUM, SUBJECT , CLASSROOM, PROFESSOR, DAY, HOUR_START, MIN_START, HOUR_END, MIN_END,GYOSI from majortimetable", null);
        String RNUM = "", RSUBJECT = "", RCLASSROOM ="", RPROFESSOR = "", RDAY = "", RHOUR_START = "", RMIN_START = "", RHOUR_END = "", RMIN_END = "", RGYOSI = "";

        if (list1.contains(value_id)) {
            while (cursor3.moveToNext()) {
                String Rnumber = cursor3.getString(0);
                String Rsubject = cursor3.getString(1);
                String Rclassroom = cursor3.getString(2);
                String Rprofessor = cursor3.getString(3);
                String RDay = cursor3.getString(4);
                String Rhour_s = cursor3.getString(5);
                String Rmin_s = cursor3.getString(6);
                String Rhour_e = cursor3.getString(7);
                String Rmin_e = cursor3.getString(8);
                String RGyosi = cursor3.getString(9);

                RNUM = Rnumber;
                RSUBJECT = Rsubject;
                RCLASSROOM = Rclassroom;
                RPROFESSOR = Rprofessor;
                RDAY = RDay;
                RHOUR_START = Rhour_s;
                RMIN_START = Rmin_s;
                RHOUR_END = Rhour_e;
                RMIN_END = Rmin_e;
                RGYOSI = RGyosi;

                LinearLayout add = new LinearLayout(getActivity());

                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                add.setLayoutParams(params);
                add.setOrientation(LinearLayout.VERTICAL);
                add.setBackgroundResource(R.drawable.line_timetable_detail);

                TextView subject = new TextView(getActivity());
                TextView professor = new TextView(getActivity());
                TextView classroom = new TextView(getActivity());
                TextView gyosi = new TextView(getActivity());
                TextView day = new TextView(getActivity());
                TextView time = new TextView(getActivity());

                if (RDAY.equals("월요일")){
                    day.setText(RDAY + "        " + RSUBJECT);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6466ed"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RPROFESSOR + "    " + RCLASSROOM);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(RGYOSI + "    " + "(" + RHOUR_START + "시 " + RMIN_START + "분 ~ " + RHOUR_END + "시 " + RMIN_END + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#fcf4b8"));
                    timeTableSET_Mon.addView(add);

                } else if (RDAY.equals("화요일")){
                    day.setText(RDAY + "        " + RSUBJECT);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6466ed"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RPROFESSOR + "    " + RCLASSROOM);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(RGYOSI + "    " + "(" + RHOUR_START + "시 " + RMIN_START + "분 ~ " + RHOUR_END + "시 " + RMIN_END + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#fcdeff"));
                    timeTableSET_Tue.addView(add);
                } else if (RDAY.equals("수요일")){
                    day.setText(RDAY + "        " + RSUBJECT);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6466ed"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RPROFESSOR + "    " + RCLASSROOM);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(RGYOSI + "    " + "(" + RHOUR_START + "시 " + RMIN_START + "분 ~ " + RHOUR_END + "시 " + RMIN_END + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#ffcfd6"));
                    timeTableSET_Wed.addView(add);
                } else if (RDAY.equals("목요일")){
                    day.setText(RDAY + "        " + RSUBJECT);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6466ed"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RPROFESSOR + "    " + RCLASSROOM);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(RGYOSI + "    " + "(" + RHOUR_START + "시 " + RMIN_START + "분 ~ " + RHOUR_END + "시 " + RMIN_END + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#d7ecfc"));
                    timeTableSET_Thu.addView(add);
                } else if (RDAY.equals("금요일")){
                    day.setText(RDAY + "        " + RSUBJECT);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6466ed"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RPROFESSOR + "    " + RCLASSROOM);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(RGYOSI + "    " + "(" + RHOUR_START + "시 " + RMIN_START + "분 ~ " + RHOUR_END + "시 " + RMIN_END + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#d0e8c8"));
                    timeTableSET_Fri.addView(add);
                }
            }
        }


        String RSubject ="";
        String RProfessor ="";
        String RClassroom ="";
        String Rgyosi ="";
        String Rday ="";
        Integer Rhour_start = 0, Rhour_end = 0, Rmin_start = 0, Rmin_end = 0, Rnum = -1;


        //////////////----------새로 추가한 값 ------------//////////////////
        if (list != null) {     //timetable에서 넘어온 list에 값이 제대로 들어있다면!
            for (Schedule_VO svo : list) {      //majortimetalbe에 들어있는 값
                Rgyosi = svo.getGyosi();
                Rday = svo.getDay();
                RSubject = svo.getSubject();
                RProfessor = svo.getProfessor();
                RClassroom = svo.getClassroom();
                Rhour_start = Integer.parseInt(svo.getHour_start());
                Rhour_end = Integer.parseInt(svo.getHour_end());
                Rmin_start = Integer.parseInt(svo.getMin_start());
                Rmin_end = Integer.parseInt(svo.getMin_end());

                LinearLayout add = new LinearLayout(getActivity());

                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                add.setLayoutParams(params);
                add.setOrientation(LinearLayout.VERTICAL);
                add.setBackgroundResource(R.drawable.line_timetable_detail);

                TextView subject = new TextView(getActivity());
                TextView professor = new TextView(getActivity());
                TextView classroom = new TextView(getActivity());
                TextView gyosi = new TextView(getActivity());
                TextView day = new TextView(getActivity());
                TextView time = new TextView(getActivity());

                if (Rday.equals("월요일")){
                    day.setText(Rday + "        " + RSubject);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6495ED"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RProfessor + "    " + RClassroom);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(Rgyosi + "    " + "(" + Rhour_start + "시 " + Rmin_start + "분 ~ " + Rhour_end + "시 " + Rmin_end + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    cvalues.put("SUBJECT", RSubject);
                    cvalues.put("CLASSROOM", RClassroom);
                    cvalues.put("PROFESSOR", RProfessor);
                    cvalues.put("DAY", Rday);
                    cvalues.put("HOUR_START", Rhour_start);
                    cvalues.put("MIN_START", Rmin_start);
                    cvalues.put("HOUR_END", Rhour_end);
                    cvalues.put("MIN_END", Rmin_end);
                    cvalues.put("GYOSI", Rgyosi);
                    database.insert("majortimetable_exist", null, cvalues);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#fcf4b8"));
                    timeTableSET_Mon.addView(add);

                } else if (Rday.equals("화요일")){
                    day.setText(Rday + "        " + RSubject);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6495ED"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RProfessor + "    " + RClassroom);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(Rgyosi + "    " + "(" + Rhour_start + "시 " + Rmin_start + "분 ~ " + Rhour_end + "시 " + Rmin_end + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    cvalues.put("SUBJECT", RSubject);
                    cvalues.put("CLASSROOM", RClassroom);
                    cvalues.put("PROFESSOR", RProfessor);
                    cvalues.put("DAY", Rday);
                    cvalues.put("HOUR_START", Rhour_start);
                    cvalues.put("MIN_START", Rmin_start);
                    cvalues.put("HOUR_END", Rhour_end);
                    cvalues.put("MIN_END", Rmin_end);
                    database.insert("majortimetable_exist", null, cvalues);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#fcdeff"));
                    timeTableSET_Tue.addView(add);

                } else if (Rday.equals("수요일")) {
                    day.setText(Rday + "        " +  RSubject);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6495ED"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RProfessor + "    " + RClassroom);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(Rgyosi + "    " + "(" + Rhour_start + "시 " + Rmin_start + "분 ~ " + Rhour_end + "시 " + Rmin_end + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    cvalues.put("SUBJECT", RSubject);
                    cvalues.put("CLASSROOM", RClassroom);
                    cvalues.put("PROFESSOR", RProfessor);
                    cvalues.put("DAY", Rday);
                    cvalues.put("HOUR_START", Rhour_start);
                    cvalues.put("MIN_START", Rmin_start);
                    cvalues.put("HOUR_END", Rhour_end);
                    cvalues.put("MIN_END", Rmin_end);
                    database.insert("majortimetable_exist", null, cvalues);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#ffcfd6"));
                    timeTableSET_Wed.addView(add);

                } else if (Rday.equals("목요일")) {
                    day.setText(Rday + "        " + RSubject);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6495ED"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RProfessor + "    " + RClassroom);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(Rgyosi + "    " + "(" + Rhour_start + "시 " + Rmin_start + "분 ~ " + Rhour_end + "시 " + Rmin_end + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    cvalues.put("SUBJECT", RSubject);
                    cvalues.put("CLASSROOM", RClassroom);
                    cvalues.put("PROFESSOR", RProfessor);
                    cvalues.put("DAY", Rday);
                    cvalues.put("HOUR_START", Rhour_start);
                    cvalues.put("MIN_START", Rmin_start);
                    cvalues.put("HOUR_END", Rhour_end);
                    cvalues.put("MIN_END", Rmin_end);
                    database.insert("majortimetable_exist", null, cvalues);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#d7ecfc"));
                    timeTableSET_Thu.addView(add);

                } else if (Rday.equals("금요일")){
                    day.setText(Rday + "        " + RSubject);
                    day.setTextSize(FONT_SIZE2);
                    day.setTextColor(Color.parseColor("#6495ED"));
                    day.setPadding(70, 15,0,0);
                    professor.setText(RProfessor + "    " + RClassroom);
                    professor.setTextSize(FONT_SIZE);
                    professor.setTextColor(Color.parseColor("#545252"));
                    professor.setPadding(70, 5, 0,0);
                    gyosi.setText(Rgyosi + "    " + "(" + Rhour_start + "시 " + Rmin_start + "분 ~ " + Rhour_end + "시 " + Rmin_end + "분" + ")");
                    gyosi.setTextSize(FONT_SIZE);
                    gyosi.setTextColor(Color.parseColor("#545252"));
                    gyosi.setPadding(70, 5,0,15);

                    cvalues.put("SUBJECT", RSubject);
                    cvalues.put("CLASSROOM", RClassroom);
                    cvalues.put("PROFESSOR", RProfessor);
                    cvalues.put("DAY", Rday);
                    cvalues.put("HOUR_START", Rhour_start);
                    cvalues.put("MIN_START", Rmin_start);
                    cvalues.put("HOUR_END", Rhour_end);
                    cvalues.put("MIN_END", Rmin_end);
                    database.insert("majortimetable_exist", null, cvalues);

                    add.addView(day);
                    add.addView(professor);
                    add.addView(gyosi);
                    add.setBackgroundResource(R.drawable.line_timetable);
                    add.setBackgroundColor(Color.parseColor("#d0e8c8"));
                    timeTableSET_Fri.addView(add);
                }
            }

        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}