package com.example.quizapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.quizapp.ui.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule
            = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.username))
                .perform(typeText("username"))
                .check(matches(withText("username")));
        onView(withId(R.id.password))
                .perform(typeText("password"))
                .check(matches(withText("password")));
    }

    @Test
    public void validateSignUp() {
        onView(withId(R.id.username))
                .perform(typeText("username"));
        onView(withId(R.id.password))
                .perform(typeText("password"));
        onView(withId(R.id.login))
                .perform(click());
    }
}
