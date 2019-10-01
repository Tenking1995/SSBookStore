package com.example.ssbookstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    String userId, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("SSBookStore");
        setContentView(R.layout.activity_login);



        //Login Button clicked
        Button loginButton = (Button) findViewById(R.id.btnlogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etUserId = (EditText) findViewById(R.id.etUserId);
                EditText etpassword = (EditText) findViewById(R.id.etPassword);
                userId = etUserId.getText().toString();
                password = etpassword.getText().toString();
                if(validationCheck(userId, password)){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validationCheck(String userId, String Password){
        if(userId.equals("SS") && Password.equals("11111")){
            return true;
        }else {
            return false;
        }
    }
}
