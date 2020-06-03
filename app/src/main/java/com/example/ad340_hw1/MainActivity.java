package com.example.ad340_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = MainActivity.class.getSimpleName(); //references this activity vs. others.

//    private TextView textView;
    private EditText editTextFirst;
    private EditText editTextLast;
    private EditText editTextEmail;
    private EditText editTextUser;
    private EditText editTextDescription;
    private EditText editTextOccupation;

    private DatePicker date;

    private Calendar now;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //set views
        editTextFirst = findViewById(R.id.editTextFirstName);
        editTextLast  = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUser  = findViewById(R.id.editTextUsername);
        editTextOccupation = findViewById(R.id.editTextOccupation);
        editTextDescription = findViewById(R.id.editTextDescription);

        date = findViewById(R.id.dobDatePicker);

        //store current date
        now   = Calendar.getInstance();
        year  = now.get(Calendar.YEAR);
        month = now.get(Calendar.MONTH);
        day   = now.get(Calendar.DAY_OF_MONTH);


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
        editTextDescription.setText("");
        editTextOccupation.setText("");
        date.updateDate(year, month, day);

        Log.i(TAG, "onRestart()");
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
        if (savedInstanceState.containsKey(Constants.KEY_DESCRIPTION)) {
            editTextUser.setText((String) savedInstanceState.get(Constants.KEY_DESCRIPTION));
        }
        if (savedInstanceState.containsKey(Constants.KEY_OCCUPATION)) {
            editTextUser.setText((String) savedInstanceState.get(Constants.KEY_OCCUPATION));
        }

        //onRestore date picker
        int myYear = Integer.parseInt((String) savedInstanceState.get(Constants.KEY_YEAR));
        int myMonth = Integer.parseInt((String) savedInstanceState.get(Constants.KEY_MONTH));
        int myDay = Integer.parseInt((String) savedInstanceState.get(Constants.KEY_DAY));

        if (savedInstanceState.containsKey(String.valueOf((Constants.KEY_YEAR)))) {
            date.updateDate(myYear,myMonth,myDay);
        }

        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putString(Constants.KEY_FIRST_NAME, editTextFirst.getText().toString());
        outState.putString(Constants.KEY_LAST_NAME,  editTextLast.getText().toString());
        outState.putString(Constants.KEY_EMAIL,      editTextEmail.getText().toString());
        outState.putString(Constants.KEY_USERNAME,   editTextUser.getText().toString());
        outState.putString(Constants.KEY_OCCUPATION,    editTextUser.getText().toString());
        outState.putString(Constants.KEY_DESCRIPTION,   editTextUser.getText().toString());

        //onSave datePicker
        outState.putString(String.valueOf(Constants.KEY_YEAR), String.valueOf(date.getYear()));
        outState.putString(String.valueOf(Constants.KEY_MONTH), String.valueOf(date.getMonth()));
        outState.putString(String.valueOf(Constants.KEY_DAY), String.valueOf(date.getDayOfMonth()));

        Log.i(TAG, "onSaveInstanceState()");
    }


    public static boolean isValidEmail(CharSequence target) {
        Log.i(TAG,String.valueOf(target)+": email");
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

///////////// Go to Activity Section

    //validate age of user and then send bundle to ThankYouActivity
    public void goToTabActivity(View view) {

        String first = editTextFirst.getText().toString();
        String last  = editTextLast.getText().toString();
        String email = editTextEmail.getText().toString();
        String user  = editTextUser.getText().toString();
        String desc  = editTextDescription.getText().toString();
        String occu  = editTextOccupation.getText().toString();

        //calculate age of user
        int dobYear  = date.getYear();
        int dobMonth = date.getMonth();
        int dobDay   = date.getDayOfMonth();

        Log.i(TAG, String.valueOf(dobYear)+": birthyear");
        Log.i(TAG, String.valueOf(dobMonth)+": birthmonth");
        Log.i(TAG, String.valueOf(dobDay)+": birthday");

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(dobYear, dobMonth, dobDay);
        Log.i(TAG, String.valueOf(birthday)+": birthday");

        Period p = Period.between(birthday, today);

        int ageInYears = p.getYears();

        Log.i(TAG, String.valueOf(ageInYears)+": age");

        CharSequence mySequence = email;
        Log.i(TAG, email);



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
            Log.i(TAG, "username");
        }

        else if(occu.equals(""))
        {
            Toast toast = Toast.makeText(this, R.string.invalid_occu, Toast.LENGTH_SHORT);
            toast.show();
            Log.i(TAG, "occupation");
        }

        else if(desc.equals(""))
        {
            Toast toast = Toast.makeText(this, R.string.invalid_desc, Toast.LENGTH_SHORT);
            toast.show();
            Log.i(TAG, "description");
        }

        else if(ageInYears < 18) //update for variation in days of month
        {
            Toast toast = Toast.makeText(this, R.string.invalid_dob, Toast.LENGTH_SHORT);
            toast.show();
            Log.i(TAG, String.valueOf(ageInYears) + ": Invalid Age");
        }

        else {

            Intent intent = new Intent(MainActivity.this, TabActivity.class); //go from 1st param activity to 2nd param activity

            //put verified user form info into intent to be sent to next activity
            intent.putExtra(Constants.KEY_FIRST_NAME, first);
            intent.putExtra(Constants.KEY_LAST_NAME, last);
            intent.putExtra(Constants.KEY_EMAIL, email);
            intent.putExtra(Constants.KEY_USERNAME, user);
            intent.putExtra(Constants.KEY_AGE, String.valueOf(ageInYears));
            intent.putExtra(Constants.KEY_DESCRIPTION, desc);
            intent.putExtra(Constants.KEY_OCCUPATION, occu);

            startActivity(intent);

        }
    }
}
