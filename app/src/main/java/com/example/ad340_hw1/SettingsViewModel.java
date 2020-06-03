package com.example.ad340_hw1;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class SettingsViewModel extends ViewModel {

    public LiveData<List<Settings>> loadSettingsById(Context context, String[] emailIds) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        return db.settingsDao().getSettingsById(emailIds);
    }

//    public void updateSettings(Context context, Settings... settings) {
//        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
//        db.getTransactionExecutor().execute(() -> {
//            db.settingsDao().updateSettings(settings);
//        });
//    }

    public void insertSettings(Context context, Settings... settings) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.settingsDao().insertSettings(settings);
        });
    }

//    public void deleteSettings(Context context, Settings settings) {
//        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
//        db.getTransactionExecutor().execute(() -> {
//            db.settingsDao().delete(settings);
//        });
//    }
}

