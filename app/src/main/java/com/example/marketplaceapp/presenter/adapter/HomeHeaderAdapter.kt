package com.example.marketplaceapp.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marketplaceapp.R
import com.example.marketplaceapp.databinding.CardProductBinding
import com.example.marketplaceapp.presenter.view.CardProduct


class HomeHeaderAdapter : RecyclerView.Adapter<HomeHeaderAdapter.MyViewHolder>() {

    var title : String? = null
    var description : String? = null
    var buttonTitle : String? = null
    var imageUrl : String? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HomeHeaderAdapter.MyViewHolder {
        return MyViewHolder(CardProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeHeaderAdapter.MyViewHolder, position: Int) {
        holder.binding.cardProduct.findViewById<TextView>(R.id.cardProductTitle).text = title
        holder.binding.cardProduct.findViewById<TextView>(R.id.cardProductDescription).text = description
        holder.binding.cardProduct.findViewById<Button>(R.id.cardProductButton).text = buttonTitle
        holder.binding.cardProduct.findViewById<ImageView>(R.id.imageView).load(imageUrl){
            crossfade(true)
        }
    }

    override fun getItemCount(): Int = 1


    inner class MyViewHolder(val binding: CardProductBinding): RecyclerView.ViewHolder(binding.root)

}