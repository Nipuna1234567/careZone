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

public class Addplan extends AppCompatActivity {


    EditText txtplan;
    Button btndone,btnback;
    Spinner spinner;

    DatabaseReference ref;
    pdata pdata;

    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplan);


        txtplan =(EditText)findViewById(R.id.txtplan);
        btndone =(Button)findViewById(R.id.btndone);
        spinner=findViewById(R.id.spinner);
        btnback=(Button)findViewById(R.id.btnback);


        pdata=new pdata();
        ref= FirebaseDatabase.getInstance().getReference().child("pdata");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxid=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdata.setPlan(txtplan.getText().toString().trim());
                pdata.setDate(spinner.getSelectedItem().toString());



                ref.child(String.valueOf(maxid+1)).setValue(pdata);





                Intent intent=new Intent(Addplan.this,Viewplan.class);
                startActivity(intent);

                Toast.makeText(Addplan.this,"Plan saved", Toast.LENGTH_SHORT).show();

            }
        });


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Addplan.this,Viewplan.class);
                startActivity(intent);
            }
        });



    }
}