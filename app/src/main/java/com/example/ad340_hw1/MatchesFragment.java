package com.example.ad340_hw1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import android.location.LocationListener;
import android.location.Location;

import java.util.ArrayList;
import java.util.Objects;

//import static androidx.core.content.ContextCompat.getSystemService;

public class MatchesFragment extends Fragment {//implements LikeClickListener{

    private static final String TAG = MatchesFragment.class.getSimpleName();

    public FirebaseMatchesViewModel vm;
    public ArrayList<MatchesItem> matchesItem;
//    private LikeClickListener listener;
    public RecyclerView recyclerView;

    public Context context;

    LocationManager locationManager;
    // Default Seattle Location
    double longitudeGPS = 47.6059;
    double latitudeGPS  = -122.3296;
    boolean hasMatches = false;

    //for fragments, need to use getView().findViewById ;
    //getActivity().getIntent();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Log.i(TAG, "onCreate()");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);

        locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        context = getActivity();
        toggleGPSUpdates();

        //new up customer contentAdapter class if locationManager doesn't reset location
        if(latitudeGPS == 47.6059 && longitudeGPS == -122.3296)
        {
            ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }

        return recyclerView;
    }

    // Start GPS
    private boolean checkLocation() {
        if(!isLocationEnabled()) {
            showAlert();
        }
        return isLocationEnabled();
    }

    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    // Show alert is location services isn't enabled
    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(R.string.enable_location)
                .setMessage(getString(R.string.location_message))
                .setPositiveButton(R.string.location_settings, (paramDialogInterface, paramInt) -> {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(myIntent);
                })
                .setNegativeButton(R.string.location_cancel, (paramDialogInterface, paramInt) -> {});
        dialog.show();
    }

    // TO DO: no toggle button. Just make sure everytime location (requestLocationUpdates) is called, matches will be
    // Filtered out via gps coordinate vs gps coordinate of the phone. sqrt(x^2 + y^2) <-- distance formula
    public void toggleGPSUpdates() {
        if(!checkLocation()) {
            return;
        }

        else {
            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                // Set to update every 5 seconds, 10 meters
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5 * 1000, 10, locationListenerNetwork);
                Toast.makeText(getContext(), R.string.gps_provider_started_running, Toast.LENGTH_LONG).show();
            }
        }
    }

    private final LocationListener locationListenerNetwork = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitudeGPS = location.getLongitude();
            latitudeGPS = location.getLatitude();

            // Call content adapter once location is changed. Put checks in place to limit displayed by distance.
            ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            // Toast to display lat and long of phone
//            Toast toast = Toast.makeText(getContext(),  "long: "+ longitudeGPS, Toast.LENGTH_SHORT);
//            toast.show();
//
//            Toast toast2 = Toast.makeText(getContext(),  "lat: "+ latitudeGPS, Toast.LENGTH_SHORT);
//            toast2.show();

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {}

        @Override
        public void onProviderEnabled(String s) {}

        @Override
        public void onProviderDisabled(String s) {}
    };
    // End GPS

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        listener = null;
        Log.i(TAG, "onDetach()");
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

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Comment out for final
//        public TextView longituder;
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Comment out for final

        public String likeBtnMsg;
        public String unlikeBtnMsg;

        public String matchName; //Used for likeBtnMsg
        public boolean isLiked; //Used for like on click
        public String matchUid; //Used for updateLike document path
//        public String descriptions; //used for testing

        public Settings settings;




        public ViewHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.fragment_matches, parent, false));
            picture     = itemView.findViewById(R.id.card_image);
            name        = itemView.findViewById(R.id.card_title);
            description = itemView.findViewById(R.id.card_text);
            likeBtn     = itemView.findViewById(R.id.card_like_button);
            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Comment out for final
