package com.enrique.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.enrique.netflixclone.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

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
      val regErrorMessage = binding.registerErroMessage

      if (email.isEmpty() || password.isEmpty()) {
        regErrorMessage.setText("Preencha todos os campos")
      } else {
        registerUser()
      }
    }
  }

  private fun registerUser() {
    val email = binding.editRegisterEmail.text.toString()
    val password = binding.editRegisterPassword.text.toString()
    val infoMessage = binding.registerErroMessage

    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
      .addOnCompleteListener {
        if (it.isSuccessful) {
          Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show()
          binding.editRegisterEmail.setText("")
          binding.editRegisterPassword.setText("")
          binding.registerErroMessage.setText("")
        }
      }.addOnFailureListener {
        var error = it

        when (error) {
          is FirebaseAuthWeakPasswordException -> infoMessage.setText("Senha deve ter no mínimo 6 caracteres")
          is FirebaseAuthUserCollisionException -> infoMessage.setText("Email já cadastrado")
        }

        infoMessage.setText("Erro ao cadastrar usuário")
      }
  }

  private fun setToolBar() {
    val toolbar = binding.toolbarRegister
    toolbar.setBackgroundColor(getColor(R.color.white))
    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))
  }
}