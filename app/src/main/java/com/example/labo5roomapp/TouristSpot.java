package com.example.labo5roomapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TouristSpot {
    @PrimaryKey (autoGenerate = true)
    public int tid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "city")
    public String city;

    public TouristSpot(int tid, String name, String city) {
        this.tid = tid;
        this.name = name;
        this.city = city;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
