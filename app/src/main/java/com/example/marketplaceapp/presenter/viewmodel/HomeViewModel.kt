package com.example.marketplaceapp.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplaceapp.domain.model.HomeDomain
import com.example.marketplaceapp.domain.usecase.GetHomeUseCase
import com.example.marketplaceapp.helper.ResourceState
import com.example.marketplaceapp.helper.StateView
import dagger.Provides
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase
): ViewModel() {

    private val _data = MutableStateFlow<StateView<HomeDomain>>(StateView.Loading())
    val data: StateFlow<StateView<HomeDomain>> = _data

    init {
        _data.value = StateView.Loading()
    }

    fun getHomeData() = viewModelScope.launch {
        val resource = getHomeUseCase.invoke()
        _data.value = validateResource(resource)
    }

    private fun validateResource(resource: ResourceState<HomeDomain>): StateView<HomeDomain> {
        return when (resource) {
            is ResourceState.Success -> {
                if (resource.data != null) {
                    StateView.Success(resource.data)
                } else {
                    StateView.Error(resource.message ?: "Erro genérico")
                }
            }
            is ResourceState.Error -> StateView.Error(resource.message ?: "Erro genérico")
        }
    }
}