package com.example.ad340_hw1;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Settings Entity related to settings table in db
@Entity
public class Settings {

    // Fields for table, with default values
    @PrimaryKey
    @NonNull
    private String email = "";

    @NonNull
    @ColumnInfo(name = "reminder_time")
    private String reminderTime = "None";

    @NonNull
    @ColumnInfo(name = "max_distance")
    private int maxDistance = 50;

    @ColumnInfo(name = "gender")
    private String gender = "";

    @NonNull
    @ColumnInfo(name = "privacy")
    private String privacy = "Public";

    @NonNull
    @ColumnInfo(name = "age_min")
    private int ageMin = 18;

    @NonNull
    @ColumnInfo(name = "age_max")
    private int ageMax = 30;

    // Accessor/mutators

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    public String getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(String reminderTime) {
        this.reminderTime = reminderTime;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @NonNull
    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @NonNull
    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

}
