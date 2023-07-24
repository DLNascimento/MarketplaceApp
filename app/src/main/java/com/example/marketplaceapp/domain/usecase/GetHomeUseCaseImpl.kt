package com.example.marketplaceapp.domain.usecase

import com.example.marketplaceapp.domain.model.HomeDomain
import com.example.marketplaceapp.domain.repository.HomeRepository
import com.example.marketplaceapp.helper.ResourceState
import javax.inject.Inject

class GetHomeUseCaseImpl @Inject constructor(private val homeRepository: HomeRepository) : GetHomeUseCase  {
    override suspend fun invoke(): ResourceState<HomeDomain> {
        return homeRepository.getHomeData()
    }
}