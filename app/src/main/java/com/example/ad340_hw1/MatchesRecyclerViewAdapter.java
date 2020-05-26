package com.example.ad340_hw1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MatchesRecyclerViewAdapter extends RecyclerView.Adapter<MatchesRecyclerViewAdapter.MatchesViewHolder> {

    private static final String TAG = MatchesRecyclerViewAdapter.class.getSimpleName();

    private Context context;
    private ArrayList<MatchesItem> matchesItems;

    public LikeClickListener listener;

    public MatchesRecyclerViewAdapter(ArrayList<MatchesItem> matchesItems, LikeClickListener listener, Context context) {

        this.matchesItems = matchesItems;
        this.listener = listener;
        this.context = context;
    }

//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.fragment_todoitem, parent, false);
//        return new ViewHolder(view);
//    }

    
}
