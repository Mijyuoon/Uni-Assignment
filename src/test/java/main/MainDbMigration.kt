package main

/**
 * Created by mijyu on 09/05/2017.
 */

import io.ebean.Platform
import io.ebean.dbmigration.DbMigration
import java.io.IOException

object MainDbMigration {
    @JvmStatic
    @Throws(IOException::class)
    fun main(args: Array<String>) {
        val dbMigration = DbMigration()
        dbMigration.setPlatform(Platform.SQLITE)
        dbMigration.generateMigration()
    }
}