package com.example.albums2.ui

import com.example.albums2.model.Album
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AlbumListAdapterTest {

    private val test_album_userId = 1
    private val test_album_id = 1
    private val test_album_title = "test"

    lateinit var adapter: AlbumListAdapter

    @Before
    fun setUp() {
        adapter = AlbumListAdapter()
    }

    @After
    fun tearDown() {
    }

    // Test 1, test the getItemCount inside the adapter returns correctly
    @Test
    fun testGetItemCount() {
        val album = Album(test_album_userId, test_album_id, test_album_title)
        val arr = arrayOf(album, album, album)
        val l1 = arr.asList()
        adapter.setAlbumList(l1)
        assertEquals(adapter.getItemCount(), 3)
    }

    // Test 2, test the getItemAtPosition inside the adapter returns correctly
    @Test
    fun getItemAtPosition() {
        val album = Album(test_album_userId, test_album_id, test_album_title)
        val arr = arrayOf(album, album, album)
        val l1 = arr.asList()
        adapter.setAlbumList(l1)
        assertEquals(adapter.getItemAtPosition(0).title, test_album_title)
    }
}