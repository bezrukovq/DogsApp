package com.example.dogsapp.vm

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData
import com.example.dogsapp.entity.Dogs
import com.example.dogsapp.model.DogsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class DogsDetailViewModel(private val model: DogsModel) : ViewModel() {
    val showProgress = MutableLiveData<Boolean>()
    val dogData = MutableLiveData<Dogs>()
    val dogBreed = MutableLiveData<String>()

    fun getDogBreed(breed: String) {
        dogBreed.postValue(breed)
    }

    fun getDogPic(dog: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val request = model.getDogInfo(dog)
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        dogData.postValue(response.body())
                    } else {
                        dogBreed.postValue(response.errorBody().toString())
                    }
                } catch (e: HttpException) {
                    dogBreed.postValue(e.message)
                } catch (e: Throwable) {
                    dogBreed.postValue(e.message)
                }
            }
        }
    }
}
