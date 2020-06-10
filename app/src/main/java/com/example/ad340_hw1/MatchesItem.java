package com.example.ad340_hw1;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;

@IgnoreExtraProperties
public class MatchesItem implements Parcelable {
    //workflow, model gets whole collection, viewmodel takes collection and parses into documents.
    //documents are stored into the matchitem parcebel class values. ie fields for each field in the db
    //then in the fragment we need to extract the item class values and store them in the holder.

    //create getters and setters in matchItem class
    //access matches collection in model, transform to documents in viewmodel, and then save to
    //matchitem class. extract in fragment bindviewholder.

    //fields in matches docs that will go in the matches
    public String imageUrl;
    public String lat;
    public boolean liked;
    public String longitude;
    public String name;
    public String uid;

    public MatchesItem() {
        //Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public MatchesItem(Parcel in) {
        imageUrl = in.readString();
        lat = in.readString();
        liked = in.readByte() != 0;
        longitude = in.readString();
        name = in.readString();
        uid = in.readString();
    }

    public static final Creator<MatchesItem> CREATOR = new Creator<MatchesItem>() {
        @Override
        public MatchesItem createFromParcel(Parcel in) {
            return new MatchesItem(in);
        }

        @Override
        public MatchesItem[] newArray(int size) {
            return new MatchesItem[size];
        }
    };

    //Accessors, without lat,longitude for now
    public String getImageUrl() {
        return imageUrl;
    }

    public boolean getLiked() {
        return liked;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getLat() {
        return lat;
    }

    public String getLongitude() {
        return longitude;
    }

//    @Exclude
//    public Map(String, Object> toMap() {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put(Constants.UID, uid);
//        result.put(Constants.LIKED, liked);
//
//        return result;
//    }
    //Mutators
    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeByte((byte) (liked ? 1 : 0));
    }
}
