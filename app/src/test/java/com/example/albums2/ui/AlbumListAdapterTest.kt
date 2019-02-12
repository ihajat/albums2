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

    lateinit var adapter: AlbumListAdapter

    @Before
    fun setUp() {
        adapter = AlbumListAdapter()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testGetItemCount() {
        val album = Album(1, 1, "test")
        val arr = arrayOf(album, album, album)
        val l1 = arr.asList()
        adapter.setAlbumList(l1)
        assertEquals(adapter.getItemCount(), 3)
    }

    @Test
    fun getItemAtPosition() {
        val album = Album(1, 1, "test")
        val arr = arrayOf(album, album, album)
        val l1 = arr.asList()
        adapter.setAlbumList(l1)
        assertEquals(adapter.getItemAtPosition(0).title, "test")
    }
}