package com.example.ad340_hw1;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class TabActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class, true, true);

    private static final String TAG = TabActivityTest.class.getSimpleName();


    @Test
    public void hasTextOnScreenAll()
    {
        testSuccessfulSignup();
        hasTextOnScreenMatches();
        navigation();
        hasTextOnScreenProfile();
        navigation();
        hasTextOnScreenSettings();
    }

    public void navigation()
    {
        //NOTE TO SELF: swipe LEFT to go RIGHT
        onView(withId(R.id.viewpager)).perform(ViewActions.swipeLeft());
//        onView(withId(R.id.tabs)).perform(ViewActions.swipeLeft());

    }
    public void hasTextOnScreenMatches()
    {
        onView(withId(R.id.textViewMatches))
                .check(matches(withText(R.string.matches)));

    }

    public void hasTextOnScreenProfile()
    {
        onView(withId(R.id.textViewProfileUsername))
                .check(matches(withText("El Tigre")));

        onView(withId(R.id.textViewProfileFirstName))
                .check(matches(withText("Ben")));

        onView(withId(R.id.textViewProfileLastName))
                .check(matches(withText("Chang")));

        onView(withId(R.id.textViewProfileEmail))
                .check(matches(withText("ELTigre@yahoo.com")));

        onView(withId(R.id.textViewProfileOccupation))
                .check(matches(withText("Spanish Teacher")));

        onView(withId(R.id.textViewProfileDescription))
                .check(matches(withText("Lookin for love")));
    }

    public void hasTextOnScreenSettings()
    {
        onView(withId(R.id.textViewSettings))
                .check(matches(withText(R.string.settings)));
    }

    //signs up user successfully

    public void testSuccessfulSignup()
    {
        MainActivityTest Main = new MainActivityTest();
        Main.testSuccessfulSignUp();
    }
}