//            longituder  = itemView.findViewById(R.id.card_long);
            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Comment out for final


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

                        isLiked = false;
                        match.setLiked(isLiked); //changing liked value
                        match.setUid(matchUid); //document path
                        vm.updateLiked(match);
                        Log.i(TAG, String.valueOf(match.getLiked()));

                        Toast toast = Toast.makeText(v.getContext(), unlikeBtnMsg, Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    else{
                        likeBtn.setImageResource(R.drawable.like_button);

                        isLiked = true;
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

        private ArrayList<String>  names;
        private ArrayList<String>  image;
        private ArrayList<Boolean> liked;
        private ArrayList<String>  uid;
        private ArrayList<String>  lat;
        private ArrayList<String>  longitude;

        // Count of matches with distance > 10mi
        public int count;
        public int totalMatches;
        private float[] distMeters;
        private ArrayList<Double> distMiles;

        private FirebaseMatchesViewModel vm;


        public ContentAdapter(Context context) {

            names = new ArrayList<>();
            image = new ArrayList<>();
            liked = new ArrayList<>();
            uid   = new ArrayList<>();
            lat   = new ArrayList<>();
            longitude = new ArrayList<>();

            // Grab data from firebase and store to local var
            vm = new FirebaseMatchesViewModel();
            vm.getMatchItems(
                    (ArrayList<MatchesItem> matches) -> {
                        //grabs names of
                        for(int i = 0; i < matches.size(); i++){
                            names.add(matches.get(i).getName());
                            image.add(matches.get(i).getImageUrl());
                            liked.add(matches.get(i).getLiked());
                            uid.add(matches.get(i).getUid());
                            lat.add(matches.get(i).getLat());
                            longitude.add(matches.get(i).getLongitude());
//                            Log.i(TAG, "names"+names.get(i));

                        }
                        //Required for updating the first cards that were created before the callback began.
                        notifyDataSetChanged();
                        hasMatches = true;
                        totalMatches = names.size();

                        // If there are matches, determine distance for each match
                        if (hasMatches && names.size() == 6) {

                            distMeters = new float[6];
                            distMiles  = new ArrayList<>();
                            // Cycle through matches and assign distances to each
                            for(int i=0; i < names.size(); i++) {


                                Location matchLocation = new Location("match");


                                double matchLong = Double.parseDouble(longitude.get(i));
                                double matchLat  = Double.parseDouble(lat.get(i));

                                matchLocation.setLatitude(matchLat);
                                matchLocation.setLongitude(matchLong);

                                Location phoneLocation = new Location("phone");

                                phoneLocation.setLatitude(latitudeGPS);
                                phoneLocation.setLongitude(longitudeGPS);


                                distMeters[i] = phoneLocation.distanceTo(matchLocation);

                                double miles = (double) Math.abs(distMeters[i]) * 0.000621371192;

                                distMiles.add(i, miles);

                                // If the distance is greater than 10, remove the match data
                                // Replace limit with settings max distance

                                if(distMiles.get(i) > 10.0) {
                                    names.remove(i);
                                    image.remove(i);
                                    liked.remove(i);
                                      uid.remove(i);
                                      lat.remove(i);
                                    longitude.remove(i);

                                    i--;
                                    count++;
                                }

                            }

                        }


                    });

        }


        //onBindViewHolder binds the recycled views once they go off screen while scrolling
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            //set data from vm call to cardview
            holder.name.setText(names.get(position));
            Picasso.get().load(image.get(position)).into(holder.picture);
            holder.description.setText(names.get(position)); //default desc is the name

            holder.matchUid = uid.get(position); //store uid for each card
            holder.isLiked = liked.get(position); //store liked value

            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Comment out for final
//            holder.longituder.setText(longitude.get(position));
            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Comment out for final

            //set like button for liked matches from db.
            if (String.valueOf(holder.isLiked) == "true") {
                holder.likeBtn.setImageResource(R.drawable.like_button);
            }

            // CREATE NEW STRING BUILDER FOR UNLIKE BUTTON
            holder.matchName = holder.name.getText().toString();//set name for each card

            StringBuilder likeBtnMsgName = new StringBuilder(getString(R.string.you_liked));
            StringBuilder unlikeBtnMsgName = new StringBuilder(getString(R.string.you_unliked));
            likeBtnMsgName.append(holder.matchName);
            unlikeBtnMsgName.append(holder.matchName);
            holder.likeBtnMsg = likeBtnMsgName.toString();
            holder.unlikeBtnMsg = unlikeBtnMsgName.toString();

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
            // Only creates # of cards that are less than 10 miles.
            return totalMatches - count;
//            return 8; // Will recycle cards/fb data if num larger than # in db.
        }

    }

}