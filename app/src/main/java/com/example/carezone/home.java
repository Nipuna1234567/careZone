package com.example.carezone;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity implements View.OnClickListener {

      public CardView card1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        card1 = (CardView) findViewById(R.id.cardfoods);


        card1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()) {

            case R.id.cardfoods:
                i = new Intent(this,Foods.class);
                startActivity(i);
                break;
        }


    }
}