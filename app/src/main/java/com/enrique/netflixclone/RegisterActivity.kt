package com.enrique.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enrique.netflixclone.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
  private lateinit var binding: ActivityRegisterBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRegisterBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar!!.hide()
    setToolBar()

    binding.btnRegister.setOnClickListener {
      val email = binding.editRegisterEmail.text.toString()
      val password = binding.editRegisterPassword.text.toString()
    }
  }

  private fun setToolBar() {
    val toolbar = binding.toolbarRegister
    toolbar.setBackgroundColor(getColor(R.color.white))
    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))
  }
}