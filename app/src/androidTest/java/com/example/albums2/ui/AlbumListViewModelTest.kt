package com.example.albums2.ui

import androidx.test.espresso.Espresso.onView
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

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    // Test 1 :  Check that the total thumbnails is 15
    @Test
    fun testTotalCountIsFifthteen() {
        onView(withId(R.id.album_list)).check(withItemCount(15))
    }
}