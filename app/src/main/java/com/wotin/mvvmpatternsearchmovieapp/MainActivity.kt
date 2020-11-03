package com.wotin.mvvmpatternsearchmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wotin.mvvmpatternsearchmovieapp.adapter.MovieRecyclerViewAdapter
import com.wotin.mvvmpatternsearchmovieapp.api.MovieRepository
import com.wotin.mvvmpatternsearchmovieapp.api.MovieRetrofitBuilder
import com.wotin.mvvmpatternsearchmovieapp.databinding.ActivityMainBinding
import com.wotin.mvvmpatternsearchmovieapp.model.MovieCustomClass
import com.wotin.mvvmpatternsearchmovieapp.viewModel.MovieViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var movieViewModel : MovieViewModel
    lateinit var movieRecyclerViewAdapter : MovieRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity

        initRecyclerView()

        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        movieViewModel.movie.observe(this, Observer {movies ->
            Log.d("TAG", "movies are $movies")
            movieRecyclerViewAdapter.movieList = movies.items
            movieRecyclerViewAdapter.notifyDataSetChanged()
        })

    }

    private fun initRecyclerView() {
        movieRecyclerViewAdapter = MovieRecyclerViewAdapter(this)
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
}