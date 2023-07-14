package com.example.marketplaceapp.presenter.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marketplaceapp.R
import com.example.marketplaceapp.databinding.FragmentHomeScreenBinding
import com.example.marketplaceapp.model.BrandList
import com.example.marketplaceapp.model.NewArrivalList
import com.example.marketplaceapp.presenter.adapter.BrandAdapter
import com.example.marketplaceapp.presenter.adapter.HeaderTitleAdapter
import com.example.marketplaceapp.presenter.adapter.HomeHeaderAdapter
import com.example.marketplaceapp.presenter.adapter.HorizontalAdapter
import com.example.marketplaceapp.presenter.adapter.NewArrivalAdapter


class HomeScreen : Fragment() {

    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        val homeAdapter = HomeHeaderAdapter()
        val horizontalAdapter = HorizontalAdapter()
        val newArrivalAdapter = NewArrivalAdapter(NewArrivalList.mock())
        val concatAdapter = ConcatAdapter(homeAdapter, HeaderTitleAdapter("Brand"), horizontalAdapter, HeaderTitleAdapter("New Arrival"), newArrivalAdapter)
        binding.rvHomeScreen.adapter = concatAdapter

        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvHomeScreen.layoutManager = layoutManager

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (concatAdapter.getItemViewType(position)){
                    0, 1, 2, 3 -> 2
                    else ->  1
                }
            }
        }

        return binding.root
    }
}
