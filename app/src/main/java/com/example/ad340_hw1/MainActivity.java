package com.example.ad340_hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = MainActivity.class.getSimpleName(); //references this activity vs. others.

    private TextView textView;
    private EditText editTextFirst;
    private EditText editTextLast;
    private EditText editTextEmail;
    private EditText editTextUser;
    private Button button;
    private DatePicker date;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewInfo);
        textView = findViewById(R.id.textViewSignup);

        editTextFirst = findViewById(R.id.editTextFirstName);
        editTextLast = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUser = findViewById(R.id.editTextUsername);

        date = findViewById(R.id.dobDatePicker);

        button = findViewById(R.id.btnSubmit);


        Log.i(TAG, "onCreate()"); //logs successful onCreate lifecycle function to the console.
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Start()");
    }

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

    //verify all data is input correctly
    //put all goToThankYouActivity validation here
//    public void VerifyCredentials(String myText){
//
//    }

///////////// Go to Activity Section

    public void goToThankYouActivity(View view) {

        String first = editTextFirst.getText().toString();
        String last  = editTextLast.getText().toString();
        String email = editTextEmail.getText().toString();
        String user  = editTextUser.getText().toString();

        int dobYear  = date.getYear();
        int dobMonth = date.getMonth();
        int dobDay   = date.getDayOfMonth();

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);



        Log.i(TAG, Integer.toString(dobYear, dobMonth));


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

        else if(!email.contains("@"))
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

        else if((year - dobYear) - ((month - dobMonth) / 12.0) - ((day - dobDay) / 30.0) < 18 ) //update for variation in days of month
        {
            Toast toast = Toast.makeText(this, R.string.invalid_dob, Toast.LENGTH_SHORT);
            toast.show();
            Log.i(TAG, "dob: "+ ((2020 - dobYear) - ((4 - dobMonth) / 12.0)));
        }

        else {

            Intent intent = new Intent(MainActivity.this, ThankYouActivity.class); //go from 1st param activity to 2nd param activity

            //put verified user form info into intent to be sent to next activity
            intent.putExtra(Constants.KEY_FIRST_NAME, first);
            intent.putExtra(Constants.KEY_LAST_NAME, last);
            intent.putExtra(Constants.KEY_EMAIL, email);
            intent.putExtra(Constants.KEY_USERNAME, user);

            startActivity(intent);
        }
    }
}
