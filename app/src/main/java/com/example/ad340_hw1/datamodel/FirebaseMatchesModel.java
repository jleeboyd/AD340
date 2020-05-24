package com.example.ad340_hw1.datamodel;

import com.example.ad340_hw1.models.MatchList;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class FirebaseMatchesModel {

    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    //get firestore instance
    public FirebaseMatchesModel() {

        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

    //get collection doc from firestore
    public void getMatchList(Consumer<QuerySnapshot> dataChangedCallback, Consumer<FirebaseFirestoreException> dataErrorCallback) {
        //access matches collection from firestore and add to listeners list
        ListenerRegistration listener = db.collection("matches")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    //error e null check
                    if (e != null) {
                        dataErrorCallback.accept(e);
                    }

                    dataChangedCallback.accept(queryDocumentSnapshots);
                });
        listeners.add(listener);
    }

    //update match doc on like
    public void updateLikedMatches(MatchList match) {
        DocumentReference matchRef = db.collection("matches").document(match.uid);
        Map<String, Object> data = new HashMap<>();
        data.put("like", match.likeClicked());
        matchRef.update(data);
    }

    //clear listeners for onPause event
    public void clear() {
        listeners.forEach(ListenerRegistration::remove);
    }

}
