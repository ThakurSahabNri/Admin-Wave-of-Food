package com.example.adminwaveoffood.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminwaveoffood.AllItemAdapter
import com.example.adminwaveoffood.R
import com.example.adminwaveoffood.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {
    private val binding:ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val itemName= mutableListOf<String>("Burger","Momo","Samosa","Burger","Momose","Samosa")
        val restaurantName= mutableListOf<String>("Burger Singh","Momo Mami","Samosa Wala",
            "Burger Singh","Momo Mami","Samosa Wala")
        val itemPrice= mutableListOf<String>("$4","$3","$8","$4","$3","$8")
        val itemImage= mutableListOf<Int>(
            R.drawable.menu_photo2, R.drawable.menu_photo3, R.drawable.menu_photo4,
            R.drawable.menu_photo2, R.drawable.menu_photo3, R.drawable.menu_photo4
        )

        val adapter= AllItemAdapter(itemName,restaurantName,itemPrice,itemImage)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=adapter

        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}