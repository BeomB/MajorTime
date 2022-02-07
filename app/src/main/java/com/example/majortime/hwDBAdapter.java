
package com.example.majortime;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class hwDBAdapter extends CursorAdapter {
    public hwDBAdapter(Context context, Cursor c){
        super(context, c);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        ImageButton btndel = (ImageButton)view.findViewById(R.id.delete);
        final TextView title = (TextView)view.findViewById(R.id.tv1);
        final TextView content= (TextView)view.findViewById(R.id.tv2);
        final TextView id = (TextView)view.findViewById(R.id.id);
        final TextView timeId = (TextView)view.findViewById(R.id.time_id);
        final TextView time = (TextView)view.findViewById(R.id.timeshow);


        int hour,minute,year,month,day;
        hour = cursor.getInt(cursor.getColumnIndex("hour"));
        minute = cursor.getInt(cursor.getColumnIndex("minute"));
        year = cursor.getInt(cursor.getColumnIndex("year"));
        month = cursor.getInt(cursor.getColumnIndex("month"));
        day = cursor.getInt(cursor.getColumnIndex("day"));
        time.setText("과제기간 : "+year+"년 "+month+"월 "+day+"일 "+hour+"시" +minute+"분");


        id.setText(cursor.getString(cursor.getColumnIndex("_id")));
        title.setText(cursor.getString(cursor.getColumnIndex("title")));
        content.setText(cursor.getString(cursor.getColumnIndex("content")));


        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hwDBHelper dbHelper = new hwDBHelper(context,4);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String idKey = id.getText().toString();
                String timeKey = timeId.getText().toString();
                db.execSQL("DELETE FROM homework WHERE _id ='"+idKey+"';");
            }
        });
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.homework_clicked, parent, false);
        return v;
    }

}

