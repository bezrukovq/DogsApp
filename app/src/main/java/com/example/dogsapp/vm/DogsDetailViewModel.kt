package com.example.dogsapp.vm

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData
import com.example.dogsapp.entity.Dogs
import com.example.dogsapp.model.DogsModel
import io.reactivex.rxkotlin.subscribeBy

class DogsDetailViewModel(private val model: DogsModel) : ViewModel() {
    val showProgress = MutableLiveData<Boolean>()
    val dogData = MutableLiveData<Dogs>()
    val dogBreed = MutableLiveData<String>()

    fun getDogBreed(breed: String) {
        dogBreed.postValue(breed)
    }

    @SuppressLint("CheckResult")
    fun getDogPic(dog: String) {
        model.getDogInfo(dog)
            .doOnSubscribe { showProgress.postValue(true) }
            .subscribeBy(onSuccess = {
                dogData.postValue(it)
            }, onError = {dogBreed.postValue(it.message)})
    }
}
