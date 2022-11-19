package com.app.android.techassessment.ui.articles

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import com.app.android.techassessment.R
import com.app.android.techassessment.ui.MainActivity
import com.app.android.techassessment.utils.CountingIdlingResourceSingleton
import org.hamcrest.Matchers.containsString
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArticlesFragmentTest {

    private val SCROLL_POSITION = 1

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(CountingIdlingResourceSingleton.countingIdlingResource)
    }

    @Test
    fun recyclerView_itemClick() {
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    SCROLL_POSITION, click()
                )
            )
    }

    @Test
    fun recyclerview_matchItemClick(){
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>
                (hasDescendant(withText(containsString("ban"))),
                click()))
    }

    @Test
    fun recyclerview_itemNotExist(){
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                hasDescendant(withText("not in the list"))
            ))
    }

    @Test
    fun recyclerview_itemLast(){
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.scrollToLastPosition<RecyclerView.ViewHolder>())
    }


    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(CountingIdlingResourceSingleton.countingIdlingResource)
    }


}
