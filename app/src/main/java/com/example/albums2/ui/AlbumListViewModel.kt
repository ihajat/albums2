package com.example.albums2.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.albums2.model.Album
import com.example.albums2.remote.AlbumApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.example.albums2.R
import com.example.albums2.viewmodel.BaseViewModel
import com.example.albums2.model.AlbumDao
import javax.inject.Inject

class AlbumListViewModel(private val albumDao: AlbumDao) : BaseViewModel() {
    @Inject
    lateinit var albumApi: AlbumApi
    val albumListAdapter = AlbumListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadAlbums() }

    private lateinit var subscription: Disposable

    init {
        loadAlbums()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadAlbums() {
        subscription = Observable.fromCallable { albumDao.all }
            .concatMap {
                    dbPostList ->
                if (dbPostList.isEmpty())
                    albumApi.getAlbums().concatMap {
                            apiPostList -> albumDao.insertAll(*apiPostList.toTypedArray())
                        Observable.just(apiPostList)
                    }
                else
                    Observable.just(dbPostList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(albumList: List<Album>) {
        albumListAdapter.updatePostList(albumList)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.album_error
    }
}