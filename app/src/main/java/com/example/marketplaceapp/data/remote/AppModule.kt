package com.example.marketplaceapp.data.remote

import com.example.marketplaceapp.data.di.HomeRepositoryImpl
import com.example.marketplaceapp.domain.repository.HomeRepository
import com.example.marketplaceapp.domain.usecase.GetHomeUseCase
import com.example.marketplaceapp.domain.usecase.GetHomeUseCaseImpl
import com.example.marketplaceapp.helper.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ServiceApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceApi::class.java)


    @Provides
    @Singleton
    fun provideGetHomeUseCaseInstance(repository: HomeRepository): GetHomeUseCase {
        return GetHomeUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideHomeRepositoryInstance(serviceApi: ServiceApi): HomeRepository {
        return HomeRepositoryImpl(serviceApi)
    }
}
