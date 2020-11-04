package com.wotin.mvvmpatternsearchmovieapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wotin.mvvmpatternsearchmovieapp.R
import com.wotin.mvvmpatternsearchmovieapp.adapter.MovieRecyclerViewAdapter
import com.wotin.mvvmpatternsearchmovieapp.databinding.ActivityMainBinding
import com.wotin.mvvmpatternsearchmovieapp.model.ItemCustomClass
import com.wotin.mvvmpatternsearchmovieapp.viewModel.LikeMoviesViewModel
import com.wotin.mvvmpatternsearchmovieapp.viewModel.MovieViewModel

class MainActivity : AppCompatActivity(), MovieRecyclerViewAdapter.MovieSetOnLongClickInterface {

    private lateinit var binding : ActivityMainBinding
    lateinit var movieViewModel : MovieViewModel
    lateinit var movieRecyclerViewAdapter : MovieRecyclerViewAdapter
    lateinit var likeMoviesViewModel : LikeMoviesViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.activity = this@MainActivity

        initRecyclerView()

        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        likeMoviesViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(LikeMoviesViewModel::class.java)

        movieViewModel.movie.observe(this, Observer {movies ->
            Log.d("TAG", "movies are $movies")
            movieRecyclerViewAdapter.movieList = movies.items
            movieRecyclerViewAdapter.notifyDataSetChanged()
        })
        
        likeMoviesViewModel.getMovies().observe(this, Observer {
            Toast.makeText(applicationContext, "변경사항이 저장되었습니다.", Toast.LENGTH_SHORT).show()
        })

    }

    fun showLikeMovies() {
        startActivity(Intent(this, LikeMovieActivity::class.java))
        finish()
    }

    private fun initRecyclerView() {
        movieRecyclerViewAdapter = MovieRecyclerViewAdapter(this, this)
        binding.movieRecyclerview.apply {
            adapter = movieRecyclerViewAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }

    fun clickedSearchButton() {
        Log.d("TAG", "searchButton clicked")
        movieViewModel.setSearchTitle(binding.searchEdittext.text.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        movieViewModel.cancelJobs()
    }

    override fun movieOnLongClick(movie: ItemCustomClass) {
        likeMoviesViewModel.insertMovies(movie)
    }
}