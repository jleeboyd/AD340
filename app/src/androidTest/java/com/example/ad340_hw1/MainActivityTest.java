package com.example.ad340_hw1;

import android.content.pm.ActivityInfo;
import android.util.Log;
import android.widget.DatePicker;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    //every time this test is run, startup the main activity to start testing

    //want to user wither ActivityScenarioRule OR ActivityTestRule
//    @Rule
//    public ActivityScenarioRule<MainActivity> activityScenarioRule
//            = new ActivityScenarioRule<>(MainActivity.class);
    public boolean intro = true;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class, true, true);
//    @Rule
//    public ActivityTestRule<MainActivity> mActivityRuleMain = new ActivityTestRule<>(
//            MainActivity.class, true);

    private static final String TAG = MainActivityTest.class.getSimpleName();


//    public void clickIntroSignUp()
//    {
//        IntroActivityTest IntroTest = new IntroActivityTest();
//        IntroTest.clickSignUp();
//    }

    public void hasTextOnScreen()
    {
        onView(withId(R.id.textViewInfo))
                .check(matches(withText(R.string.my_text)));

        onView(withId(R.id.textViewSignup))
                .check(matches(withText(R.string.sign_up)));

        onView(withId(R.id.textViewDOB))
                .check(matches(withText(R.string.dob)));
    }

    public void hasTextOnScreenRotation()
    {
        onView(withId(R.id.editTextFirstName))
                .check(matches(withText(R.string.testFirstName)));
        onView(withId(R.id.editTextLastName))
                .check(matches(withText(R.string.testLastName)));
        onView(withId(R.id.editTextEmail))
                .check(matches(withText(R.string.testEmail)));
        onView(withId(R.id.editTextDescription))
                .check(matches(withText(R.string.testDescription)));
        onView(withId(R.id.editTextOccupation))
                .check(matches(withText(R.string.testOccupation)));

    }

    //checks that text on screen matches myText
    @Test
    public void hasTextOnScreenClick()
    {
//            clickIntroSignUp();

            onView(withId(R.id.textViewInfo))
                    .check(matches(withText(R.string.my_text)));

            onView(withId(R.id.textViewSignup))
                    .check(matches(withText(R.string.sign_up)));

            onView(withId(R.id.textViewDOB))
                    .check(matches(withText(R.string.dob)));
    }

    //onRestore/onSave not being covered. screen may not actually be rotating
