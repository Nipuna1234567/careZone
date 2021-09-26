package com.example.carezone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class feedback extends AppCompatActivity {

    EditText namedata, weekdata, emaildata,feedbackdata;
    Button send, details;

    DatabaseReference ref;

    long maxid=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namedata = findViewById(R.id.namedata);
        weekdata = findViewById(R.id.weekdata);
        emaildata = findViewById(R.id.emaildata);
        feedbackdata = findViewById(R.id.feedbackdata);

        send = findViewById(R.id.btn_send);
        details = findViewById(R.id.btn_details);



        ref = FirebaseDatabase.getInstance().getReference().child("fdata");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                    maxid = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details.setEnabled(true);
                String name = namedata.getText().toString();
                String week = weekdata.getText().toString();
                String email = emaildata.getText().toString();
                String feedback = feedbackdata.getText().toString();


                ref = FirebaseDatabase.getInstance().getReference().child("fdata");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists())
                            maxid = (snapshot.getChildrenCount());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}


