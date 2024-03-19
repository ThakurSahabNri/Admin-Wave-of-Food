package com.example.adminwaveoffood.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminwaveoffood.PendingOrderAdapter
import com.example.adminwaveoffood.R
import com.example.adminwaveoffood.databinding.ActivityPendingOrderBinding

class PendingOrderActivity : AppCompatActivity() {
    private val binding:ActivityPendingOrderBinding by lazy {
        ActivityPendingOrderBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customerName= mutableListOf<String>("Burger","Momo","Samosa","Burger","Momose","Samosa")
        val itemQuantity= mutableListOf<String>("4","3","8","4","3","8")
        val orderImage= mutableListOf<Int>(
            R.drawable.menu_photo2, R.drawable.menu_photo3, R.drawable.menu_photo4,
            R.drawable.menu_photo2, R.drawable.menu_photo3, R.drawable.menu_photo4
        )

        val adapter= PendingOrderAdapter(customerName,orderImage,itemQuantity, context = this)
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.adapter=adapter

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}