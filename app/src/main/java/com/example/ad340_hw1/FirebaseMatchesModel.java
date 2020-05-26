package com.example.ad340_hw1;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FirebaseMatchesModel {

    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public FirebaseMatchesModel() {
        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

//    public void getMatches(EventListener<DocumentSnapshot> viewModelCallback) {
//        DocumentReference matchesRef = db.collection("test").document("testDocument");
//        ListenerRegistration registration = matchesRef.addSnapshotListener(viewModelCallback);
//        listeners.add(registration);
//    }

    public void getMatches(Consumer<QuerySnapshot> dataChangedCallback, Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration listener = db.collection("matches")
                .addSnapshotListener(((queryDocumentSnapshots, e) -> {
                    if (e != null) {
                        dataErrorCallback.accept(e);
                    }
                    dataChangedCallback.accept(queryDocumentSnapshots);
                }));
        listeners.add(listener);
    }
    public void clear() {
        // Clear all the listeners onPause
        listeners.forEach(ListenerRegistration::remove);
    }

    //add update like here
}
