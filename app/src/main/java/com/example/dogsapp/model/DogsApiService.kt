package com.example.dogsapp.model

import com.example.dogsapp.entity.Dogs
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApiService{
    @GET("{breed}/images/random")
    fun getDateInfo(@Path("breed") breed: String): Deferred<Response<Dogs>>
}
