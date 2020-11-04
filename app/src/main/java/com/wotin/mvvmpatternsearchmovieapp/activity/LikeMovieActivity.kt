package com.wotin.mvvmpatternsearchmovieapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wotin.mvvmpatternsearchmovieapp.R
import com.wotin.mvvmpatternsearchmovieapp.adapter.LikeMovieRecyclerViewAdapter
import com.wotin.mvvmpatternsearchmovieapp.databinding.ActivityLikeMovieBinding
import com.wotin.mvvmpatternsearchmovieapp.model.ItemCustomClass
import com.wotin.mvvmpatternsearchmovieapp.viewModel.LikeMoviesViewModel

class LikeMovieActivity : AppCompatActivity(), LikeMovieRecyclerViewAdapter.LikeMovieSetOnLongClickInterface {

    lateinit var mBinding : ActivityLikeMovieBinding
    lateinit var likeMovieRecyclerViewAdapter : LikeMovieRecyclerViewAdapter
    lateinit var likeMovieViewModel : LikeMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_like_movie)
        mBinding.activity = this@LikeMovieActivity
        likeMovieViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(LikeMoviesViewModel::class.java)
        likeMovieViewModel.getMovies().observe(this, Observer {
            likeMovieRecyclerViewAdapter.notifyDataSetChanged()
            Toast.makeText(applicationContext, "변경사항이 저장되었습니다.", Toast.LENGTH_SHORT).show()
        })

        initRecyclerView()
    }

    fun backButton() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun initRecyclerView() {
        likeMovieRecyclerViewAdapter = LikeMovieRecyclerViewAdapter(this, this, likeMovieViewModel.getMovies())
        mBinding.likeMoviesRecyclerview.apply {
            adapter = likeMovieRecyclerViewAdapter
            layoutManager = LinearLayoutManager(this@LikeMovieActivity)
            setHasFixedSize(true)
        }
    }

    override fun likeMovieOnLongClick(movie: ItemCustomClass?) {
        likeMovieViewModel.deleteMovies(movie!!)
    }

}