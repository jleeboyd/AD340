package com.example.ad340_hw1.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class MatchList implements Parcelable {

    // matches doc fields
    public String imageUrl;
    public String lat;
    public boolean like;
    public String longitude;
    public String name;
    public String uid;


    //default constructor required for calls to DataSnapshot.getValue(User.class)
    public MatchList() {
    }

    public MatchList(boolean like) {
        this.imageUrl = imageUrl;
//        this.lat      = lat;
        this.like     = like;
//        this.longitude = longitude;
        this.name      = name;
//        this.uid       = uid;
    }

    public MatchList(Parcel in) {
        imageUrl = in.readString();
//        lat = in.readString();
        like = in.readByte() != 0;
//        longitude = in.readString();
        name = in.readString();
//        uid  = in.readString();
    }

    public boolean likeClicked() {
        return like;
    }

    //From parcel can create new Matches
    public static final Creator<MatchList> CREATOR = new Creator<MatchList>() {
        @Override
        public MatchList createFromParcel(Parcel in) {
            return new MatchList(in);
        }

        @Override
        public MatchList[] newArray(int size) {
            return new MatchList[size];
        }
    };

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("imageUrl", imageUrl);
//        result.put("lat", lat);
        result.put("like", like);
//        result.put("longitude", longitude);
        result.put("name", name);
        result.put("uid", uid);

        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //Tells parcel class how to write this object
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(name);
        dest.writeByte((byte) (like ? 1 : 0));
    }
}
