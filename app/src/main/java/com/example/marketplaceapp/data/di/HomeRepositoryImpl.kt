package com.example.marketplaceapp.data.di

import com.example.marketplaceapp.data.mapper.toDomain
import com.example.marketplaceapp.data.remote.ServiceApi
import com.example.marketplaceapp.domain.model.HomeDomain
import com.example.marketplaceapp.domain.repository.HomeRepository
import com.example.marketplaceapp.helper.ResourceState
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val serviceApi: ServiceApi): HomeRepository {
    override suspend fun getHomeData(): ResourceState<HomeDomain> {

        val response = serviceApi.getHomeData()

        if (response.isSuccessful) {
            response.body()?.let { homeData ->
                val homeDomain = homeData.toDomain()
                return ResourceState.Success(homeDomain)
            }
        }
        return ResourceState.Error(response.message())

    }
}