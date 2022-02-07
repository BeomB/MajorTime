package com.example.majortime;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Home_Fragment extends Fragment {
    View v;
    static String snewstext1,snewstext2,stitle1,stitle2,surl1,surl2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =  (View) inflater.inflate(R.layout.home_fragment,container,false);
        configureImageButton();
        return v;
    }
    private void configureImageButton() {
        ImageButton Home = (ImageButton) v.findViewById(R.id.home);
        ImageButton Bus = (ImageButton) v.findViewById(R.id.bus);
        ImageButton Calender = (ImageButton) v.findViewById(R.id.calender);
        ImageButton Speaker = (ImageButton) v.findViewById(R.id.speaker);
        ImageButton Library = (ImageButton) v.findViewById(R.id.library);
        TextView news1 =(TextView)v.findViewById(R.id.newstext1);
        TextView news2 =(TextView)v.findViewById(R.id.newstext2);


        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SchoolHome_Internet.class);
                startActivity(intent);
            }
        });
        Bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SchoolBus_Internet.class);
                startActivity(intent);
            }
        });
        Speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SchoolSpeaker_Internet.class);
                startActivity(intent);
            }
        });
        Calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SchoolCalender_Internet.class);
                startActivity(intent);
            }
        });
        Library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SchoolLibrary_Internet.class);
                startActivity(intent);
            }
        });

        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),new1_Internet.class);
                startActivity(intent);
            }
        });

        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), new2_Internet.class);
                startActivity(intent);
            }
        });


        MyDBHelper mHelper = new MyDBHelper(getActivity());
        SQLiteDatabase db;
        db = mHelper.getWritableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("select  title1 , newstext1,url1,title2 , newstext2,url2 from News WHERE textnum='" + 1 + "' ", null);
        snewstext1="";snewstext2="";stitle1="";stitle2=""; surl1="";
        while (cursor.moveToNext()){
            String title1 =cursor.getString(0);
            String Newstext1 =cursor.getString(1);
            String url1 =cursor.getString(2);
            String title2  =cursor.getString(3);
            String Newstext2 =cursor.getString(4);
           String url2 =cursor.getString(5);

            stitle1+=title1;
            stitle2+=title2;
            snewstext1+=Newstext1;
            snewstext2+=Newstext2;
            surl1+= url1;
            surl2+= url2;
            cursor.close();
            mHelper.close();

        }
        news1.setText(snewstext1);
        news2.setText(snewstext2);
    }
        @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
