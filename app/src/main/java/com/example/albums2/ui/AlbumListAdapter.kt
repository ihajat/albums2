package com.example.albums2.ui

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.albums2.R
import com.example.albums2.databinding.ItemAlbumBinding
import com.example.albums2.handlers.EventHandler
import com.example.albums2.model.Album

class AlbumListAdapter : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {
    private lateinit var albumList: List<Album>
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding: com.example.albums2.databinding.ItemAlbumBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_album, parent, false)
        return ViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(albumList[position])
    }

    override fun getItemCount(): Int {
        return if (::albumList.isInitialized) albumList.size else 0
    }

    fun getItemAtPosition(position: Int): Album {
        return this.albumList.get(position)
    }

    fun setAlbumList(albumList: List<Album>) {
        this.albumList = albumList
    }

    fun updatePostList(albumList: List<Album>) {
        setAlbumList(albumList)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemAlbumBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = AlbumViewModel()
        fun bind(album: Album) {
            viewModel.bind(album)
            binding.viewModel = viewModel
            binding.handler = object : EventHandler {
                override fun onClick() {

                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("uri", binding.albumTitle.text.toString())
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                }
            }
        }
    }
}