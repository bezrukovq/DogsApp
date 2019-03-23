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
        list.add("beagle")
        list.add("borzoi")
        list.add("boxer")
        list.add("brabancon")
        list.add("boston bulldog")
        list.add("french bulldog")
        list.add("australian cattledog")
        list.add("chihuahua")
        list.add("cardigan corgi")
        list.add("dalmatian")
        list.add("scottish deerhound")
        list.add("dingo")
        list.add("doberman")
        list.add("husky")
        list.add("labrador")
        list.add("dandie terrier")
        list.add("fox terrier")
        list.add("irish terrier")
        list.add("lakeland terrier")
        list.add("norfolk terrier")
        list.add("norwich terrier")
        list.add("patterdale terrier")
        list.add("russell terrier")
        list.add("scottish terrier")
        list.add("sealyham terrier")
        list.add("silky terrier")
        list.add("tibetan terrier")
        list.add("toy terrier")
        list.add("westhighland terrier")
        list.add("wheaten terrier")
        list.add("yorkshire terrier")
        list.add("vizsla")
        list.add("weimaraner")
        list.add("irish wolfhound")
        list.add("whippet")
        return list
    }
}
