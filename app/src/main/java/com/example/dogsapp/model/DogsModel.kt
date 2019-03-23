package com.example.dogsapp.model

import java.util.*

object DogsModel {

    val dogApi: DogsApiService = ApiFactory.createApi()
    //var db: AppDataBase? = null
    //var dateRepository: DateRepository? = null
    /*
    fun setDB(applicationContext: Context) {
        db = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "database"
        )
            .build()
        dateRepository = db?.dateDao()?.let { DateRepository(it) }
    }

    fun getFavDateList(): Single<List<DateDB>>? =
        dateRepository?.getAllDates()

    fun addToFavList(dateDB: DateDB) =
        dateRepository?.addDate(dateDB)?.subscribe()

    fun deleteFromFavList(dateDB: DateDB) =
        dateRepository?.deleteDate(dateDB)?.subscribe()

    fun getDateInfo(numDate: Int): Single<Date> =
        numApi.getDateInfo(numDate)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getDateList(): ArrayList<Int> {
        val list = ArrayList<Int>()
        val today = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        for (item: Int in today..today + COUNTER)
            list.add(item)
        curNumber = today + COUNTER + 1
        return list
    }

    fun expandDateList(itemsCount: Int): ArrayList<Int> {
        val list = ArrayList<Int>()
        for (item: Int in curNumber..curNumber + itemsCount) {
            if (curNumber <= LAST_DATE)
                list.add(item)
        }
        curNumber += itemsCount + 1
        return list
    }
    */
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
