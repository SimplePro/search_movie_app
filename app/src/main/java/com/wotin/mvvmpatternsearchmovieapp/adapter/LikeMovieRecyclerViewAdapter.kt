package com.wotin.mvvmpatternsearchmovieapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.wotin.mvvmpatternsearchmovieapp.databinding.LikeMovieRecyclerviewItemBinding
import com.wotin.mvvmpatternsearchmovieapp.model.ItemCustomClass
import java.lang.Exception

class LikeMovieRecyclerViewAdapter(val context: Context, val likeMovieSetOnLongClickInterface : LikeMovieSetOnLongClickInterface, var likeMovieListParameter : LiveData<List<ItemCustomClass>>)
    : RecyclerView.Adapter<LikeMovieRecyclerViewAdapter.CustomViewHolder>() {

    var likeMovieList = likeMovieListParameter

    interface LikeMovieSetOnLongClickInterface {
        fun likeMovieOnLongClick(movie: ItemCustomClass?)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LikeMovieRecyclerViewAdapter.CustomViewHolder {
        val binding = LikeMovieRecyclerviewItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return CustomViewHolder(binding).apply {
            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(likeMovieList.value!![adapterPosition].link)
                parent.context.startActivity(intent)
            }
            itemView.setOnLongClickListener {
                likeMovieSetOnLongClickInterface.likeMovieOnLongClick(likeMovieList.value?.get(adapterPosition))
                return@setOnLongClickListener true
            }
        }
    }

    override fun getItemCount(): Int {
        return try {
            likeMovieList.value!!.size
        } catch (e : Exception) {
            0
        }

    }

    override fun onBindViewHolder(
        holder: LikeMovieRecyclerViewAdapter.CustomViewHolder,
        position: Int
    ) {
        holder.onBind(likeMovieList.value?.get(position))
    }

    class CustomViewHolder(val binding : LikeMovieRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : ItemCustomClass?) {
            binding.item = data
        }

    }
}