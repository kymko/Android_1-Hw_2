package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.graphics.Color.*;

public class LoginActivity extends AppCompatActivity {

    EditText textEmail;
    EditText textPassword;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);
        btn = findViewById(R.id.button);


        String inputName = textEmail.getText().toString();
        String inputPassword = textPassword.getText().toString();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate2()) {
                    validate1(inputName, inputPassword);
                }
            }
        });
    }


    public void validate1(String userName, String userPassword) {

        if ((userName.equals("")) && (userPassword.equals(""))) {
            Intent intent = new Intent(LoginActivity.this, CalculatorActivity.class);
            startActivity(intent);
            Toast toast = Toast.makeText(this, "Вам разрешен доступ к калькулятору!", Toast.LENGTH_LONG);
            toast.show();
        }
        btn.setBackgroundColor(GREEN);
    }

    public Boolean validate2() {

        boolean result = false;

        String name = textEmail.getText().toString();
        String pasw = textPassword.getText().toString();

        if ((name.isEmpty()) || (pasw.isEmpty())) {
            Toast toast = Toast.makeText(this, "Заполните все поля!!!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            result = true;
        }
        return result;
    }
}