package com.example.ad340_hw1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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

import com.example.ad340_hw1.OnGetDataListener;
import com.example.ad340_hw1.FirebaseMatchesViewModel;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment implements LikeClickListener{

    private static final String TAG = MatchesFragment.class.getSimpleName();
    private List<MatchesItem> matches;

    //for fragments, need to use getView().findViewById ;
    //getActivity().getIntent();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        matches = getArguments().getParcelableArrayList(Constants.MATCHES);
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

    //cardview
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public TextView description;
        public ImageButton likeBtn;
        public String likeBtnMsg;
//        private FirebaseMatchesViewModel vm;


        public ViewHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.fragment_matches, parent, false));
            picture     = itemView.findViewById(R.id.card_image);
            name        = itemView.findViewById(R.id.card_title);
            description = itemView.findViewById(R.id.card_text);
            likeBtn     = itemView.findViewById(R.id.card_like_button);

            //display toast with card name onclick of like button
            likeBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast toast = Toast.makeText(v.getContext(), likeBtnMsg, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

//            vm = new FirebaseMatchesViewModel();
//
//            vm.getMatches(new OnGetDataListener<String>()) {
//                @Override
//                public void onSuccess(String dataResponse) {
//                    textView.setText(dataResponse);
//                }
//
//                @Override
//                public void onFailure() {
//                    System.out.println("Looks like some error happened when we tried to get helloWorld");
//                }
//            }
        }
    }

    //cardview
    //recyclerview adapter instance
    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 1;
        private final String[] mNames;
        private final String[] mDesc;
        private final Drawable[] mPictures;

        private FirebaseMatchesViewModel vm;
        public ArrayList<MatchesItem> matchesItems;


        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            mNames = resources.getStringArray(R.array.match_name);
            mDesc = resources.getStringArray(R.array.match_desc);
            TypedArray a = resources.obtainTypedArray(R.array.match_picture);
            mPictures = new Drawable[a.length()];

            for (int i = 0; i < mPictures.length; i++) {
                mPictures[i] = a.getDrawable(i);
            }
            a.recycle();

//            vm = new FirebaseMatchesViewModel();
//
//            MatchesItem match = vm.getMatchItems(
//                    (ArrayList<MatchesItem> matchesItems) -> Log.i(TAG, "hi"));
        }


        //onBindViewHolder binds the recycled views once they go off screen while scrolling
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.picture.setImageDrawable(mPictures[position % mPictures.length]);
//            holder.name.setText(mNames[position % mNames.length]);
            holder.description.setText(mDesc[position % mDesc.length]);





//            vm.getMatchItems(new OnGetDataListener<String>() {
//                @Override
//                public void onSuccess(String dataResponse) {
//                    holder.name.setText(dataResponse);
//                }
//
//                @Override
//                public void onFailure() {
//                    System.out.println("Looks like some error happened when we tried to get your matches");
//                }
//            });


            //new version,
            //holder.mydatafromFirestore


            StringBuilder likeBtnMsgName = new StringBuilder(getString(R.string.you_liked));

            likeBtnMsgName.append(holder.name.getText().toString());

            holder.likeBtnMsg = likeBtnMsgName.toString();

            Log.i(TAG, "onBindViewHolder()" + position);

        }





        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated()");
    }



    //Update database on like click
    public void onLikeClick(MatchesItem item) {
//        vm.update...
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach()");
    }
}