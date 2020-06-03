package com.example.ad340_hw1;

import android.content.Context;

import androidx.room.Room;

// Connects to AppDatabase
public class AppDatabaseSingleton {

    private static AppDatabase db;

    public static AppDatabase getDatabase(Context context) {

        if(db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "settings_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return db;
    }
}
