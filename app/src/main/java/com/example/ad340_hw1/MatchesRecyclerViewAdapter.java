//package com.example.ad340_hw1;
//
//import android.content.Context;
//import android.content.res.Resources;
//import android.content.res.TypedArray;
//import android.graphics.drawable.Drawable;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class MatchesRecyclerViewAdapter extends RecyclerView.Adapter<MatchesRecyclerViewAdapter.MatchesViewHolder> {
//
//    private static final String TAG = MatchesRecyclerViewAdapter.class.getSimpleName();
//
//    private final ArrayList<MatchesItem> matchesItem;
//
//    private final LikeClickListener listener;
//
//    public MatchesRecyclerViewAdapter(ArrayList<MatchesItem> matchesItem, LikeClickListener listener, Context context) {
//
//        this.matchesItem = matchesItem;
//        this.listener = listener;
//
//    }
//
//    @NonNull
//    @Override
//    public MatchesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new MatchesViewHolder(LayoutInflater.from(parent.getContext()), parent);
//    }
//
//    //onBindViewHolder binds the recycled views once they go off screen while scrolling
//    @Override
//    public void onBindViewHolder(MatchesViewHolder holder, int position) {
//
//        MatchesItem match = matchesItem.get(position);
//
//        holder.name.setText(match.getName());
//
//        Log.i(TAG, "onBindViewHolder()" + position);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return matchesItem.size();
////        return 0;
//    }
//
//    public static class MatchesViewHolder extends RecyclerView.ViewHolder {
//
//        public ImageView picture;
//        public TextView name;
//        public TextView description;
//        public ImageButton likeBtn;
//        public String likeBtnMsg;
//
//        public MatchesViewHolder(LayoutInflater inflater, ViewGroup parent) {
//
//            super(inflater.inflate(R.layout.fragment_matches, parent, false));
//
//            picture = itemView.findViewById(R.id.card_image);
//            name = itemView.findViewById(R.id.card_title);
//            description = itemView.findViewById(R.id.card_text);
//            likeBtn = itemView.findViewById(R.id.card_like_button);
//
//        }
//
//    }
//}
