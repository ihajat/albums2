package com.example.albums2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.albums2.di.DaggerViewModelInjector
import com.example.albums2.di.NetworkModule
import com.example.albums2.di.ViewModelInjector
import com.example.albums2.ui.AlbumListViewModel
import com.example.albums2.ui.AlbumViewModel

/**
 * ...
 * @property injector The injector used to inject required dependencies
 * ...
 */
abstract class BaseViewModel : ViewModel() {
    /**
     * The inhector used to inject required dependencies
     */
    protected val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is AlbumListViewModel -> injector.inject(this)
            is AlbumViewModel -> injector.inject(this)
        }
    }
}