package com.example.dogsapp.di.module

import com.example.dogsapp.di.scope.DateScope
import com.example.dogsapp.view.fragments.dogsList.RecyclerAdapter
import dagger.Module
import dagger.Provides

@Module
class DateModule {

 /*   @Provides
    @DateScope
    fun provideDateListPresenter(model: NumFacModel): DateListPresenter = DateListPresenter(model)

    @Provides
    @DateScope
    fun provideDateDetailPresenter(model: NumFacModel): DateDetailPresenter = DateDetailPresenter(model)

    @Provides
    @DateScope
    fun provideFavListPresenter(model: NumFacModel): FavListPresenter = FavListPresenter(model)

    @Provides
    @DateScope
    fun provideDateDAO(app: Context): DateDAO = Room.databaseBuilder(
        app,
        AppDataBase::class.java,
        "database"
    )
        .build().dateDao()

    @Provides
    @DateScope
    fun provideDateRepository(dateDAO: DateDAO) = DateRepository(dateDAO)

    @Provides
    @DateScope
    fun provideNumFacModel(numFacApiService: NumFacApiService, dateRepository: DateRepository): NumFacModel =
        NumFacModel(numFacApiService, dateRepository)//
*/
    @Provides
    @DateScope
    fun provideDateListAdapter(): RecyclerAdapter = RecyclerAdapter { }//
}
