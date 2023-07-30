package com.example.marketplaceapp.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marketplaceapp.R
import com.example.marketplaceapp.databinding.ListArrivalBinding
import com.example.marketplaceapp.databinding.ListBrandBinding
import com.example.marketplaceapp.model.BrandList
import com.example.marketplaceapp.model.NewArrivalList

class BrandAdapter(
) : RecyclerView.Adapter<BrandAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListBrandBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = brandList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imgBrand.load(brandList[position].imageBrand){
            crossfade(true)
        }
    }

    class MyViewHolder(val binding: ListBrandBinding): RecyclerView.ViewHolder(binding.root){
        val imgBrand : ImageView = itemView.findViewById(R.id.img_brand)
    }

    private val differCallBack = object : DiffUtil.ItemCallback<BrandList>(){
        override fun areItemsTheSame(oldItem: BrandList, newItem: BrandList): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BrandList, newItem: BrandList): Boolean {
            return oldItem.imageBrand == newItem.imageBrand
        }
    }


    private val differ = AsyncListDiffer(this, differCallBack)
    var brandList : List<BrandList>
        get() = differ.currentList
        set(value) = differ.submitList(value)


}