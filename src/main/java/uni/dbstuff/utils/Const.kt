package uni.dbstuff.utils

import java.sql.Date
import java.time.LocalDate

/**
 * Объект, содержащий различные константы и генераторы констант
 */
object Const {
    /**
     * возвращает текущую дату типа {@link java.sql.Date}
     * @return Текущая дата типа {@link java.sql.Date}
     * @see java.sql.Date
     */
    fun curDate() = Date.valueOf(LocalDate.now())
}