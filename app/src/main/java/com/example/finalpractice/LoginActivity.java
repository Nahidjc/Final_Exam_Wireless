package com.example.finalpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
EditText studentidText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        studentidText = findViewById(R.id.studentid);
        passwordText = findViewById(R.id.passwordID);

    }

    public void LoginFunction(View view) {
        String password = passwordText.getText().toString();
        char checkPass = password.charAt(4);
        if(checkPass=='s'){
            Toast.makeText(this, "Login failed!Enter your password again!", Toast.LENGTH_SHORT).show();
        }else{
            Intent myIntent = new Intent(LoginActivity.this,MainActivity.class);
             startActivity(myIntent );
        }

    }
}