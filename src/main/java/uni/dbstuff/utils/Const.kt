package uni.dbstuff.utils

import java.sql.Date
import java.time.LocalDate

/**
 * Created by mijyu on 14/05/2017.
 */

object Const {
    val intRx = Regex("[0-9]+")
    val floatRx = Regex("[0-9]+([,.][0-9]+)?")

    fun curDate() = Date.valueOf(LocalDate.now())
}