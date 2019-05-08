package com.example.dogsapp.model

import com.example.dogsapp.entity.Dogs
import kotlinx.coroutines.Deferred
import retrofit2.Response
import java.util.*

class DogsModel(val dogApi : DogsApiService) {

    fun getDogInfo(breed: String): Deferred<Response<Dogs>> =
        dogApi.getDateInfo(breed)

    fun getBreedList(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("affenpinscher")
        list.add("african")
        list.add("airedale")
        list.add("akita")
        list.add("appenzeller")
        list.add("basenji")
        list.add("borzoi")
        list.add("boxer")
        list.add("brabancon")
        list.add("dalmatian")
        list.add("dingo")
        list.add("doberman")
        list.add("husky")
        list.add("labrador")
        list.add("vizsla")
        list.add("weimaraner")
        list.add("whippet")
        return list
    }
}
