package com.example.ad340_hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class HW1_Activity extends AppCompatActivity {

    private static final String TAG = HW1_Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1);

        final Button button = findViewById(R.id.helloWorldBtn);
        button.setOnClickListener(new View.OnClickListener() {
            Context context = getApplicationContext();
            public void onClick(View v) {
                Toast toast = Toast.makeText(this.context, R.string.question, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Log.i(TAG, "onCreate()");
    }

    //note: No onRestart() prior
    @Override
    protected void onStart(){
        super.onStart(); //override default onStart() and obtain from AppCompatActivity (parent) logic.
        Log.i(TAG,"onStart()");
    }

    //restore state for rotation

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

    //save instance state

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

}
