package com.example.marketplaceapp.presenter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marketplaceapp.R
import com.example.marketplaceapp.databinding.FragmentHomeScreenBinding
import com.example.marketplaceapp.model.BrandList
import com.example.marketplaceapp.model.NewArrivalList
import com.example.marketplaceapp.presenter.adapter.BrandAdapter
import com.example.marketplaceapp.presenter.adapter.NewArrivalAdapter


class HomeScreen : Fragment() {

    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)

        val recyclerView = binding.recyclerViewBrand
        val brandList: MutableList<BrandList> = mutableListOf()
        val adapterBrand = BrandAdapter(brandList)

        val rvNewArrival = binding.recyclerviewNewArrival
        val newArrivalList: MutableList<NewArrivalList> = mutableListOf()
        val adapterNewArrival = NewArrivalAdapter(newArrivalList)

        binding.recyclerViewBrand.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapterBrand

        binding.recyclerviewNewArrival.layoutManager = GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL, false)
        rvNewArrival.adapter = adapterNewArrival

        val imagem1 = BrandList(
            R.drawable.nike
        )

        val imagem2 = BrandList(
            R.drawable.adidas
        )
        val imagem3 = BrandList(
            R.drawable.puma
        )
        val imagem4 = BrandList(
            R.drawable.mizuno
        )
        val imagem5 = BrandList(
            R.drawable.reebok
        )

        brandList.add(imagem1)
        brandList.add(imagem2)
        brandList.add(imagem3)
        brandList.add(imagem4)
        brandList.add(imagem5)


        val shoes1 = NewArrivalList(
            "Nike Pegasus",
            "$83.79",
            R.drawable.pegasusnike
        )

        val shoes2 = NewArrivalList(
            "Nike Pegasus",
            "$83.79",
            R.drawable.pegasusnike
        )

        val shoes3 = NewArrivalList(
            "Nike Pegasus",
            "$83.79",
            R.drawable.pegasusnike
        )

        val shoes4 = NewArrivalList(
            "Nike Pegasus",
            "$83.79",
            R.drawable.pegasusnike
        )

        newArrivalList.add(shoes1)
        newArrivalList.add(shoes2)
        newArrivalList.add(shoes3)
        newArrivalList.add(shoes4)


        return binding.root
    }

}