package com.enrique.netflixclone

import adapter.MoviesAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.enrique.netflixclone.databinding.ActivityDetailsMovieBinding
import com.squareup.picasso.Picasso
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

    val trailerCover =
      "https://firebasestorage.googleapis.com/v0/b/netflix-clone-a97d0.appspot.com/o/video.jpg?alt=media&token=44cacbce-d505-4048-a234-3b71d5c79e2f"

    Picasso.get().load(trailerCover).fit().into(binding.detailsMovieCover)

    binding.detailsMoviePlayVideo.setOnClickListener {
      val intent = Intent(this, VideoActivity::class.java)
      startActivity(intent)
    }
  }

  private fun manageToolbal() {
    val toolbarDetails = binding.toolbarDetails
    toolbarDetails.setNavigationIcon(getDrawable(R.drawable.ic_arrow_back_24))
    toolbarDetails.setNavigationOnClickListener {
      finish()
    }
  }
}