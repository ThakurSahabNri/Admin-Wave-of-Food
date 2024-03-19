package com.example.adminwaveoffood

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.adminwaveoffood.databinding.PendingItemBinding

class PendingOrderAdapter(private val customerName:MutableList<String>,private val orderImage:MutableList<Int>,private val itemQuantity:MutableList<String>,private val  context:Context):RecyclerView.Adapter<PendingOrderAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding:PendingItemBinding):RecyclerView.ViewHolder(binding.root) {
     private var isAccepted=false
       fun bind(position: Int){
           binding.customerName.text=customerName[position]
           binding.tvQuantity.text=itemQuantity[position]
           binding.itemImage.setImageResource(orderImage[position])

           binding.btnAccept.apply{
               if (!isAccepted){
                   text="Accept"
               }else{
                   text="Dispatch"
               }
               setOnClickListener {
                   if (!isAccepted){
                       text="Dispatch"
                       isAccepted=true
                       showToast("Order is Accepted")
                   }else{
                       customerName.removeAt(adapterPosition)
                       orderImage.removeAt(adapterPosition)
                       itemQuantity.removeAt(adapterPosition)

                       notifyItemRemoved(adapterPosition)
                       showToast("Order is Dispatch")
                   }
               }
           }
       }

        private fun showToast(message:String){
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=PendingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return customerName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}