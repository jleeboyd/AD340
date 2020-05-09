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

    private static final String TAG = ProfileActivity.class.getSimpleName();

    private TextView textViewFirst;
    private TextView textViewLast;
    private TextView textViewUser;
    private TextView textViewEmail;
    private TextView textViewAge;
    private TextView textViewDescription;
    private TextView textViewOccupation;

//    private Button button;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView()");

//        textViewFirst = getView().findViewById(R.id.textViewProfileFirstName);
//        Intent intent = getActivity().getIntent();
//        Bundle b = intent.getExtras();
//
//
//        textViewFirst.setText(b.getString(Constants.KEY_FIRST_NAME));

        return inflater.inflate(R.layout.fragment_profile, null);

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
//        setContentView(R.layout.fragment_profile);


//        textViewLast = getView().findViewById(R.id.textViewProfileLastName);
//        textViewUser = getView().findViewById(R.id.textViewProfileUsername);
//        textViewEmail = getView().findViewById(R.id.textViewProfileEmail);
//        textViewAge = getView().findViewById(R.id.textViewProfileAge);
//        textViewDescription = getView().findViewById(R.id.textViewProfileDescription);
//        textViewOccupation = getView().findViewById(R.id.textViewProfileOccupation);


//        Intent intent = getActivity().getIntent();
//        Bundle b = intent.getExtras();
//
//
//        textViewFirst.setText(b.getString(Constants.KEY_FIRST_NAME));
//        textViewLast.setText(b.getString(Constants.KEY_LAST_NAME));
//        textViewUser.setText(b.getString(Constants.KEY_USERNAME));
//        textViewEmail.setText(b.getString(Constants.KEY_EMAIL));
//        textViewAge.setText(b.getString(Constants.KEY_AGE));
//        textViewDescription.setText(b.getString(Constants.KEY_DESCRIPTION));
//        textViewOccupation.setText(b.getString(Constants.KEY_OCCUPATION));

        Log.i(TAG, "onCreate()");
    }


//    @Override
//    public void onRestart(){
//        super.onRestart(); //override default onStart() and obtain from AppCompatActivity (parent) logic.
//        Log.i(TAG,"onRestart()");
//    }

    @Override
    public void onStart(){
        super.onStart(); //override default onStart() and obtain from AppCompatActivity (parent) logic.
        Log.i(TAG,"onStart()");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG,"onResume()");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG,"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"onDestroyView()");
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

//        public void goToMainActivity(View view) {
////        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
////        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //do no onCreate() main again w/ manifest
////        startActivity(intent);
//            finish(); //to onDestroy() current activity.
//        }
//    }


//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        Log.i(TAG, "onSaveInstanceState()");
////        outState.putString(Constants.KEY_FIRST_NAME, textView.getText().toString());
////        outState.putString(Constants.KEY_LAST_NAME,  textView.getText().toString());
////        outState.putString(Constants.KEY_EMAIL,      textView.getText().toString());
////        outState.putString(Constants.KEY_USERNAME,   textView.getText().toString());
////        outState.putString(Constants.KEY_OCCUPATION,    textView.getText().toString());
////        outState.putString(Constants.KEY_DESCRIPTION,   textView.getText().toString());
////        outState.putString(Constants.KEY_AGE,           textView.getText().toString());
//
//        Log.i(TAG, "onSaveInstanceState()");
//    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
////        if (savedInstanceState.containsKey(Constants.KEY_USERNAME)) {
////            textViewUser.setText((String)savedInstanceState.get(Constants.KEY_USERNAME));
////        }
////        if (savedInstanceState.containsKey(Constants.KEY_FIRST_NAME)) {
////            textViewFirst.setText((String)savedInstanceState.get(Constants.KEY_FIRST_NAME));
////        }
////        if (savedInstanceState.containsKey(Constants.KEY_LAST_NAME)) {
////            textViewLast.setText((String)savedInstanceState.get(Constants.KEY_LAST_NAME));
////        }
////        if (savedInstanceState.containsKey(Constants.KEY_EMAIL)) {
////            textViewEmail.setText((String)savedInstanceState.get(Constants.KEY_EMAIL));
////        }
////        if (savedInstanceState.containsKey(Constants.KEY_DESCRIPTION)) {
////            textViewDesc.setText((String)savedInstanceState.get(Constants.KEY_DESCRIPTION));
////        }
////        if (savedInstanceState.containsKey(Constants.KEY_OCCUPATION)) {
////            textViewOccu.setText((String)savedInstanceState.get(Constants.KEY_OCCUPATION));
////        }
////        if (savedInstanceState.containsKey(Constants.KEY_AGE)) {
////            textViewAge.setText((String)savedInstanceState.get(Constants.KEY_AGE));
////        }
//
//        Log.i(TAG, "onRestoreInstanceState()");
//    }
}
