package com.example.adminwaveoffood.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminwaveoffood.FeedBackAdapter
import com.example.adminwaveoffood.databinding.ActivityFeedBackBinding

class FeedBackActivity : AppCompatActivity() {
    private val binding : ActivityFeedBackBinding by lazy {
        ActivityFeedBackBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customerName= mutableListOf<String>("Manoj","Lokesh","Rampal","Manoj","Lokesh","Rampal")
        val feedback= mutableListOf<String>("Lorem ipsum dolor sit amet, consectetur adipiscing \n" +
                "elit, sed do eiusmod tempor incididunt ut labore et \n" +
                "dolore magna aliqua. Ut enim ad minim veniam, ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing \n" +
                    "elit, sed do eiusmod tempor incididunt ut labore et \n" +
                    "dolore magna aliqua. Ut enim ad minim veniam, ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing \n" +
                    "elit, sed do eiusmod tempor incididunt ut labore et \n" +
                    "dolore magna aliqua. Ut enim ad minim veniam, ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing \n" +
                    "elit, sed do eiusmod tempor incididunt ut labore et \n" +
                    "dolore magna aliqua. Ut enim ad minim veniam, ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing \n" +
                    "elit, sed do eiusmod tempor incididunt ut labore et \n" +
                    "dolore magna aliqua. Ut enim ad minim veniam, ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing \n" +
                    "elit, sed do eiusmod tempor incididunt ut labore et \n" +
                    "dolore magna aliqua. Ut enim ad minim veniam, ")

        val adapter= FeedBackAdapter(customerName,feedback)
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.adapter=adapter

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}