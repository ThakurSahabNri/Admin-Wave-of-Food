package com.example.adminwaveoffood

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adminwaveoffood.databinding.ActivityAddItemBinding
import com.example.adminwaveoffood.databinding.ActivityAllItemBinding
import com.example.adminwaveoffood.databinding.AllItemBinding

class AllItemAdapter(private val allItemName:MutableList<String>,private val allRestaurant:MutableList<String>,
                     private val allItemPrice:MutableList<String>,private val allItemImage:MutableList<Int>):RecyclerView.Adapter<AllItemAdapter.ViewHolder>() {
    private val quantityArr= IntArray(allItemName.size){1}
    inner class ViewHolder(private val binding: AllItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
          binding.itemName.text=allItemName[position]
            binding.restaurantName.text=allRestaurant[position]
            binding.itemPrice.text=allItemPrice[position]
            binding.itemImage.setImageResource(allItemImage[position])
            binding.tvNumber.text=quantityArr[position].toString()

            binding.tvMinus.setOnClickListener{
                decreaseNumber(position)
            }
            binding.tvPlush.setOnClickListener{
                increaseNumber(position)
            }
            binding.ivDelete.setOnClickListener{
                delete(position)
            }
        }

        private fun delete(position: Int) {
            allItemName.removeAt(position)
            allRestaurant.removeAt(position)
            allItemImage.removeAt(position)
            allItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,allItemName.size)
        }

        private fun increaseNumber(position: Int) {
            if(quantityArr[position].toInt()<10) {
                quantityArr[position]++
                binding.tvNumber.text=quantityArr[position].toString()
            }
        }

        private fun decreaseNumber(position: Int) {
            if(quantityArr[position].toInt()>1) {
                quantityArr[position]--
                binding.tvNumber.text=quantityArr[position].toString()
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemAdapter.ViewHolder {
        val binding= AllItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return allItemName.size
    }
    override fun onBindViewHolder(holder: AllItemAdapter.ViewHolder, position: Int) {

        holder.bind(position)
    }

}