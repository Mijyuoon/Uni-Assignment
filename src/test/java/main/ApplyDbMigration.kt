package main

import io.ebean.Ebean
import java.io.IOException

/**
 * Created by mijyu on 09/05/2017.
 */

object ApplyDbMigration {
    @JvmStatic
    @Throws(IOException::class)
    fun main(args: Array<String>) {
        Ebean.getDefaultServer()
    }
}