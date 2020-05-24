package com.example.ad340_hw1.viewmodels;

import com.example.ad340_hw1.datamodel.FirebaseMatchesModel;
import com.example.ad340_hw1.models.MatchList;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

//ViewModel is between View and Model

public class FirebaseMatchesViewModel {

    private FirebaseMatchesModel model;

    public FirebaseMatchesViewModel() {
        matchesModel = new FirebaseMatchesModel();
    }

    public void getMatchList() {
        matchesModel.getMatchList(Consumer<ArrayList< MatchList >> resonseCallback){
            //get
            matchesModel.getMatchList(
                    (QuerySnapshot querySnapshot) -> {
                        if (querySnapshot != null) {
                            ArrayList<MatchList> matchesList = new ArrayList<>();
                            for (DocumentSnapshot matchesSnapshot : querySnapshot.getDocuments()) {
                                MatchList match = matchesSnapshot.toObject(MatchList.class);
                                assert match != null;
//                                match.uid.matchesSnapshot.getId();
                                matchesList.add(match);
                            }
                            responseCallback.accept(matchesList);
                        }
                    },
                    (databaseError -> System.out.println("Error reading Todo Items: " + databaseError))
            );
        }
    }

    public static void updateLikedMatches(MatchList match) {
        matchesModel.updateLikedMatches(match);
    }

    //call model clear on pause
    public void clear() {
        matchesModel.clear();
    }
}
