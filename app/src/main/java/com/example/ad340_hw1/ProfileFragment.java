package com.example.ad340_hw1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;



public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();

    private TextView textViewFirst;
    private TextView textViewLast;
    private TextView textViewUser;
    private TextView textViewEmail;
    private TextView textViewAge;
    private TextView textViewDescription;
    private TextView textViewOccupation;

    String user;
    String first;
    String last;
    String email;
    String age;
    String desc;
    String occu;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Bundle bundle = getArguments();

        if (bundle != null) {

            //assign textviews with view inflater. Outside of onCreateView use getView()
            textViewUser  = view.findViewById(R.id.textViewProfileUsername);
            textViewFirst = view.findViewById(R.id.textViewProfileFirstName);
            textViewLast  = view.findViewById(R.id.textViewProfileLastName);
            textViewEmail = view.findViewById(R.id.textViewProfileEmail);
            textViewAge   = view.findViewById(R.id.textViewProfileAge);
            textViewDescription = view.findViewById(R.id.textViewProfileDescription);
            textViewOccupation  = view.findViewById(R.id.textViewProfileOccupation);

            //grab signup data from bundle
            user  = bundle.getString(Constants.KEY_USERNAME);
            first = bundle.getString(Constants.KEY_FIRST_NAME);
            last  = bundle.getString(Constants.KEY_LAST_NAME);
            email = bundle.getString(Constants.KEY_EMAIL);
            age   = bundle.getString(Constants.KEY_AGE);
            desc  = bundle.getString(Constants.KEY_DESCRIPTION);
            occu  = bundle.getString(Constants.KEY_OCCUPATION);

            //set text views to user signup info
            textViewUser.setText(user);
            textViewFirst.setText(first);
            textViewLast.setText(last);
            textViewEmail.setText(email);
            textViewAge.setText(age);
            textViewDescription.setText(desc);
            textViewOccupation.setText(occu);

            Log.i(TAG, "bundle is not null");
//            Log.i(TAG, bundle.getString(Constants.KEY_USERNAME) + " fragment");
        }

        else {
            Log.i(TAG, "bundle is null");
        }

        Log.i(TAG, "onCreateView()");

        return view; //inflater.inflate(R.layout.fragment_profile, null, true);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated()");
    }

    //for fragments, need to use getView().findViewById ;
    //getActivity().getIntent();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate()");

    }

    @Override
    public void onStart() {
        super.onStart(); //override default onStart() and obtain from AppCompatActivity (parent) logic.
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
