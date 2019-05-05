package com.example.user.fitness;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.fitness.Database.DbHelper;

public class RegistrationActivity extends AppCompatActivity {

    EditText emailEditText;
    EditText confirmEmailEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;
    Button registerBtn;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        emailEditText = findViewById(R.id.register_email);
        confirmEmailEditText = findViewById(R.id.register_confirm_email);
        passwordEditText = findViewById(R.id.register_password);
        confirmPasswordEditText = findViewById(R.id.register_confirm_password);
        registerBtn = findViewById(R.id.register_btn);

        dbHelper = new DbHelper(this);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email;
                if(emailEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(RegistrationActivity.this, "Write a Valid Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(emailEditText.getText().toString().equals(confirmEmailEditText.getText().toString()))
                    email = emailEditText.getText().toString();
                else
                {
                    Toast.makeText(getApplicationContext(), "Email doesn't match", Toast.LENGTH_SHORT).show();
                    return;
                }

                String password;
                if(passwordEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(RegistrationActivity.this, "Write a Valid Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(passwordEditText.getText().toString().equals(confirmPasswordEditText.getText().toString()))
                    password = passwordEditText.getText().toString();
                else
                {
                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                    return;
                }

                long res = dbHelper.AddUser(new User(email, password));
                if(res != -1)
                {
                    finish();
                    Toast.makeText(RegistrationActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RegistrationActivity.this, "Email Already Exists", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
