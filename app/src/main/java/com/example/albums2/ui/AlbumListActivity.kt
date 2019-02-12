package com.example.albums2.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.albums2.R
import com.example.albums2.databinding.ActivityAlbumListBinding
import com.example.albums2.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class AlbumListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumListBinding
    private lateinit var viewModel: AlbumListViewModel
    private var errorSnackbar: Snackbar? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_album_list)
        binding.albumList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(AlbumListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
            if (it != null) showError(it) else hideError()
        })
        binding.viewModel = viewModel
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}