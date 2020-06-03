package com.example.ad340_hw1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// Interface between db and app
@Dao
public interface SettingsDao {

    // Get all settings from db
    @Query("SELECT * FROM settings")
    LiveData<List<Settings>> getAll();

    // Get all settings from user with matching email
    @Query("SELECT * FROM settings WHERE email = :email")
    LiveData<List<Settings>> getSettingsById(String[] email);

    // Update settings entity in db with Settings entity in app
//    @Update
//    void updateSettings(Settings... settings);

    // Insert new settings into db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSettings(Settings... settings);

//    @Delete
//    void delete(Settings settings);
}
