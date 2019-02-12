package com.example.albums2.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlbumDao {
    @get:Query("SELECT * FROM album")
    val all: List<Album>

    @Insert
    fun insertAll(vararg users: Album)
}