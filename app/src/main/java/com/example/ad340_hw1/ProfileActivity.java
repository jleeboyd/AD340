package com.example.ad340_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = ProfileActivity.class.getSimpleName();

    TextView textViewFirst;
    TextView textViewLast;
    TextView textViewUser;
    TextView textViewEmail;
    TextView textViewAge;
    TextView textViewDescription;
    TextView textViewOccupation;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        textViewFirst = findViewById(R.id.textViewProfileFirstName);
        textViewLast = findViewById(R.id.textViewProfileLastName);
        textViewUser = findViewById(R.id.textViewProfileUsername);
        textViewEmail = findViewById(R.id.textViewProfileEmail);
        textViewAge = findViewById(R.id.textViewProfileAge);
        textViewDescription = findViewById(R.id.textViewProfileDescription);
        textViewOccupation = findViewById(R.id.textViewProfileOccupation);

//        button = findViewById(R.id.BtnBack);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

//        StringBuilder msg = new StringBuilder(getResources().getString(R.string.thank_you));
//        msg.append(" "+ b.getString(Constants.KEY_USERNAME));

        textViewFirst.setText(b.getString(Constants.KEY_FIRST_NAME));
        textViewLast.setText(b.getString(Constants.KEY_LAST_NAME));
        textViewUser.setText(b.getString(Constants.KEY_USERNAME));
        textViewEmail.setText(b.getString(Constants.KEY_EMAIL));
        textViewAge.setText(b.getString(Constants.KEY_AGE));
        textViewDescription.setText(b.getString(Constants.KEY_DESCRIPTION));
        textViewOccupation.setText(b.getString(Constants.KEY_OCCUPATION));

        Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onRestart(){
        super.onRestart(); //override default onStart() and obtain from AppCompatActivity (parent) logic.
        Log.i(TAG,"onRestart()");
    }

    @Override
    protected void onStart(){
        super.onStart(); //override default onStart() and obtain from AppCompatActivity (parent) logic.
        Log.i(TAG,"onStart()");
    }

    //restore state for rotation

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

//        if (savedInstanceState.containsKey(Constants.KEY_USERNAME)) {
//            textViewUser.setText((String)savedInstanceState.get(Constants.KEY_USERNAME));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_FIRST_NAME)) {
//            textViewFirst.setText((String)savedInstanceState.get(Constants.KEY_FIRST_NAME));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_LAST_NAME)) {
//            textViewLast.setText((String)savedInstanceState.get(Constants.KEY_LAST_NAME));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_EMAIL)) {
//            textViewEmail.setText((String)savedInstanceState.get(Constants.KEY_EMAIL));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_DESCRIPTION)) {
//            textViewDesc.setText((String)savedInstanceState.get(Constants.KEY_DESCRIPTION));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_OCCUPATION)) {
//            textViewOccu.setText((String)savedInstanceState.get(Constants.KEY_OCCUPATION));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_AGE)) {
//            textViewAge.setText((String)savedInstanceState.get(Constants.KEY_AGE));
//        }

        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
//        outState.putString(Constants.KEY_FIRST_NAME, textView.getText().toString());
//        outState.putString(Constants.KEY_LAST_NAME,  textView.getText().toString());
//        outState.putString(Constants.KEY_EMAIL,      textView.getText().toString());
//        outState.putString(Constants.KEY_USERNAME,   textView.getText().toString());
//        outState.putString(Constants.KEY_OCCUPATION,    textView.getText().toString());
//        outState.putString(Constants.KEY_DESCRIPTION,   textView.getText().toString());
//        outState.putString(Constants.KEY_AGE,           textView.getText().toString());

        Log.i(TAG, "onSaveInstanceState()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG,"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    public void goToMainActivity(View view) {
//        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //do no onCreate() main again w/ manifest
//        startActivity(intent);
          finish(); //to onDestroy() current activity.
    }
}
