package com.example.user.fitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.fitness.Database.DbHelper;

import java.util.ArrayList;

public class MealAdapter extends ArrayAdapter<Meal> {
    public MealAdapter(Context context, ArrayList<Meal> meals) {
        super(context,0, meals);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MealAdapter.ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.meal_list_item,parent,false);
            viewHolder = new MealAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (MealAdapter.ViewHolder) convertView.getTag();

        final Meal meal = getItem(position);

        viewHolder.name.setText(meal.getmName());
        viewHolder.calories.setText(String.valueOf(meal.getmCalories()));
        viewHolder.date.setText(meal.getmDate());


        return convertView;
    }

    class ViewHolder {
        private TextView name;
        private TextView calories;
        private TextView date;
        public ViewHolder(View itemView) {
            name = itemView.findViewById(R.id.meal_name);
            calories = itemView.findViewById(R.id.meal_calories);
            date = itemView.findViewById(R.id.meal_date);
        }
    }
}
