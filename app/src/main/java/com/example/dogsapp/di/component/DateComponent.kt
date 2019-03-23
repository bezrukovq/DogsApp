package com.example.dogsapp.di.component

import com.example.dogsapp.di.module.DateModule
import com.example.dogsapp.di.scope.DateScope
import com.example.dogsapp.view.fragments.dogsList.RecyclerFragment
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [DateModule::class])
@DateScope
interface DateComponent {

    //fun inject(dateDetailsFragment: DogsDetailsFragment)

    fun inject(recyclerFragment: RecyclerFragment)
}
