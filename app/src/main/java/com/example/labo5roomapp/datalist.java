package com.example.labo5roomapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class datalist extends AppCompatActivity
{
    RecyclerView recview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datalist);

        getroomdata();
    }

    public void getroomdata()
    {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_db").allowMainThreadQueries().build();
        TouritsSpotDao touritsSpotDao = db.touristSpotDao();

        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        List<TouristSpot> touristSpots=touritsSpotDao.getalltouristspot();

        myadapter adapter=new myadapter(touristSpots);
        recview.setAdapter(adapter);
    }
}