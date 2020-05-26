package com.example.ad340_hw1;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;

public class FirebaseMatchesViewModel {

    private FirebaseMatchesModel model;

    public FirebaseMatchesViewModel() {
        model = new FirebaseMatchesModel();
    }

    //simple firebase hello world version
//    public void getMatches(OnGetDataListener<String> activityCallback) {
//        model.getMatches(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    System.out.println("Error reading matches: " + e);
//                    activityCallback.onFailure();
//                    return;
//                }
//
//
//                if (queryDocumentSnapshots != null) {
//                    Map<String, Object> data = queryDocumentSnapshots.getData();
//                    if (data != null) {
//                        Object matches = data.get("test");
//                        if (matches != null) {
//                            String value = matches.toString();
//                            activityCallback.onSuccess(value);
//                        }
//                    }
//                }
//            }
//        });

    //taking matches collection from datamodel and grabbing individual documents
    public void getMatchItems(Consumer<ArrayList<MatchesItem>> responseCallback) {
        model.getMatches(
                (QuerySnapshot querySnapshot) -> {
                    if (querySnapshot != null) {
                        ArrayList<MatchesItem> matchesItems = new ArrayList<>();
                        for (DocumentSnapshot matchesSnapshot : querySnapshot.getDocuments()) {
                            MatchesItem item = matchesSnapshot.toObject(MatchesItem.class);
                            assert item != null;
                            item.uid = matchesSnapshot.getId();
                            matchesItems.add(item);
                        }
                        responseCallback.accept(matchesItems);
                    }
                },
                (databaseError -> System.out.println("Error getting matches: " + databaseError))
        );
    }

    //updatematches here

    //clear listeners for onPause() in model
    public void clear() {
        model.clear();
    }
}
