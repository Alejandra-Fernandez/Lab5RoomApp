package com.example.labo5roomapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class updatedata extends AppCompatActivity
{
  int tid;
  EditText tname, tcity;
  Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);

        tname=findViewById(R.id.editfname);
        tcity=findViewById(R.id.editlname);
        btn=findViewById(R.id.btn);

        tid=Integer.parseInt(getIntent().getStringExtra("tid"));
        tname.setText(getIntent().getStringExtra  ("tname"));
        tcity.setText(getIntent().getStringExtra("tcity"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "room_db").allowMainThreadQueries().build();
                TouritsSpotDao touritsSpotDao = db.touristSpotDao();
                touritsSpotDao.updateById(tid,tname.getText().toString(),tcity.getText().toString());
                startActivity(new Intent(getApplicationContext(), datalist.class));
                finish();
            }
        });
    }




}