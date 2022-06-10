package com.example.labo5roomapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TouristSpot.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TouritsSpotDao touristSpotDao();
}

