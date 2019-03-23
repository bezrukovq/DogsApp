package com.example.dogsapp.di.module

import com.example.dogsapp.di.scope.DogScope
import com.example.dogsapp.model.DogsApiService
import com.example.dogsapp.model.DogsModel
import com.example.dogsapp.view.fragments.dogsList.RecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
class DogModule {

    @Provides
    @DogScope
    fun provideDogsModel(numFacApiService: DogsApiService): DogsModel =
        DogsModel(numFacApiService)//

    @Provides
    @DogScope
    fun provideDateListAdapter(): RecyclerAdapter = RecyclerAdapter { }//
}
