package uni.dbstuff

import java.util.*

/**
 * Created by mijyu on 13/05/2017.
 */

fun Date.toSql(): java.sql.Date = java.sql.Date(this.time)