package com.enrique.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.enrique.netflixclone.databinding.ActivityListMoviesBinding
import com.google.firebase.auth.FirebaseAuth

class ListMoviesActivity : AppCompatActivity() {
  private lateinit var binding: ActivityListMoviesBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityListMoviesBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    val inflate = menuInflater
    inflate.inflate(R.menu.main_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.menu_logout -> {
        FirebaseAuth.getInstance().signOut()
        goToHomeScreen()
      }
    }

    return super.onOptionsItemSelected(item)
  }

  private fun goToHomeScreen() {
    val intent = Intent(this, LoginActivity::class.java)
    startActivity(intent)
    finish()
  }
}