package com.example.albums2.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.albums2.ui.RecyclerViewItemCountAssertion.withItemCount
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.albums2.R

@RunWith(AndroidJUnit4::class)
class AlbumListViewModelTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(AlbumListActivity::class.java)

    fun isGone() = getViewAssertion(ViewMatchers.Visibility.GONE)

    fun isVisible() = getViewAssertion(ViewMatchers.Visibility.VISIBLE)

    fun isInvisible() = getViewAssertion(ViewMatchers.Visibility.INVISIBLE)

    private fun getViewAssertion(visibility: ViewMatchers.Visibility): ViewAssertion? {
        return ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility))
    }

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    // Test 1 :  Check that the total of albums is 100
    @Test
    fun testTotalCountIs100() {
        onView(withId(R.id.album_list)).check(withItemCount(100))
    }

    // Test 2 :  Check that on click, of album, inside the recyclerview, that
    //          a second screen must load to show the title
    @Test
    fun testOnClickImageIsDisplayed() {
        onView(withId(R.id.album_list)).perform(click())
        onView(withId(R.id.details)).check(isVisible())
    }
}