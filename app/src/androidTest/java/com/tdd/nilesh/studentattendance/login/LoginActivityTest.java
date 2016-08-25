package com.tdd.nilesh.studentattendance.login;


import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.tdd.nilesh.studentattendance.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by NJ on 24/08/16.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    ActivityTestRule<LoginActivity> activityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkUserNameEditTextIsDisplayed() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).check(matches(isDisplayed()));
    }

    @Test
    public void checkPasswordEditTextIsDisplayed() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
    }

    @Test
    public void checkErrorMessageIsDisplayedForEmptyData() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Please check Username or Password.")).check(matches(isDisplayed()));
    }

    @Test
    public void checkLoginSuccess()
    {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.edt_user_name)).perform(typeText("nj"),closeSoftKeyboard());
        onView(withId(R.id.edt_password)).perform(typeText("tdd"),closeSoftKeyboard());
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Login successful.")).check(matches(isDisplayed()));

    }



}
