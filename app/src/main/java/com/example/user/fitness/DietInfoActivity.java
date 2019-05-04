package com.example.user.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DietInfoActivity extends AppCompatActivity {

    TextView planTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_info);

        Intent intent = getIntent();
        String plan = intent.getStringExtra("diet_plan");

        planTextView = findViewById(R.id.diet_text_view);
        planTextView.setText(plan);
    }
}
