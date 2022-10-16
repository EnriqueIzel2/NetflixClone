package com.enrique.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.enrique.netflixclone.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
  private lateinit var binding: ActivityLoginBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityLoginBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar!!.hide()

    binding.txtLinkToRegister.setOnClickListener {
      val intent = Intent(this, RegisterActivity::class.java)
      startActivity(intent)
    }

    binding.btnLogin.setOnClickListener {
      val email = binding.editTextEmail.text.toString()
      val password = binding.editTextPassword.text.toString()
      val loginErrorMessage = binding.txtErrorMessage

      if (email.isEmpty() || password.isEmpty()) {
        loginErrorMessage.setText("Preencha todos os campos")
      } else {
        authenticateUser()
      }
    }
  }

  private fun authenticateUser() {
    val email = binding.editTextEmail.text.toString()
    val password = binding.editTextPassword.text.toString()
    val loginErrorMessage = binding.txtErrorMessage

    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
      if (it.isSuccessful) {
        Toast.makeText(this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show()
        goToListMovies()
      }
    }
  }

  private fun goToListMovies() {
    val intent = Intent(this, ListMoviesActivity::class.java)
    startActivity(intent)
    finish()
  }
}