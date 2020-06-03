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
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class TabActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class, true, true);
//    //testing
//    @Rule
//    public ActivityTestRule<TabActivity> mActivityRule = new ActivityTestRule<>(
//        TabActivity.class, true, true);

//    private static final String TAG = TabActivityTest.class.getSimpleName();

    //HOW TO TEST DATA PERSISTENCE? LEAVE APP
//LEFT OFF WITH TESTING AND CREATING RECYCLER VIEW
    @Test
    public void hasTabActivityTestAll()
    {
        testSuccessfulSignupMain();

        // Matches Fragment
        hasTextOnScreenMatches();
        navigation();

        // Profile Fragment
        hasTextOnScreenProfile();
        navigation();

        // Settings Fragment
        hasTextOnScreenSettings();
        testUnsuccessfulSettings();

        // Starts where testUnsuccessfulSettings() ends
        successfulSaveSettings();

//        hasImageMatches();
    }

    public void testUnsuccessfulSettings() {
//        navigation(); for testing
//        navigation();
        unsuccessfulMaxDistance();
        unsuccessfulPrivacy();
        unsuccessfulMinAge();
        unsuccessfulMaxAge();
    }

    public void testSuccessfulSignupMain()
    {
        MainActivityTest Main = new MainActivityTest();
        Main.testSuccessfulSignUp();
    }

    // Navigate between tabs
    public void navigation()
    {
        //NOTE TO SELF: swipe LEFT to go RIGHT
        onView(withId(R.id.viewpager)).perform(ViewActions.swipeLeft());
    }

    public void hasImageMatches(){
//        onView(ViewMatchers.withId(R.id.my_recycler_view).atPs
    }
    public void hasNameMatches(){

    }
    public void hasDescriptionMatches(){

    }
    public void likeButtonClickMatches(){

    }

    public void hasTextOnScreenMatches()
    {
        //Test like button with toast
        //match has description
        //match has name
        //match has image

        //scroll to card and click card at positions
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3,click()));
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4,click()));
        onView(ViewMatchers.withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(5,click()));

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
                .check(matches(withText("ElTigre")));

        onView(withId(R.id.textViewProfileFirstName))
                .check(matches(withText("Ben")));

        onView(withId(R.id.textViewProfileLastName))
                .check(matches(withText("Chang")));

        onView(withId(R.id.textViewProfileEmail))
                .check(matches(withText(R.string.test_email_3)));

        onView(withId(R.id.textViewProfileOccupation))
                .check(matches(withText("Spanish Teacher")));

        onView(withId(R.id.textViewProfileDescription))
                .check(matches(withText("I am a man who can never die")));
    }


    public void hasTextOnScreenSettings()
    {
        onView(withId(R.id.textViewSettings))
                .check(matches(withText(R.string.settings)));
        onView(withId(R.id.textViewReminderTime))
                .check(matches(withText(R.string.reminder_title)));
        onView(withId(R.id.textViewMaxDistance))
                .check(matches(withText(R.string.max_distance_title)));
        onView(withId(R.id.textViewGender))
                .check(matches(withText(R.string.gender_title)));
        onView(withId(R.id.textViewPrivacy))
                .check(matches(withText(R.string.privacy_title)));
        onView(withId(R.id.textViewMinAge))
                .check(matches(withText(R.string.min_age_title)));
        onView(withId(R.id.textViewMaxAge))
                .check(matches(withText(R.string.max_age_title)));
    }

    // Test for properly input and saved toast starts where unsuccessful finished
    public void successfulSaveSettings() {
        testInputSettings(5,true,true);
        checkToast(R.string.settings_saved);
    }

    // Test invalid inputs to fields with toast checks. Gender and Reminder time left out due to nullable values
    public void unsuccessfulMaxDistance() {
        testInputSettings(0, true, true);
        checkToast(R.string.invalid_distance);
        clearSomeText(R.id.editTextMaxDistance);
    }

    public void unsuccessfulPrivacy() {
        testInputSettings(8, true, true);
        checkToast(R.string.invalid_privacy);
        clearSomeText(R.id.editTextMaxDistance);
    }

    public void unsuccessfulMinAge() {
        testInputSettings(9, true, true);
        checkToast(R.string.invalid_dob);
        clearSomeText(R.id.editTextMinAge);

    }

    public void unsuccessfulMaxAge() {
        testInputSettings(4, true, true);
        checkToast(R.string.invalid_age_range);
//        clearSomeText(R.id.editTextMaxAge);
    }


    // Input fields for Settings
    public void testInputSettings(int num, boolean hasContent, boolean submit) {

        // Edit text fields input up until number param
        if(num >= 6 || num == 0) {
            typeSomeText(R.id.editTextReminderTime, "");
        }

        if(num >= 7 || num == 1){
            if(hasContent){
                typeSomeText(R.id.editTextMaxDistance, "10");
            }

            // Test Max distance != < 0 || > 50
            else {
                typeSomeText(R.id.editTextMaxDistance, String.valueOf(0));
            }
        }

        if(num >= 8 || num == 2) {
            typeSomeText(R.id.editTextGender, "");
        }

        if(num >= 9 || num == 3) {
            if(hasContent){
                typeSomeText(R.id.editTextPrivacy, "Private");
            }

            // Test Max distance != < 0 || > 50
            else {
                //Type nothing because of autofill nullcheck feature in fragment for ints
                typeSomeText(R.id.editTextPrivacy, "");
            }
        }

        if(num >= 10 || num == 4) {
            if(hasContent){
                typeSomeText(R.id.editTextMinAge, "18");
            }

            // Test Max distance != < 0 || > 50
            else {
                typeSomeText(R.id.editTextMinAge, "17");
            }
        }

        if(num >= 11 || num == 5) {
            if(hasContent){
                typeSomeText(R.id.editTextMaxAge, "30");
            }

            // Test Max distance != < 0 || > 50
            else {
                typeSomeText(R.id.editTextMaxAge, "");
            }
        }

        if(submit) {
            onView(withId(R.id.buttonSaveSettings)).perform(ViewActions.scrollTo(), click());
        }

    }

    // Check toasts given R.id.String as int param for Settings
    public void checkToast(int text) {

        onView(withText(text))
                .inRoot(withDecorView(not(mActivityRule.getActivity()
                        .getWindow().getDecorView()))).check(matches(isDisplayed()));
    }

    // Type text into fields based on view and input text
    public void typeSomeText(int view, String inputText) {
        onView(withId(view)).perform(typeText(inputText), closeSoftKeyboard());
    }

    public void clearSomeText(int view) {
        onView(withId(view)).perform(clearText());
    }

    public void testDataPersistenceSettings() {
        //test data persistence with singup, data input, leave app signup again check for data somehow
    }
}