package com.example.adminwaveoffood.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adminwaveoffood.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding :ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvPendingOrder.setOnClickListener{
            val intent= Intent(this@MainActivity, PendingOrderActivity::class.java)
            startActivity(intent)
        }

        binding.addItem.setOnClickListener{
         val intent= Intent(this@MainActivity, AddItemActivity::class.java)
            startActivity(intent)
        }
        binding.allMenu.setOnClickListener{
            val intent= Intent(this@MainActivity, AllItemActivity::class.java)
            startActivity(intent)
        }
        binding.outForDelivery.setOnClickListener{
            val intent= Intent(this@MainActivity, DeliveryActivity::class.java)
            startActivity(intent)
        }
        binding.feedback.setOnClickListener{
            val intent= Intent(this@MainActivity, FeedBackActivity::class.java)
            startActivity(intent)
        }
        binding.profile.setOnClickListener{
            val intent= Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.moneyOnHold.setOnClickListener{

        }
        binding.createNewUser.setOnClickListener{
            val intent= Intent(this@MainActivity, CreateUserActivity::class.java)
            startActivity(intent)
        }
        binding.logOut.setOnClickListener{

        }

    }
}