package com.example.dogsapp.di.component

import com.example.dogsapp.di.module.DogModule
import com.example.dogsapp.di.scope.DogScope
import com.example.dogsapp.view.fragments.dogsDetail.DogsDetailFragment
import com.example.dogsapp.view.fragments.dogsList.RecyclerFragment
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [DogModule::class])
@DogScope
interface DateComponent {

    fun inject(dogsDetailsFragment: DogsDetailFragment)

    fun inject(recyclerFragment: RecyclerFragment)
}
