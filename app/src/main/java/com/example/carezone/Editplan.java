package com.example.carezone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Editplan extends AppCompatActivity {


    Spinner spinnerup;
    EditText edittxtupdate;
    Button btnupdate,btnbackadd;

    DatabaseReference ref;
    pdata pdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editplan);


        spinnerup=findViewById(R.id.spinnerup);
        edittxtupdate=(EditText)findViewById(R.id.edittxtupdate);
        btnupdate=(Button) findViewById(R.id.btnupdate);
        btnbackadd=(Button)findViewById(R.id.btnbackadd);


        ref= FirebaseDatabase.getInstance().getReference().child("pdata");





        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plan=edittxtupdate.getText().toString();
                String date=spinnerup.getSelectedItem().toString();
                HashMap hashMap=new HashMap();
                hashMap.put("date",date);
                hashMap.put("plan",plan);




                ref.child("pdata").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(Editplan.this,"succsess",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        btnbackadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Editplan.this,Viewplan.class);
                startActivity(intent);
            }
        });

    }
}