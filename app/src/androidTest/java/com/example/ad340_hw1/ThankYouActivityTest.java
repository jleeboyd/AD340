package com.example.ad340_hw1;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


//import static org.junit.Assert.*;
//@RunWith(AndroidJUnit4.class)
//public class ThankYouActivityTest {
//    //every time this test is run, startup the main activity to start testing
//    @Rule
//    public ActivityScenarioRule<ThankYouActivity> activityScenarioRule
//            = new ActivityScenarioRule<>(ThankYouActivity.class);
//
//    //checks that text on screen matches myText
//    @Test
//    public void hasTextOnScreen()
//    {
//        onView(withId(R.id.textViewThankYou))
//                .check(matches(withText(R.string.thank_you)));
//
//    }
//
//
//
//}