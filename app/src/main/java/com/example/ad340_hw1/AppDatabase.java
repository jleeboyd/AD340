package com.example.ad340_hw1;


import androidx.room.Database;
import androidx.room.RoomDatabase;

// Abstract class for Room Database setup
@Database(entities = {Settings.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SettingsDao settingsDao();

}
