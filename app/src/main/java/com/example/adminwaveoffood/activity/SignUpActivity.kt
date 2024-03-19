package com.example.adminwaveoffood.activity

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.adminwaveoffood.activity.model.UserModel
import com.example.adminwaveoffood.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.database

class SignUpActivity : AppCompatActivity() {
    lateinit var auth:FirebaseAuth
    lateinit var database:DatabaseReference
    lateinit var userName:String
    lateinit var nameRestaurant:String
    lateinit var email:String
    lateinit var password:String


    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val locationList= arrayListOf("Mathura","Agra","Aligarh","Bharatpur","Jaipur")
        val adapter= ArrayAdapter(this, R.layout.simple_list_item_1,locationList)
        val autoCompleteTextView=binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)

        //initializing firebase authentication
        auth=Firebase.auth
        //initializing firebase
        database=Firebase.database.reference



        binding.btnSignUp.setOnClickListener{
            userName=binding.etName.text.toString().trim()
            nameRestaurant=binding.etNameRestaurant.text.toString().trim()
            email=binding.etEmail.text.toString().trim()
            password=binding.etPassword.text.toString().trim()

            if(userName.isBlank() || nameRestaurant.isBlank() || email.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show()
            }else{
                createUser(email,password)
                saveUserData()
            }
        }
        binding.btnFacebook.setOnClickListener{
            Toast.makeText(this, "Facebook button is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.btnGoogle.setOnClickListener{
            Toast.makeText(this, "Google button is clicked", Toast.LENGTH_SHORT).show()
        }
        binding.tvAHA.setOnClickListener{
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }


    }

    private fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener() {task->
            if(task.isSuccessful){
                Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()
                saveUserData()
                startActivity(Intent(this, LogInActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_SHORT).show()
               Log.d("Account","createAccount:Failure",task.exception)
            }
        }
    }

    //database creation
    private fun saveUserData() {
        userName=binding.etName.text.toString().trim()
        nameRestaurant=binding.etNameRestaurant.text.toString().trim()
        email=binding.etEmail.text.toString().trim()
        password=binding.etPassword.text.toString().trim()

        val user=UserModel(userName,nameRestaurant,email,password)
        val userId=FirebaseAuth.getInstance().currentUser!!.uid
        //firebase database creation
        database.child("User").child(userId).setValue(user)
    }
}