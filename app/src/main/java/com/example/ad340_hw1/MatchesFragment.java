package com.example.ad340_hw1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MatchesFragment extends Fragment implements LikeClickListener{

    private static final String TAG = MatchesFragment.class.getSimpleName();

    public FirebaseMatchesViewModel vm;
    public ArrayList<MatchesItem> matchesItem;
    private LikeClickListener listener;

    //for fragments, need to use getView().findViewById ;
    //getActivity().getIntent();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate()");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        //new up customer contentAdapter class
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof LikeClickListener) {
            listener = (LikeClickListener) context;
        }

        else {
            throw new RuntimeException(context.toString()
                    + " must implement LikeClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
        Log.i(TAG, "onDetach()");
    }

    //Update database on like click
    public void onLikeClick(MatchesItem item) {
//        vm.update...
    }

    //clear here
    @Override
    public void onPause() {
        super.onPause();
        vm.clear();
        Log.i(TAG, "onPause()");
    }



    //cardview
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView description;
        public ImageButton likeBtn;

        public String likeBtnMsg;
        public String unlikeBtnMsg;

        public String matchName; //Used for likeBtnMsg
        public boolean isLiked; //Used for like on click
        public String matchUid; //Used for updateLike document path
//        public String descriptions; //used for testing



        public ViewHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.fragment_matches, parent, false));
            picture     = itemView.findViewById(R.id.card_image);
            name        = itemView.findViewById(R.id.card_title);
            description = itemView.findViewById(R.id.card_text);
            likeBtn     = itemView.findViewById(R.id.card_like_button);

            vm = new FirebaseMatchesViewModel();
            //display toast with card name onclick of like button
            likeBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    MatchesItem match = new MatchesItem(); //change db like value


                    //set like heart depending on click
                    //if liked = true in db
                    if(isLiked) {
                        likeBtn.setImageResource(R.drawable.unlike_button);

                        isLiked = !isLiked;
                        match.setLiked(isLiked); //changing liked value
                        match.setUid(matchUid); //document path
                        vm.updateLiked(match);
                        Log.i(TAG, String.valueOf(match.getLiked()));

                        Toast toast = Toast.makeText(v.getContext(), unlikeBtnMsg, Toast.LENGTH_SHORT);
                        toast.show();
                    }

//                    else if(!isLiked) {
//                        likeBtn.setImageResource(R.drawable.like_button);
//
//                        isLiked = !isLiked;
//                        match.setLiked(isLiked);
//                        match.setUid(matchUid);
//                        vm.updateLiked(match);
//                        Log.i(TAG, String.valueOf(match.getLiked()));
//                    }
                    else{
                        likeBtn.setImageResource(R.drawable.like_button);

                        isLiked = !isLiked;
                        match.setLiked(isLiked);
                        match.setUid(matchUid);
                        vm.updateLiked(match);
                        Log.i(TAG, String.valueOf(match.getLiked()));

                        Toast toast = Toast.makeText(v.getContext(), likeBtnMsg, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    Log.i(TAG, matchName);

                }
            });


        }
    }

    //cardview
    //recyclerview adapter instance
    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
//        private static final int LENGTH = 4;
//        private final String[] mNames;
//        private final String[] mDesc;
//        private final Drawable[] mPictures;

        private String[] names;
        private String[] image;
        private boolean[] liked;
        private String[]  uid;

        private FirebaseMatchesViewModel vm;


        public ContentAdapter(Context context) {
//            Resources resources = context.getResources();
            //values stored in local StringArray
//            mNames = resources.getStringArray(R.array.match_name);
//            name = resources.getStringArray(R.array.match_name);
//            mDesc = resources.getStringArray(R.array.match_desc);
//            TypedArray a = resources.obtainTypedArray(R.array.match_picture);
//            mPictures = new Drawable[a.length()];

//            for (int i = 0; i < mPictures.length; i++) {
//                mPictures[i] = a.getDrawable(i);
//            }
//            a.recycle();

            names = new String[6];
            image = new String[6];
            liked = new boolean[6];
            uid   = new String[6];

            vm = new FirebaseMatchesViewModel();
            vm.getMatchItems(
                    (ArrayList<MatchesItem> matches) -> {
//                        names = new String[matches.size()];
                        //grabs names of
                        for(int i = 0; i < matches.size(); i++){
                            names[i] = matches.get(i).getName();
                            image[i] = matches.get(i).getImageUrl();
                            liked[i] = matches.get(i).getLiked();
                            uid[i]   = matches.get(i).getUid();
                        }
                        //Required for updating the first cards that were created before the callback began.
                        notifyDataSetChanged();
                    });
        }


        //onBindViewHolder binds the recycled views once they go off screen while scrolling
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //set data from vm call to cardview
//            holder.picture.setImageDrawable(mPictures[position % mPictures.length]);
            holder.name.setText(names[position % names.length]);
            Picasso.get().load(image[position % image.length]).into(holder.picture);
            holder.description.setText(names[position % names.length]); //default desc is the name
//            holder.description.setText(String.valueOf(liked[position % liked.length])); for checking like value

//            holder.descriptions = holder.description.getText().toString();
            holder.matchUid = uid[position % uid.length]; //store uid for each card
            holder.isLiked = liked[position % liked.length]; //store liked value

            //set like button for liked matches from db.
            if(String.valueOf(holder.isLiked) == "true"){
                holder.likeBtn.setImageResource(R.drawable.like_button);
            }

            // CREATE NEW STRING BUILDER FOR UNLIKE BUTTON
            holder.matchName = holder.name.getText().toString();//set name for each card

            StringBuilder likeBtnMsgName   = new StringBuilder(getString(R.string.you_liked));
            StringBuilder unlikeBtnMsgName = new StringBuilder(getString(R.string.you_unliked));
            likeBtnMsgName.append(holder.matchName);
            unlikeBtnMsgName.append(holder.matchName);
            holder.likeBtnMsg   = likeBtnMsgName.toString();
            holder.unlikeBtnMsg = unlikeBtnMsgName.toString();

//            Log.i(TAG, "onBindViewHolder()" + position);
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public int getItemCount() {
            //call to names.length initially null upon fragment creation.
            //once callback has been completed, is re-updated via notifyDataSetChanged()
            return names.length;
        }
    }

}