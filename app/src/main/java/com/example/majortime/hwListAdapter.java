
package com.example.majortime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class hwListAdapter extends BaseAdapter {
    private TextView titleT;
    private TextView ContentT;
    private TextView ID;
    private TextView timeID;
    private ArrayList <hwListViewItem> listViewItemList= new ArrayList<hwListViewItem>();


    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Context context = parent.getContext();
        final hwListViewItem listViewItem = listViewItemList.get(position);
        if(convertView==null) {
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.homework_item,parent,false);
        }
        titleT=(TextView)convertView.findViewById(R.id.title);
        ContentT=(TextView)convertView.findViewById(R.id.content);
        ID = (TextView)convertView.findViewById(R.id.id);
        timeID = (TextView)convertView.findViewById(R.id.time_id);


        ID.setText(listViewItem.getId());
        titleT.setText(listViewItem.getTitle());
        ContentT.setText(listViewItem.getContent());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }
}
