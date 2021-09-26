package com.example.carezone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.ktx.Firebase;


public class feedback extends AppCompatActivity {
    EditText namedata, weekdata, emaildata,feedbackdata;
    Button send, details;
    Firebase firebase;


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
        Firebase.setAndroidContext(this);




        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details.setEnabled(true);
                String name = namedata.getText().toString();
                String week = weekdata.getText().toString();
                String email = emaildata.getText().toString();
                String feedback = feedbackdata.getText().toString();


                Firebase child_name = firebase.child("Name");
                child_name.setValue(name);
                if (name.isEmpty()) {
                    namedata.setError("This is a required field!");
                    send.setEnabled(false);

                } else {
                    namedata.setError(null);
                    send.setEnabled(true);
                }


                Firebase child_week = firebase.child("Week");
                child_week.setValue(week);
                if (week.isEmpty()) {
                    weekdata.setError("This is an required field!");
                    send.setEnabled(false);

                } else {
                    weekdata.setError(null);
                    send.setEnabled(true);
                }

                Firebase child_email = firebase.child("Email");
                child_email.setValue(email);
                if (email.isEmpty()) {
                    emaildata.setError("This is an required field!");
                    send.setEnabled(false);

                } else {
                    emaildata.setError(null);
                    send.setEnabled(true);
                }

                Firebase child_feedback = firebase.child("Feedback");
                child_feedback.setValue(email);
                if (feedback.isEmpty()) {
                    feedbackdata.setError("This is an required field!");
                    send.setEnabled(false);

                } else {
                    feedbackdata.setError(null);
                    send.setEnabled(true);
                }


            }




        });
    }


}