package com.example.marketplaceapp.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplaceapp.R
import com.example.marketplaceapp.model.BrandList

class BrandAdapter(
    private val brandList: MutableList<BrandList>
) : RecyclerView.Adapter<BrandAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_brand, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = brandList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imgBrand.setImageResource(brandList[position].imageBrand)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgBrand : ImageView = itemView.findViewById(R.id.img_brand)
    }

}