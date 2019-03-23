package com.example.numfac.entity

import java.net.URL


@Entity(tableName = "dog")
open class DogsDB(
    @ColumnInfo(name = "breed")
    val breed: String,
    @ColumnInfo(name = "img")
    val img: URL
){
    @PrimaryKey(autoGenerate = true)
    var id:Int =0
}
