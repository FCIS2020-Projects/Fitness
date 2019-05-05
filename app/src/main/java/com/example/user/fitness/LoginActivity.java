package com.example.user.fitness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.fitness.Database.DbHelper;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText passwordEditText;
    Button loginBtn;
    TextView goToRegisteration;
    SharedPreferences sharedPreferences;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.login_email);
        passwordEditText = findViewById(R.id.login_password);
        loginBtn = findViewById(R.id.login_btn);
        goToRegisteration = findViewById(R.id.go_to_registration);

        sharedPreferences = getSharedPreferences(getString(R.string.shared_pref),MODE_PRIVATE);

        dbHelper = new DbHelper(this);

        boolean loggedIn = sharedPreferences.getBoolean(getString(R.string.auto_login),false);
        if (loggedIn) {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                ArrayList<User> users = dbHelper.getUsers();
                String inputEmail = emailEditText.getText().toString();
                String inputPassword = passwordEditText.getText().toString();

                boolean found = false;
                for (User user : users)
                {
                    if(user.getmEmail().equals(inputEmail) && user.getmPassword().equals(inputPassword)){
                        editor.putString(getString(R.string.email), inputEmail);
                        editor.putBoolean(getString(R.string.auto_login), true);
                        editor.apply();

                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        found = true;
                    }

                }
                if(!found)
                    Toast.makeText(LoginActivity.this,"Invalid Email or Password",Toast.LENGTH_SHORT).show();

            }
        });
        goToRegisteration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        emailEditText.setText("");
        passwordEditText.setText("");

        boolean loggedIn = sharedPreferences.getBoolean(getString(R.string.auto_login),false);
        if (loggedIn) {
            finish();
        }
    }
}
