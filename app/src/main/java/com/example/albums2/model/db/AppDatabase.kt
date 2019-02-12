package com.example.albums2.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.albums2.model.Album
import com.example.albums2.model.AlbumDao

@Database(entities = [Album::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}