package com.example.adminwaveoffood

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminwaveoffood.databinding.DeliveryItemBinding

class DeliveryAdapter(private val customerName:MutableList<String>,private val paymentStatus:MutableList<String>):RecyclerView.Adapter<DeliveryAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding:DeliveryItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.customerName.text=customerName[position]
            binding.paymentStatus.text=paymentStatus[position]
            if (paymentStatus[position] == "Received"){
                binding.paymentStatus.setTextColor(Color.GREEN)
                binding.cvCircle.setBackgroundColor(Color.GREEN)
            }else if (paymentStatus[position] == "Not Received"){
                binding.paymentStatus.setTextColor(Color.RED)
                binding.cvCircle.setBackgroundColor(Color.RED)
            }else{
                binding.paymentStatus.setTextColor(Color.GRAY)
                binding.cvCircle.setCardBackgroundColor(Color.GRAY)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryAdapter.ViewHolder {
      val binding=DeliveryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeliveryAdapter.ViewHolder, position: Int) {
      holder.bind(position)
    }

    override fun getItemCount(): Int {
        return customerName.size
    }
}