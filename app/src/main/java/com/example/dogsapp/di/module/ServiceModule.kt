package com.example.dogsapp.di.module

import com.example.dogsapp.model.DogsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideNumFacApiService(retrofit: Retrofit): DogsApiService =
        retrofit.create(DogsApiService::class.java)
}
