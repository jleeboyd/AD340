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

public class MatchesFragment extends Fragment {

    private static final String TAG = MatchesFragment.class.getSimpleName();
//    Context context;

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
//                    RecyclerView recyclerView = itemView.findViewById(R.id.my_recycler_view);
//                    int itemPosition = recyclerView.getChildLayoutPosition(v);
//                    String item = R.array.match_name.getString[itemPosition];
//                    Resources resources = context.getResources();
//                    String item = R.array.match_name.getStringArray(itemPosition);

                    Toast toast = Toast.makeText(v.getContext(), likeBtnMsg, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            //onclick
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, TabActivity.class);
//                    intent.putExtra(TabActivity.EXTRA_POSITION, getAdapterPosition());
//                    context.startActivity(intent);
//                }
//            });
//            // Adding Snackbar to Action Button inside card
//            Button button = (Button)itemView.findViewById(R.id.action_button);
//            button.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Snackbar.make(v, "Action is pressed",
//                            Snackbar.LENGTH_LONG).show();
//                }
//            })}
            //like button w/ toast

        }
    }

    //cardview
    //recyclerview adapter instance
    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 4;
        private final String[] mNames;
        private final String[] mDesc;
        private final Drawable[] mPictures;

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
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        //onBindViewHolder binds the recycled views once they go off screen while scrolling
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.picture.setImageDrawable(mPictures[position % mPictures.length]);
            holder.name.setText(mNames[position % mNames.length]);
            holder.description.setText(mDesc[position % mDesc.length]);

            StringBuilder likeBtnMsgName = new StringBuilder(getString(R.string.you_liked));

            likeBtnMsgName.append(holder.name.getText().toString());

            holder.likeBtnMsg = likeBtnMsgName.toString();
            Log.i(TAG, "onBindViewHolder()" + position);

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

    //for fragments, need to use getView().findViewById ;
    //getActivity().getIntent();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        View view = inflater.inflate(R.layout.fragment_matches, container, false);
//        return view;


        Log.i(TAG, "onCreate()");

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