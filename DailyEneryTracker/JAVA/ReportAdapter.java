package com.example.pwin.lab5;
//Peng Xie 40328958
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends ArrayAdapter<Entry> {
    private Context mContext;
    private List<Entry> dayList = new ArrayList<Entry>();
    public ReportAdapter(Context context, ArrayList<Entry> list) {
        super(context, 0, list);
        mContext = context;
        dayList = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.food_list,parent,false);
        }
        Entry currentEntry = dayList.get(position);
        TextView day = (TextView) listItem.findViewById(R.id.name_textView);
        TextView num = (TextView) listItem.findViewById(R.id.calorie_textView);

        day.setText(currentEntry.getDay());
        num.setText(currentEntry.getEnergy());

        return listItem;
    }
}
