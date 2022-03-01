package com.eylulcan.composeexample.di

import com.eylulcan.composeexample.repository.CryptoRepository
import com.eylulcan.composeexample.service.CryptoAPI
import com.eylulcan.composeexample.util.Utils
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

    @Singleton
    @Provides
    fun provideCryptoAPI(): CryptoAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Utils.BASE_URL)
            .build()
            .create(CryptoAPI::class.java)
    }

    @Singleton
    @Provides
    fun providesCryptoRepository(
        api: CryptoAPI ) = CryptoRepository(api)

}