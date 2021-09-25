package com.example.carezone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CareLog extends AppCompatActivity {
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

    }

    public void btnLogin_Click(View view) {

    }
    public void btnRegister_Click(View view) {
        Intent register = new Intent( CareLog.this,Register.class);
        startActivity(register);

    }
}