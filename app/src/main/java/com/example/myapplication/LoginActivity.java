package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView textEnter;
    TextView textWelcome;
    TextView textAction;
    TextView textRegister;
    EditText textEmail;
    EditText textPassword;
    Button btn;
    TextView textForgot;
    public int counter = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEnter = findViewById(R.id.textEnter);
        textWelcome = findViewById(R.id.textWelcome);
        textAction = findViewById(R.id.textAction);
        textRegister = findViewById(R.id.textRegister);
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);
        btn = findViewById(R.id.button);
        textForgot = findViewById(R.id.textForgot);
        textEmail.setBackgroundColor(Color.WHITE);


        String inputName = textEmail.getText().toString();
        String inputPassword = textPassword.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(inputName,inputPassword);

            }
        });

    }
    public void validate(String userName, String userPassword) {
        if ((userName.equals("")) && (userPassword.equals(""))) {
            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast toast = Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}