package com.example.marketplaceapp.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplaceapp.R

class HeaderTitleAdapter(private val title: String): RecyclerView.Adapter<HeaderTitleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.header_title_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = title
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.textViewTitle)
    }
}