//    @Test
//    public void testScreenRotation()
//    {
//        testEnterFields(13,true,false);
//        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
////        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        hasTextOnScreenRotation();
//    }

    //passes in android studio, but fails in circleCI
    //<date picker view is not displayed to user>
    @Test
    public void testSuccessfulSignUp()
    {
        //test input all entries properly and submit
        testEnterFields(13, true, true);
//        TabActivityTest TabTest = new TabActivityTest();
//        TabTest();
    }

    @Test
    public void testUnsuccessfulFirstName()
    {
        //Test first name w/ toast
        testEnterFields(0, false, true);

        //check toast
        onView(withText(R.string.invalid_first))
                .inRoot(withDecorView(not(mActivityRule.getActivity()
                        .getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void testUnsuccessfulLastName()
    {
        //test last name
        testEnterFields(7, true, true);

        onView(withText(R.string.invalid_last))
                .inRoot(withDecorView(not(mActivityRule.getActivity()
                        .getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void testUnsuccessfulEmail()
    {
        //test email
        testEnterFields(8, true, true);

        onView(withText(R.string.invalid_email))
                .inRoot(withDecorView(not(mActivityRule.getActivity()
                        .getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void testUnsuccessfulUsername()
    {
        //test user
        testEnterFields(9, true, true);

        onView(withText(R.string.invalid_user))
                .inRoot(withDecorView(not(mActivityRule.getActivity()
                        .getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void testUnsuccessfulOccupation()
    {
        //test occupation
        testEnterFields(10, true, true);
        onView(withText(R.string.invalid_occu))
                .inRoot(withDecorView(not(mActivityRule.getActivity()
                        .getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void testUnsuccessfulDescription()
    {
        //test description
        testEnterFields(11, true, true);
        onView(withText(R.string.invalid_desc))
                .inRoot(withDecorView(not(mActivityRule.getActivity()
                        .getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    @Test
    public void testUnsuccessfulDOB()
    {
        //test dob
        testEnterFields(12, true, true);

        onView(withText(R.string.invalid_dob))
                .inRoot(withDecorView(not(mActivityRule.getActivity()
                .getWindow().getDecorView()))).check(matches(isDisplayed()));

//        testEnterFields(6, false);
    }


    //check toast
//        onView(withText(R.string.invalid_first)).
//                inRoot(withDecorView(not(is(mActivityRule.getWindow().getDecorView())))).
//                check(matches(isDisplayed()));

    //test successful and unsuccessful data input whether hasContent == true
    //can call single or multiple typeText depending on num param
//    @Test
    private void testEnterFields(int num, boolean hasContent, boolean submit)
    {
//        clickIntroSignUp();
        //edit text fields input up until number param
        if(num >= 7 || num == 0)
        {
            if(hasContent)
            {
//                onView(withId(R.id.editTextFirstName)).perform(typeText("Ben"));
                onView(withId(R.id.editTextFirstName)).perform(typeText("Ben"));
            }

            else{
                onView(withId(R.id.editTextFirstName)).perform(typeText(""));
            }
//            Log.i(TAG,"in testEnterFields");
        }

        //LAST
        if(num >= 8 || num == 1)
        {
            if (hasContent)
            {
                onView(withId(R.id.editTextLastName)).perform(typeText("Chang"));
            }
            else {
                onView(withId(R.id.editTextLastName)).perform(typeText(""));
            }
        }

        //EMAIL
        if (num >= 9 || num == 2)
        {
            if (hasContent)
            {
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                //Create variable based on time and set to email. So testing doesn't have to create a new email
                //for new db entry each time.
                onView(withId(R.id.editTextEmail)).perform(typeText("r@o.com"));
            }

            else {
                onView(withId(R.id.editTextEmail)).perform(typeText(""));
            }
        }

        //USER
        if (num >= 10 || num == 3)
        {
            if (hasContent)
            {
                onView(withId(R.id.editTextUsername)).perform(typeText("ElTigre"));
            }

            else {
                onView(withId(R.id.editTextUsername)).perform(typeText(""));
            }
        }

        //OCCU
        if (num >= 11 || num == 4)
        {
            if (hasContent)
            {
                onView(withId(R.id.editTextOccupation)).perform(typeText("Spanish Teacher"), closeSoftKeyboard());
            }

            else {
                onView(withId(R.id.editTextOccupation)).perform(typeText(""), closeSoftKeyboard());
            }
        }

        ///DESC
        if (num >= 12 || num == 5)
        {
            if (hasContent)
            {
                onView(withId(R.id.editTextDescription)).perform(typeText("I am a man who can never die"), closeSoftKeyboard());
            }

            else {
                onView(withId(R.id.editTextDescription)).perform(typeText(""), closeSoftKeyboard());
            }
        }

        //DOB
        if(num >= 13 || num == 6)
        {
            if(hasContent)
            {
                onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                        .perform(ViewActions.scrollTo(), PickerActions.setDate(2000, 2, 1), closeSoftKeyboard());
            }

            //invalid birth date
            else{
                onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                        .perform(ViewActions.scrollTo(), PickerActions.setDate(2010, 2, 1), closeSoftKeyboard());
            }
        }

        //scroll to bottom and submit data entry in form
        if(submit){
            onView(withId(R.id.btnSubmit)).perform(ViewActions.scrollTo(), click());
        }

    }

    //test the description editText view's max char limit of 50
//    @Test
//    public void testDescriptionMaxChar()
//    {
//
//    }


}