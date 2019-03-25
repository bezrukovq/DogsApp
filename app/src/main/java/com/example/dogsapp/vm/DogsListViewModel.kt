package com.example.dogsapp.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogsapp.model.DogsModel

class DogsListViewModel(private val model: DogsModel) : ViewModel() {
    val breedList = MutableLiveData<ArrayList<String>>()

    fun getBreedList(){
        breedList.postValue(model.getBreedList())
    }
}
