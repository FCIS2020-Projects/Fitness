package com.example.user.fitness;

import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.user.fitness.Database.DbHelper;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    TextView caloriesLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        View navHeader = navigationView.getHeaderView(0);
        caloriesLeft = navHeader.findViewById(R.id.user_calories_left);

        sharedPreferences = getSharedPreferences(getString(R.string.shared_pref),MODE_PRIVATE);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                Fragment fragment = new Fragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                switch (item.getItemId())
                {
                    case R.id.meals:
                        fragment = new MealsFragment();
                        break;
                    case R.id.workout:
                        fragment = new WorkoutFragment();
                        break;
                    case R.id.dite:
                        fragment = new DietFragment();
                        break;
                    case R.id.blogs:
                        fragment = new BlogFragment();
                        break;
                    case R.id.logout:
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean(getString(R.string.auto_login),false);
                        editor.commit();
                        finish();
                        break;

                }

                fragmentManager.beginTransaction().replace(R.id.content_frame,fragment).commit();

                item.setChecked(true);

                setTitle(item.getTitle());
                drawerLayout.closeDrawers();

                return true;
            }
        });

        setCaloriesLeft();

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame,new MealsFragment()).commit();

    }

    private void setCaloriesLeft()
    {
        DbHelper dbHelper = new DbHelper(this);
        String userEmail = sharedPreferences.getString(getString(R.string.email), "");
        int calories = dbHelper.getUser(userEmail).getmDailyCalories();
        DateFormat df = DateFormat.getDateInstance();
        ArrayList<Meal> todayMeals = dbHelper.getMeals(userEmail, df.format(Calendar.getInstance().getTime()));
        for(int i = 0 ; i < todayMeals.size() ; i++)
        {
            calories -= todayMeals.get(i).getmCalories();
        }
        caloriesLeft.setText(String.valueOf(calories));
    }
    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case android.R.id.home:
                setCaloriesLeft();
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
