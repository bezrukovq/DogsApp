package com.example.dogsapp.di.component

import android.content.Context
import com.example.dogsapp.di.module.AppModule
import com.example.dogsapp.di.module.NetModule
import com.example.dogsapp.di.module.ServiceModule

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    ServiceModule::class])
interface AppComponent {

    fun provideApp(): Context

    //fun numFacApiService(): DogsApiService
}
