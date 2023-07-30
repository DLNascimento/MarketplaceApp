package com.example.marketplaceapp.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplaceapp.R
import com.example.marketplaceapp.model.BrandList

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.MyViewHolder>() {

    val brandAdapter = BrandAdapter()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_recyclerview, parent, false)
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.rv_horizontal)
        recyclerView.adapter = brandAdapter
        recyclerView.layoutManager = LinearLayoutManager(parent.context, LinearLayoutManager.HORIZONTAL, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setBrandList(brandList: List<BrandList>){
        brandAdapter.brandList = brandList
    }

}