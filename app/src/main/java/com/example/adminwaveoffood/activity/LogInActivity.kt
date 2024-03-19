package com.example.adminwaveoffood.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.adminwaveoffood.databinding.ActivityLogInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference

class LogInActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var database: DatabaseReference
    lateinit var email:String
    lateinit var password:String

    private val binding: ActivityLogInBinding by lazy {
        ActivityLogInBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth=Firebase.auth


        binding.btnLogin.setOnClickListener{
            email=binding.etEmail.text.toString().toString()
            password=binding.etPassword.text.toString()
            if(email.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task->

                    if(task.isSuccessful){
                        Toast.makeText(this, "LogIn Success", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this, "LogIn failed", Toast.LENGTH_SHORT).show()
                        Log.d("LogIn","LogIn error:Failed",task.exception)
                    }

                }
            }
        }
        binding.btnFacebook.setOnClickListener{
            Toast.makeText(this, "Facebook button is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.btnGoogle.setOnClickListener{
            Toast.makeText(this, "Google button is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.tvDHA.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }
}