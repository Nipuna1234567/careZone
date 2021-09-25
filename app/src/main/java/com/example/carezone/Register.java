package com.example.carezone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText username,email,password,age;
    private Customer customer;
    FirebaseDatabase database;
    DatabaseReference ref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        age = (EditText) findViewById(R.id.age);

        customer = new Customer();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Customer");

    }
    public void btnRegister_Click(View view) {
        customer.setUsername(username.getText().toString());
        customer.setUsername(email.getText().toString());
        customer.setUsername(password.getText().toString());
        customer.setUsername(age.getText().toString());

        ref.child(customer.getUsername()).setValue(customer);


    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }



}

