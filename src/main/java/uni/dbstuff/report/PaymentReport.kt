package uni.dbstuff.report

import tornadofx.*
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.query.QCounterData
import uni.dbstuff.domain.query.QElectricityRate
import uni.dbstuff.domain.query.QPaymentData
import java.sql.Date
import java.text.SimpleDateFormat

/**
 * Created by mijyu on 14/05/2017.
 */
object PaymentReport {
    fun generate(date: Date, area: Area): String {
        val builder = StringBuilder()

        val ctrdata = QCounterData().area.equalTo(area).date.before(date)
                .select("date,value").orderBy().date.asc().findList()
        val ctrdiff = ctrdata.zip(ctrdata.drop(1)).map { x -> x.second.value - x.first.value }
        val tarifdata = ctrdata.drop(1).map { ob ->
            val data = QElectricityRate().begin.before(ob.date).finish.after(ob.date)
                    .select("rate").findList()
            data.sumByDouble { x -> x.rate } }
        val sumToPay = ctrdiff.zip(tarifdata).sumByDouble { x -> x.first * x.second }

        val paydata = QPaymentData().area.equalTo(area).date.before(date)
                .select("total").orderBy().date.asc().findList()
        val sumPaid = paydata.sumByDouble { x -> x.total }

        val datefmt = SimpleDateFormat(FX.messages["format_date"])
        builder.appendln(FX.messages["rpt_paymentMain"].format(
                datefmt.format(date), sumToPay - sumPaid))

        return builder.toString()
    }
}