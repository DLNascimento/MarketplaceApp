package com.example.marketplaceapp.domain.repository

import com.example.marketplaceapp.domain.model.HomeDomain
import com.example.marketplaceapp.helper.ResourceState

interface HomeRepository {

    suspend fun getHomeData() : ResourceState<HomeDomain>

}