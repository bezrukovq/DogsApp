package com.example.dogsapp.model

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val URL = "https://dog.ceo/api/breed/"

    fun createApi(): DogsApiService {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL)
            .build()
        return retrofit.create(DogsApiService::class.java)
    }
}
