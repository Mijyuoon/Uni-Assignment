package main

import io.ebean.Ebean
import uni.dbstuff.domain.Building
import uni.dbstuff.domain.BuildingType
import uni.dbstuff.domain.Role

/**
 * Created by mijyu on 12/05/2017.
 */
object LoadTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val list = Role.where().ID.eq(2).findList()
        println(list)
    }
}