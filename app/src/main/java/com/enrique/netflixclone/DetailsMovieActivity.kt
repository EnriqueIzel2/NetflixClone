package com.enrique.netflixclone

import adapter.MoviesAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.enrique.netflixclone.databinding.ActivityDetailsMovieBinding
import model.addMovies

class DetailsMovieActivity : AppCompatActivity() {
  private lateinit var binding: ActivityDetailsMovieBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetailsMovieBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar!!.hide()
    manageToolbal()

    val recyclerMoreMovies = binding.detailsMovieMoreMovies
    recyclerMoreMovies.adapter = MoviesAdapter(addMovies())
    recyclerMoreMovies.layoutManager = GridLayoutManager(applicationContext, 3)
  }

  private fun manageToolbal() {
    val toolbarDetails = binding.toolbarDetails
    toolbarDetails.setNavigationIcon(getDrawable(R.drawable.ic_arrow_back_24))
    toolbarDetails.setNavigationOnClickListener {
      finish()
    }
  }
}