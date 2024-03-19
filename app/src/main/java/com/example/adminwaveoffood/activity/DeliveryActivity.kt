package com.example.adminwaveoffood.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminwaveoffood.DeliveryAdapter
import com.example.adminwaveoffood.databinding.ActivityDeliveryBinding

class DeliveryActivity : AppCompatActivity() {
    private val binding:ActivityDeliveryBinding by lazy {
        ActivityDeliveryBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customerName= mutableListOf<String>("Manoj","Lokesh","Rampal","Manoj","Lokesh","Rampal")
        val paymentStatus= mutableListOf<String>("Received","Not Received","Pending","Received","Not Received","Pending")

        val adapter= DeliveryAdapter(customerName,paymentStatus)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=adapter

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}