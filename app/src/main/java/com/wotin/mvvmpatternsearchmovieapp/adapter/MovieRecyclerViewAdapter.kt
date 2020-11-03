package com.wotin.mvvmpatternsearchmovieapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wotin.mvvmpatternsearchmovieapp.databinding.MovieRecyclerviewItemBinding
import com.wotin.mvvmpatternsearchmovieapp.model.ItemCustomClass
import com.wotin.mvvmpatternsearchmovieapp.model.MovieCustomClass

class MovieRecyclerViewAdapter(val context : Context) : RecyclerView.Adapter<MovieRecyclerViewAdapter.CustomViewHolder>() {
    var movieList : ArrayList<ItemCustomClass> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = MovieRecyclerviewItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return CustomViewHolder(binding).apply {
            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(movieList[adapterPosition].link)
                parent.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.onBind(movieList[position])
    }

    class CustomViewHolder(val binding : MovieRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : ItemCustomClass) {
            binding.item = data
        }

    }
}