package com.example.dogsapp.di.module

import com.example.dogsapp.model.DogsApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun netModule() = Kodein.Module {
    bind<Retrofit>() with singleton { provideRetrofit(instance(), provideCallAdapterFactory()) }
    bind<GsonConverterFactory>() with singleton { provideGsonConverterFactory() }
    bind<DogsApiService>() with singleton { instance<Retrofit>().create(DogsApiService::class.java) }
}

    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    fun provideCallAdapterFactory(): CoroutineCallAdapterFactory =
        CoroutineCallAdapterFactory()

    fun provideRetrofit(
        converterFactory: GsonConverterFactory,
        callAdapterFactory: CoroutineCallAdapterFactory
    ): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(converterFactory)
            .baseUrl("https://dog.ceo/api/breed/")
            .build()
