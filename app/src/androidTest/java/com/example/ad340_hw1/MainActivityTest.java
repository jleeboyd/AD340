package com.example.ad340_hw1;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.Date;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
//import static androidx.test.espresso.contrib.PickerActions.setDate;


import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    //every time this test is run, startup the main activity to start testing
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    //checks that text on screen matches myText
    @Test
    public void hasTextOnScreen()
    {
        onView(withId(R.id.textViewInfo))
                .check(matches(withText(R.string.my_text)));

        onView(withId(R.id.textViewSignup))
                .check(matches(withText(R.string.sign_up)));

//
//        onView(withId(R.id.editTextLastName))
//                .check(matches(withText(R.string.last_name)));
//
//        onView(withId(R.id.editTextEmail))
//                .check(matches(withText(R.string.email)));
//
//        onView(withId(R.id.editTextUsername))
//                .check(matches(withText(R.string.username)));
    }

    //test successful info input and button click
    //incomplete -> datepicker + button click
    @Test
    public void testSuccessfulSignup()
    {
        //edit text fields input
        onView(withId(R.id.editTextFirstName)).perform(typeText("Jack"));
        onView(withId(R.id.editTextLastName)).perform(typeText("Boyd"));
        onView(withId(R.id.editTextEmail)).perform(typeText("Jack@Boyd.com"));
        onView(withId(R.id.editTextUsername)).perform(typeText("jackboyd"));

        //date of birth checker
//        onView(withId(R.id.start_date_picker)).perform(PickerActions.setDate(2000, 1, 1));

        // locate sign up button and perform click
//        onView(allOf(withText("Submit"), isDescendantOfA(withId(R.id.btnSubmit))))
//                .perform(click());
    }

//
//    @Test
//    public void testUnuccessfulSignup()
//    {
//        //call other tests
//    }
//
//    //test if first name field is blank
//    @Test
//    public void testFirstNameToast()
//    {
//        //button click
//        //check if toast matches
//    }
//
//    //test if last name field is blank
//    @Test
//    public void testLastNameToast()
//    {
//        //enter first name and button click
//        //check if toast matches
//    }
//
//    //test if email field is blank
//    @Test
//    public void testEmailToast()
//    {
//        //enter first name, last name and button click
//        //check if toast matches
//    }
//
//    //test if username field is blank
//    @Test
//    public void testUsernameToast()
//    {
//        //enter first name, last name, email and button click
//        //check if toast matches
//    }
//
//    //test date picker toast
//    @Test
//    public void testDatePickerToast()
//    {
//        //enter first name, last name, email, username and incorrect date and button click
//        //check if toast matches
//    }
//
//

}