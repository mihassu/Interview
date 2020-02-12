package ru.geekbrains.converter;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ConvertActivityMyTest {

    @Rule
    public ActivityTestRule<ConvertActivity> activityTestRule = new ActivityTestRule<>(ConvertActivity.class);

    @Test
    public void ConvertActivity_ToMetrPerSecondButton_Test(){

        //ввести текст
        String TYPED_TEXT = "7";
        onView(withId(R.id.kilometersValue))
                .perform(typeText(TYPED_TEXT))
                .perform(closeSoftKeyboard());

        //клик на кнопку
        onView(withId(R.id.toMetrPerSecond))
                .perform(click());

        //проверить, что текст обновился
        onView(withId(R.id.kilometersValue))
                .check(matches(withText(TYPED_TEXT)));

        //проверить, что вывелся результат
        onView(withId(R.id.metrValue))
                .check(matches(withText("1.94")));

    }
}
