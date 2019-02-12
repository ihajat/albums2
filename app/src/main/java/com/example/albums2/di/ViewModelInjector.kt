package com.example.albums2.di

import com.example.albums2.ui.AlbumListViewModel
import com.example.albums2.ui.AlbumViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified AlbumListViewModel.
     * @param albumListViewModel AlbumListViewModel in which to inject the dependencies
     */
    fun inject(albumListViewModel: AlbumListViewModel)
    /**
     * Injects required dependencies into the specified AlbumViewModel.
     * @param albumViewModel AlbumViewModel in which to inject the dependencies
     */
    fun inject(albumViewModel: AlbumViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}