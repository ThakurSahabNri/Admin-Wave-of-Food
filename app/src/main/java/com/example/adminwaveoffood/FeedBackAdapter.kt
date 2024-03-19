package com.example.adminwaveoffood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminwaveoffood.databinding.DeliveryItemBinding
import com.example.adminwaveoffood.databinding.FeedbackItemBinding

class FeedBackAdapter(private val customerName:MutableList<String>,private val feedback:MutableList<String>):
    RecyclerView.Adapter<FeedBackAdapter.ViewHolder>()  {
    inner class ViewHolder(private val binding: FeedbackItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.customerName.text=customerName[position]
            binding.feedback.text=feedback[position]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedBackAdapter.ViewHolder {
        val binding=FeedbackItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return customerName.size
    }

    override fun onBindViewHolder(holder: FeedBackAdapter.ViewHolder, position: Int) {
        holder.bind(position)
    }
}