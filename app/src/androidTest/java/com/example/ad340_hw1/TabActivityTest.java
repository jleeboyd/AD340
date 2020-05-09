//package com.example.ad340_hw1;
//
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
//public class TabActivityTest {
//    @Rule
//    public ActivityTestRule<TabActivity> mActivityRule = new ActivityTestRule<>(
//            TabActivity.class);
//
//    private static final String TAG = TabActivityTest.class.getSimpleName();
//
//    //checks that text on screen matches myText
//    @Test
//    public void hasTextOnScreen()
//    {
//        onView(withId(R.id.tabs))
//                .check(matches(withText(R.string.thank_you)));
////        onView(withId(R.id.tabs))
////                .check(matches(withText(R.string.matches)));
////        onView(withId(R.id.tabs))
////                .check(matches(withText(R.string.matches)));
//    }
//}