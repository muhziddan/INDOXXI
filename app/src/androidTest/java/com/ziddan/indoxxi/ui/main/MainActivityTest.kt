package com.ziddan.indoxxi.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.ziddan.indoxxi.R
import com.ziddan.indoxxi.utils.DataDummy
import com.ziddan.indoxxi.utils.EspressoIdlingResources
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyFilm = DataDummy.generateDummyShows()
    private val dummyTv = DataDummy.generateDummyTv()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadFilm() {
        onView(withId(R.id.rv_film))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyFilm.size
            )
        )
    }

    @Test
    fun loadTv() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvshow))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun loadDetailFilm() {
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_title))
            .check(matches(withText(dummyFilm[0].title)))
        onView(withId(R.id.tv_director))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_director))
            .check(matches(withText("Director: ${dummyFilm[0].director}")))
    }

    @Test
    fun loadDetailTv() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title2))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_title2))
            .check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.tv_writer2))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_writer2))
            .check(matches(withText("Writers: ${dummyTv[0].writer}")))
    }

    @Test
    fun loadFavoriteFilm() {
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.menu_favorite)).perform(click())
        onView(withId(R.id.rv_fav_film)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_film)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun loadFavoriteTv() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.menu_favorite)).perform(click())
        onView(allOf(withId(R.id.rv_fav_film), isDisplayed())).perform(ViewActions.swipeLeft())
        onView(withId(R.id.rv_fav_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(isRoot()).perform(pressBack())
    }
}