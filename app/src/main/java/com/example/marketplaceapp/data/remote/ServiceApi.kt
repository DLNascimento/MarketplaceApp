package com.example.marketplaceapp.data.remote

import com.example.marketplaceapp.data.dto.HomeDTO
import com.example.marketplaceapp.helper.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET(Constants.END_URL)
    suspend fun getHomeData(): Response<HomeDTO>
}