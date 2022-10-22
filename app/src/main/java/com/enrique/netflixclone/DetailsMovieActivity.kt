package com.enrique.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enrique.netflixclone.databinding.ActivityDetailsMovieBinding

class DetailsMovieActivity : AppCompatActivity() {
  private lateinit var binding: ActivityDetailsMovieBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetailsMovieBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }
}