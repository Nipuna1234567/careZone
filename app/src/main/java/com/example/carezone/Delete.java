package com.example.carezone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;

public class Delete<ActivityDeleteDataBinding> extends AppCompatActivity {

    ActivityDeleteDataBinding binding;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeleteDataBinding.inflate(getResources().getLayout());
        setContentView(R.layout.activity_delete);

        binding.

    }
}