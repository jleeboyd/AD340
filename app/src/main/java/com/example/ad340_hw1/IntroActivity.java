//package com.example.ad340_hw1;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class IntroActivity extends AppCompatActivity {
//
//    private static final String TAG = IntroActivity.class.getSimpleName();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_intro);
//        Log.i(TAG, "onCreate()");
//    }
//
//    public void goToMainActivity(View view)
//    {
//        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
//
//        startActivity(intent);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        Log.i(TAG, "Start()");
//    }
//
//    //when rotated onResume is called
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.i(TAG, "onResume()");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.i(TAG, "onPause()");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.i(TAG, "onStop()");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.i(TAG, "onDestroy()");
//    }
//}
