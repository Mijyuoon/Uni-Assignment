package uni.dbstuff

import javafx.event.EventHandler
import javafx.scene.control.TableView
import java.time.LocalDate
import java.util.*

/**
 * Created by mijyu on 13/05/2017.
 */

fun Date.toSql() = java.sql.Date(this.time)

fun String.matches(regex: String) = this.matches(Regex(regex))

fun LocalDate.toSql() = java.sql.Date.valueOf(this)