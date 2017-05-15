package uni.dbstuff.utils

import java.time.LocalDate
import java.util.*

/**
 * Преобразует {@link java.util.Date} в {@link java.sql.Date}
 * @receiver Объект типа {@link java.util.Date}
 * @return Объект типа {@link java.sql.Date}
 */
fun Date.toSql() = java.sql.Date(this.time)

/**
 * Преобразует {@link java.time.LocalDate} в {@link java.sql.Date}
 * @receiver Объект типа {@link java.time.LocalDate}
 * @return Объект типа {@link java.sql.Date}
 */
fun LocalDate.toSql() = java.sql.Date.valueOf(this)