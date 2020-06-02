package com.example.ad340_hw1;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.concurrent.ForkJoinPool;

// Abstract class for Room Database setup
@Database(entities = {Settings.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SettingsDao settingsDao();

    //possibly remove
//    public abstract ForkJoinPool getTransactionExecutor();
}
