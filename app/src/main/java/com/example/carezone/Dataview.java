package com.example.carezone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Dataview extends RecyclerView.Adapter<Dataview.DataviewHolder> {


    Context context;



    ArrayList<pdata> list;

    public Dataview(Context context, ArrayList<pdata> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @NotNull
    @Override
    public DataviewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.data_items,parent,false);
        return new DataviewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DataviewHolder holder, int position) {



        pdata pdata = list.get(position);
        holder.Day.setText(pdata.getDate());
        holder.Plan.setText(pdata.getPlan());

        holder.image_delete.setOnClickListener(v -> {
            list.remove(position);

            notifyDataSetChanged();



            FirebaseDatabase.getInstance().getReference().child("pdata").setValue(null).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<Void> task) {

                }
            });


        });

        /*holder.image_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                FirebaseDatabase.getInstance().getReference().child("pdata").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {

                    }
                });

                final Intent intent= new Intent(context, Viewplan.class);
                context.startActivity(intent);
            }
        });*/


    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class DataviewHolder extends RecyclerView.ViewHolder {


        TextView Day,Plan;
        ImageView image_delete;



        public DataviewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            Day = itemView.findViewById(R.id.day);
            Plan = itemView.findViewById(R.id.plan);
            image_delete=itemView.findViewById(R.id.image_delete);






        }




    }
}
