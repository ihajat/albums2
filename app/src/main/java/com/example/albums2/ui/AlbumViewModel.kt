package com.example.albums2.ui

import androidx.lifecycle.MutableLiveData
import com.example.albums2.viewmodel.BaseViewModel
import com.example.albums2.model.Album

class AlbumViewModel : BaseViewModel() {

    private val albumTitle = MutableLiveData<String>()

    fun bind(album: Album) {
        albumTitle.value = album.title
    }

    fun getAlbumTitle(): MutableLiveData<String> {
        return albumTitle
    }
}