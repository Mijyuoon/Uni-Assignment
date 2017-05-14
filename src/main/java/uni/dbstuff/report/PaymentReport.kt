package uni.dbstuff.report

import tornadofx.*
import java.sql.Date
import java.text.SimpleDateFormat

/**
 * Created by mijyu on 14/05/2017.
 */
object PaymentReport {
    fun generate(date: Date): String {
        val builder = StringBuilder()

        val payment = 0.0

        val datefmt = SimpleDateFormat(FX.messages["format_date"])
        builder.appendln(FX.messages["rpt_paymentMain"].format(
                datefmt.format(date), payment))

        return builder.toString()
    }
}