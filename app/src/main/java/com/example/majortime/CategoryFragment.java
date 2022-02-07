package com.example.majortime;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class CategoryFragment extends Fragment {

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=(View)inflater.inflate(R.layout.category_fragment,container,false);
        text();
        return v;

    }

    private void text(){
        TextView textbtn = (TextView)v.findViewById(R.id.textbtn);
        TextView exambtn = (TextView)v.findViewById(R.id.exambtn);
        TextView placebtn = (TextView)v.findViewById(R.id.placebtn);
        TextView circlebtn = (TextView)v.findViewById(R.id.circelbtn);
        TextView Activebtn = (TextView)v.findViewById(R.id.activebtn);
        TextView homeworkbtn = (TextView)v.findViewById(R.id.homeworkbtn);

        homeworkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(),HomeworkActivity.class);
                startActivity(intent1);
            }
        });


        textbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TextListviewActivity.class);
                startActivity(intent);
            }
        });

        exambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExamListviewActivity.class);
                startActivity(intent);
            }
        });

        placebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsLibraryActivity.class);
                startActivity(intent);
            }
        });

        circlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CircleListviewActivity.class);
                startActivity(intent);
            }
        });


        Activebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActiveListviewActivity.class);
                startActivity(intent);
            }
        });


    }


}
