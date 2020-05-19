//package com.example.ad340_hw1;
//
//import androidx.test.espresso.action.ViewActions;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//import androidx.test.rule.ActivityTestRule;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static androidx.test.espresso.matcher.ViewMatchers.withText;
//
//@RunWith(AndroidJUnit4.class)
//public class IntroActivityTest {
//
//    @Rule
//    public ActivityTestRule<IntroActivity> mActivityRule = new ActivityTestRule<>(
//            IntroActivity.class,true, true);
//
//    private static final String TAG = IntroActivityTest.class.getSimpleName();
//
//
//    @Test
//    public void hasTextOnScreen()
//    {
//        onView(withId(R.id.appTile))
//                .check(matches(withText(R.string.appTitle)));
//    }
//
//    @Test
//    public void clickSignUp()
//    {
//        onView(withId(R.id.signup))
//                .perform(ViewActions.click());
//    }
//}
