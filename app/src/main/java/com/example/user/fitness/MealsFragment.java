package com.example.user.fitness;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.user.fitness.Database.DbHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MealsFragment extends Fragment {
    EditText mealName;
    EditText mealCalories;
    DbHelper dbHelper;
    Button newMealBtn;
    MealAdapter adapter;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_meals,container,false);

        ListView listView = rootView.findViewById(R.id.meals_list_view);
        mealName = rootView.findViewById(R.id.meal_name_edit);
        mealCalories = rootView.findViewById(R.id.meal_calories_edit);
        newMealBtn = rootView.findViewById(R.id.new_meal_btn);
        dbHelper = new DbHelper(getContext());
        sharedPreferences = getContext().getSharedPreferences(getString(R.string.shared_pref), Context.MODE_PRIVATE);

        final String userEmail = sharedPreferences.getString(getString(R.string.email), "");

        ArrayList<Meal> meals = dbHelper.getMeals(userEmail);
        adapter = new MealAdapter(getActivity(), meals);

        newMealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateFormat df = DateFormat.getDateInstance();
                Meal meal = new Meal(mealName.getText().toString(), Integer.parseInt(mealCalories.getText().toString())
                        , df.format(Calendar.getInstance().getTime()));
                long id = dbHelper.AddMeal(meal, userEmail);
                adapter.add(meal);

                mealName.setText("");
                mealCalories.setText("");
            }
        });

        listView.setAdapter(adapter);
        return rootView;
    }
}
