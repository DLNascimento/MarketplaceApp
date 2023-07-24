package com.example.marketplaceapp.presenter.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marketplaceapp.databinding.FragmentHomeScreenBinding
import com.example.marketplaceapp.helper.StateView
import com.example.marketplaceapp.model.NewArrivalList
import com.example.marketplaceapp.presenter.adapter.HeaderTitleAdapter
import com.example.marketplaceapp.presenter.adapter.HomeHeaderAdapter
import com.example.marketplaceapp.presenter.adapter.HorizontalAdapter
import com.example.marketplaceapp.presenter.adapter.NewArrivalAdapter
import com.example.marketplaceapp.presenter.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeScreen : Fragment() {

    private val homeAdapter = HomeHeaderAdapter()
    private val horizontalAdapter = HorizontalAdapter()
    private val newArrivalAdapter = NewArrivalAdapter(NewArrivalList.mock())
    private var concatAdapter = ConcatAdapter(homeAdapter, HeaderTitleAdapter("Brand"), horizontalAdapter, HeaderTitleAdapter("New Arrival"), newArrivalAdapter)

    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)

//        val concatAdapter = ConcatAdapter(homeAdapter, HeaderTitleAdapter("Brand"), horizontalAdapter, HeaderTitleAdapter("New Arrival"), newArrivalAdapter)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getHomeData()
        observe()
    }

    private fun observe() = lifecycleScope.launch {
        viewModel.data.collect{ resource ->
            when (resource) {
                is StateView.Success -> {
                    resource.data?.let { values ->
                        homeAdapter.title = values.cardProduct.title
                        homeAdapter.description = values.cardProduct.description
                        homeAdapter.buttonTitle = values.cardProduct.buttonTitle
                        homeAdapter.imageUrl = values.cardProduct.imageUrl

                        concatAdapter.notifyDataSetChanged()

                    }
                }
                is StateView.Error -> {
                    resource.message?.let { message ->
                        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                    }
                }
                is StateView.Loading -> {
//                    binding.progressDetalhesCharacter.show()
                }
                else -> {}
            }
        }
    }

}
