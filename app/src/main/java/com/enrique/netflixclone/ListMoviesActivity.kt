package com.enrique.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enrique.netflixclone.databinding.ActivityListMoviesBinding

class ListMoviesActivity : AppCompatActivity() {
  private lateinit var binding: ActivityListMoviesBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityListMoviesBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }
}