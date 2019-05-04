package com.example.user.fitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DietPlanAdapter extends ArrayAdapter<DietPlan> {
    public DietPlanAdapter(Context context, ArrayList<DietPlan> dietPlans) {
        super(context,0, dietPlans);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.diet_plan_list_item,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder) convertView.getTag();

        final DietPlan dietPlan = getItem(position);

        viewHolder.name.setText(dietPlan.getmName());

        viewHolder.image.setImageResource(dietPlan.getmImage());

        return convertView;
    }

    class ViewHolder {
        private TextView name;
        private ImageView image;
        public ViewHolder(View itemView) {
            name = itemView.findViewById(R.id.diet_plan_name);
            image = itemView.findViewById(R.id.diet_plan_image);
        }
    }
}
