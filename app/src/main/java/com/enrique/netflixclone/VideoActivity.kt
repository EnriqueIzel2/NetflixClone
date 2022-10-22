package com.enrique.netflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.enrique.netflixclone.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {
  private lateinit var binding: ActivityVideoBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityVideoBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar!!.hide()

    val videoUrl =
      Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-a97d0.appspot.com/o/THE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=1399b31f-8c98-472e-b35a-0000b7ce3b31")
    val videoTrailer = binding.videoTrailer
    videoTrailer.setMediaController(MediaController(this))
    videoTrailer.setVideoURI(videoUrl)
    videoTrailer.requestFocus()
    videoTrailer.start()
  }
}