package com.example.pwin.lab5;
//Peng Xie 40328958
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {
    private Context mContext;
    private List<Food> foodList = new ArrayList<Food>();

    public FoodAdapter(Context c, ArrayList<Food> list){
        super(c, 0 , list);
        mContext = c;
        foodList = list;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.food_list,parent,false);
        }
        Food currentFood = foodList.get(position);
        TextView name = (TextView) listItem.findViewById(R.id.name_textView);
        name.setText(currentFood.getName());

        TextView calories = (TextView) listItem.findViewById(R.id.calorie_textView);
        calories.setText(currentFood.getEnergy());

        return listItem;
    }
}
