package com.example.marketplaceapp.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marketplaceapp.databinding.ListArrivalBinding
import com.example.marketplaceapp.model.NewArrivalList

class NewArrivalAdapter : RecyclerView.Adapter<NewArrivalAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListArrivalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = newArrival.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = newArrival[position]
        holder.binding.apply {
            shoesTitle.text = item.shoesTitle
            shoesPrice.text = item.shoesPrice

            imgArrival.load(item.shoesImage){
                crossfade(true)
            }
        }
    }

    inner class MyViewHolder(val binding: ListArrivalBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<NewArrivalList>(){
        override fun areItemsTheSame(oldItem: NewArrivalList, newItem: NewArrivalList): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NewArrivalList, newItem: NewArrivalList): Boolean {
            return oldItem.shoesTitle == newItem.shoesTitle && oldItem.shoesPrice == newItem.shoesPrice
                    && oldItem.shoesImage == newItem.shoesImage
        }
    }


    private val differ = AsyncListDiffer(this, differCallBack)
    var newArrival : List<NewArrivalList>
        get() = differ.currentList
        set(value) = differ.submitList(value)

}