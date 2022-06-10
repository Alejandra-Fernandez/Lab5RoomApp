package com.example.labo5roomapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    List<TouristSpot> touristSpots;

    public myadapter(List<TouristSpot> touristSpots) {
        this.touristSpots = touristSpots;
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myadapter.myviewholder holder, int position) {
          holder.recid.setText(String.valueOf(touristSpots.get(position).getTid()));
          holder.recfname.setText(touristSpots.get(position).getName());
          holder.reclname.setText(touristSpots.get(position).getCity());
          holder.delbtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  AppDatabase db = Room.databaseBuilder(holder.recid.getContext(),
                          AppDatabase.class, "room_db").allowMainThreadQueries().build();
                  TouritsSpotDao touritsSpotDao = db.touristSpotDao();
                  // this is to delete the record from room database
                  touritsSpotDao.deleteById(touristSpots.get(position).getTid());
                  // this is to delete the record from Array List which is the source of recview data
                  touristSpots.remove(position);

                  //update the fresh list of ArrayList data to recview
                  notifyDataSetChanged();
              }
          });
          holder.edbtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(new Intent(holder.edbtn.getContext(),updatedata.class));
                  intent.putExtra("tid",String.valueOf(touristSpots.get(position).getTid()));
                  intent.putExtra("tname",touristSpots.get(position).getName());
                  intent.putExtra("tcity",touristSpots.get(position).getCity());
                  holder.edbtn.getContext().startActivity(intent);
              }
          });


    }

    @Override
    public int getItemCount() {
        return touristSpots.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
       {
           TextView recid,recfname, reclname;
           ImageButton delbtn,edbtn;
           public myviewholder(@NonNull @NotNull View itemView) {
               super(itemView);

               recid=itemView.findViewById(R.id.recid);
               recfname=itemView.findViewById(R.id.recfname);
               reclname=itemView.findViewById(R.id.reclname);
               delbtn=itemView.findViewById(R.id.delbtn);
               edbtn=itemView.findViewById(R.id.edbtn);
           }
       }
}
