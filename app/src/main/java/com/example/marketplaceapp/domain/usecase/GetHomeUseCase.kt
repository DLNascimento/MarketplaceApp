package com.example.marketplaceapp.domain.usecase

import com.example.marketplaceapp.domain.model.HomeDomain
import com.example.marketplaceapp.helper.ResourceState
import dagger.Provides


interface GetHomeUseCase {

    suspend operator fun invoke(): ResourceState<HomeDomain>
}