package com.example.dogsapp.model

import com.example.dogsapp.entity.Dogs
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class DogsModel(val dogApi : DogsApiService) {

    fun getDogInfo(breed: String): Single<Dogs> =
        dogApi.getDateInfo(breed)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

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
