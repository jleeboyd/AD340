package com.example.ad340_hw1;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
        //scroll to card and click card at positions
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3,click()));

        //check text matches, check SO for next steps
        //https://stackoverflow.com/questions/51678563/how-to-access-recyclerview-viewholder-with-espresso
//        onView(ViewMatchers.withId(R.id.my_recycler_view))
//                .perform(RecyclerViewActions.actionOnItemAtPosition(0,click())
//                .check(matches(withText(R.string.dean))));
//        onView(withId(R.id.textViewInfo))
//                .check(matches(withText(R.string.my_text)));
         //match text on card
//        String itemElementText = mActivityRule.getActivity().getResources()
//                .getString(R.string.dean)
//                + String.valueOf(1);
//
//        onView(withText(itemElementText)).check(matches(isDisplayed()));


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
                .check(matches(withText("ELTigre@greendalecollege.edu")));

        onView(withId(R.id.textViewProfileOccupation))
                .check(matches(withText("Spanish Teacher")));

        onView(withId(R.id.textViewProfileDescription))
                .check(matches(withText("I am a man who can never die")));
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