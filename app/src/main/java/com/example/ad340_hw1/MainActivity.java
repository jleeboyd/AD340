package com.example.ad340_hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = MainActivity.class.getSimpleName(); //references this activity vs. others.

//    private TextView textView;
    private EditText editTextFirst;
    private EditText editTextLast;
    private EditText editTextEmail;
    private EditText editTextUser;

    private DatePicker date;

    private Calendar now;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView = findViewById(R.id.textViewInfo);
//        textView = findViewById(R.id.textViewSignup);

        //set views
        editTextFirst = findViewById(R.id.editTextFirstName);
        editTextLast  = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUser  = findViewById(R.id.editTextUsername);

        date = findViewById(R.id.dobDatePicker);

        //store current date
        now   = Calendar.getInstance();
        year  = now.get(Calendar.YEAR);
        month = now.get(Calendar.MONTH);
        day   = now.get(Calendar.DAY_OF_MONTH);


//        button = findViewById(R.id.btnSubmit);

        Log.i(TAG, "onCreate()"); //logs successful onCreate lifecycle function to the console.
    }

    //onRestart from other activity, reset editText fields and datepicker
    @Override
    protected void onRestart() {
        super.onRestart();

        editTextFirst.setText("");
        editTextLast.setText("");
        editTextEmail.setText("");
        editTextUser.setText("");
        date.updateDate(year, month, day);

        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "Start()");
    }

    //when rotated onResume is called
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
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

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey(Constants.KEY_FIRST_NAME)) {
            editTextFirst.setText((String)savedInstanceState.get(Constants.KEY_FIRST_NAME));
        }
        if (savedInstanceState.containsKey(Constants.KEY_LAST_NAME)) {
            editTextLast.setText((String)savedInstanceState.get(Constants.KEY_LAST_NAME));
        }
        if (savedInstanceState.containsKey(Constants.KEY_EMAIL)) {
            editTextEmail.setText((String) savedInstanceState.get(Constants.KEY_EMAIL));
        }
        if (savedInstanceState.containsKey(Constants.KEY_USERNAME)) {
            editTextUser.setText((String) savedInstanceState.get(Constants.KEY_USERNAME));
        }

        //restore date picker
//        if (savedInstanceState.containsKey(Constants.KEY_DOB_YEAR)) {
//            editTextUser.setText((String) savedInstanceState.get(Constants.KEY_DOB_YEAR)));
//        }
//
//        if (savedInstanceState.containsKey(Constants.KEY_USERNAME)) {
//            editTextUser.setText((String) savedInstanceState.get(Constants.KEY_USERNAME));
//        }

        //need date picker

        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putString(Constants.KEY_FIRST_NAME, editTextFirst.getText().toString());
        outState.putString(Constants.KEY_LAST_NAME,  editTextLast.getText().toString());
        outState.putString(Constants.KEY_EMAIL,      editTextEmail.getText().toString());
        outState.putString(Constants.KEY_USERNAME,   editTextUser.getText().toString());

        //store date picker current data
        outState.putInt(String.valueOf(Constants.KEY_YEAR), date.getYear());
        outState.putInt(String.valueOf(Constants.KEY_MONTH), date.getMonth());
        outState.putInt(String.valueOf(Constants.KEY_DAY), date.getDayOfMonth());

        Log.i(TAG, "onSaveInstanceState()");
//        Log.i(TAG, String.valueOf(outState.get(String.valueOf(Constants.KEY_DOB_YEAR))));
    }

    public int dayCounter(int month)
    {
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31}; //days in months
        int sumDays = 0;
        for (int index = 0; index < month; index++) // count sum of days in months up to chosen m
        {
            sumDays += months[index];
        }
//        Log.i(TAG, String.valueOf(sumDays));
        return sumDays;

    }

    public static boolean isValidEmail(CharSequence target) {
        Log.i(TAG,String.valueOf(target)+": email");
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

///////////// Go to Activity Section

    //validate age of user and then send bundle to ThankYouActivity
    public void goToThankYouActivity(View view) {

        String first = editTextFirst.getText().toString();
        String last  = editTextLast.getText().toString();
        String email = editTextEmail.getText().toString();
        String user  = editTextUser.getText().toString();

        int dobYear  = date.getYear();
        int dobMonth = date.getMonth();
        int dobDay   = date.getDayOfMonth();


        //calculate age of user
        int dateDays = (dobYear * 365) + dayCounter(dobMonth) + dobDay;

        int currentDays = (year * 365) + dayCounter(month) + day;

        int ageInDays = currentDays - dateDays;

        double ageInYears = ageInDays / 365.0;
        Log.i(TAG, String.valueOf(ageInYears)+": age");

        CharSequence mySequence = email;
        Log.i(TAG, email);


//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        int month = Calendar.getInstance().get(Calendar.MONTH);
//        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);




        //validate user form info is correct
        if(first.equals(""))
        {
            Toast toast = Toast.makeText(this, R.string.invalid_first, Toast.LENGTH_SHORT);
            toast.show();
            Log.i(TAG, "first");
        }

        else if(last.equals(""))
        {
            Toast toast = Toast.makeText(this, R.string.invalid_last, Toast.LENGTH_SHORT);
            toast.show();
            Log.i(TAG, "last");
        }

        else if(!isValidEmail(mySequence))
        {
            Toast toast = Toast.makeText(this, R.string.invalid_email, Toast.LENGTH_SHORT);
            toast.show();
            Log.i(TAG, "email");
        }

        else if(user.equals(""))
        {
            Toast toast = Toast.makeText(this, R.string.invalid_user, Toast.LENGTH_SHORT);
            toast.show();
            Log.i(TAG, "user");
        }

        else if(ageInYears < 18 ) //update for variation in days of month
        {
            Toast toast = Toast.makeText(this, R.string.invalid_dob, Toast.LENGTH_SHORT);
            toast.show();
            Log.i(TAG, String.valueOf(ageInYears));
        }

        else {

            Intent intent = new Intent(MainActivity.this, ThankYouActivity.class); //go from 1st param activity to 2nd param activity
//            Log.i(TAG, email);
            //put verified user form info into intent to be sent to next activity
            intent.putExtra(Constants.KEY_FIRST_NAME, first);
            intent.putExtra(Constants.KEY_LAST_NAME, last);
            intent.putExtra(Constants.KEY_EMAIL, email);
            intent.putExtra(Constants.KEY_USERNAME, user);
            intent.putExtra(Constants.KEY_AGE, ageInYears);
            //intent.putExtra() verified date of birth

            startActivity(intent);
        }
    }
}
