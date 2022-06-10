package com.example.labo5roomapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TouritsSpotDao {

    @Insert
    void insertrecord(TouristSpot touristSpot);

    @Query("SELECT EXISTS(SELECT * FROM TouristSpot WHERE tid = :touristSpotId)")
    Boolean is_exist(int touristSpotId);


    @Query("SELECT * FROM TouristSpot")
    List<TouristSpot> getalltouristspot();
    //List<TouristSpot> getallusers();

    @Query("DELETE FROM TouristSpot WHERE tid = :id")
    void deleteById(int id);

    @Query("UPDATE TouristSpot SET name = :tname, city=:tcity WHERE tid = :id")
    void updateById(int id, String tname, String tcity);
}
