package com.example.ad340_hw1;

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
public class ProfileActivityTest {
    //every time this test is run, startup the main activity to start testing
//    @Rule
//    public ActivityScenarioRule<ThankYouActivity> activityScenarioRule
//            = new ActivityScenarioRule<>(ThankYouActivity.class);
    @Rule
    public ActivityTestRule<ProfileActivity> mActivityRule = new ActivityTestRule<>(
            ProfileActivity.class);

    //checks that text on screen matches myText
//    @Test
//    public void hasTextOnScreen()
//    {
////        onView(withId(R.id.imageViewProfilePhoto))
////                .check(matches(isDisplayed()));
//
//        onView(withId(R.id.textViewProfileFirstName))
//                .check(matches(withText(R.string.username)));
//
//        onView(withId(R.id.textViewProfileFirstName))
//                .check(matches(withText(R.string.username)));
//
//        onView(withId(R.id.textViewProfileFirstName))
//                .check(matches(withText(R.string.username)));
//
//        onView(withId(R.id.textViewProfileFirstName))
//                .check(matches(withText(R.string.username)));
////
////        onView(withId(R.id.imageBtnEdit))
////                .check(matches(isDisplayed()));
//
//    }

//    @Test
//    public void testBackButton()
//    {
//        onView(withId(R.id.BtnBack))
//                .perform(click());
//    }

    //before tests run, have the intent
//    @Before
//    public void myTest()
//    {
//        Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        Intent intent = new Intent (targetContext, ThankYouActivityTest.class);
//                intent.putExtra("foo","bar");
//                        mActivityRule.launchActivity(intent);
//    }



}