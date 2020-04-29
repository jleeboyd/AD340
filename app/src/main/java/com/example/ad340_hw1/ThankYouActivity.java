package com.example.ad340_hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class ThankYouActivity extends AppCompatActivity {

    private static final String TAG = ThankYouActivity.class.getSimpleName();
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        textView = findViewById(R.id.textViewThankYou);
        button = findViewById(R.id.BtnBack);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        StringBuilder msg = new StringBuilder(getResources().getString(R.string.thank_you));
        msg.append(" "+ b.getString(Constants.KEY_USERNAME));
        textView.setText(msg);

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

        Log.i(TAG, "onRestoreInstanceState()");
        if (savedInstanceState.containsKey(Constants.KEY_USERNAME)) {
            textView.setText((String)savedInstanceState.get(Constants.KEY_USERNAME));
        }

//        if (savedInstanceState.containsKey(Constants.KEY_BTN_TEXT)) {
//            button.setText((String) savedInstanceState.get(Constants.KEY_BTN_TEXT));
//        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_FIRST_NAME, textView.getText().toString());
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
        Intent intent = new Intent(ThankYouActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //do no onCreate() main again w/ manifest
        startActivity(intent);
//        finish(); //to onDestroy() current activity.
    }
}
