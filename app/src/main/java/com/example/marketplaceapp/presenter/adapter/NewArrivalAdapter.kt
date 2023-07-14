package com.example.marketplaceapp.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplaceapp.R
import com.example.marketplaceapp.model.NewArrivalList

class NewArrivalAdapter(
    private val newArrivalList: MutableList<NewArrivalList>,
) : RecyclerView.Adapter<NewArrivalAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_arrival, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = newArrivalList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.shoesTitle.text = newArrivalList[position].shoesTitle
        holder.shoesPrice.text = newArrivalList[position].shoesPrice
        holder.imgShoes.setImageResource(newArrivalList[position].shoesImage)

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shoesTitle : TextView = itemView.findViewById(R.id.shoesTitle)
        val shoesPrice: TextView = itemView.findViewById(R.id.shoesPrice)
        val imgShoes : ImageView = itemView.findViewById(R.id.img_arrival)
    }

}