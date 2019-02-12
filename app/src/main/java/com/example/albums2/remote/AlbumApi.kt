package com.example.albums2.remote

import com.example.albums2.model.Album
import io.reactivex.Observable
import retrofit2.http.GET

interface AlbumApi {
        @GET("/albums")
            fun getAlbums(): Observable<List<Album>>
}