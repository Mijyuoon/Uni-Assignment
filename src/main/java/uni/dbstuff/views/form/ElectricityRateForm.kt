package uni.dbstuff.views.form

import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import tornadofx.*
import uni.dbstuff.domain.ElectricityRate
import uni.dbstuff.utils.toSql
import uni.dbstuff.utils.SafeParser

/**
 * Created by mijyu on 14/05/2017.
 */
class ElectricityRateForm(var source: ElectricityRate) : BaseForm() {
    val txBegin: DatePicker by fxid()
    val txFinish: DatePicker by fxid()
    val txRate: TextField by fxid()

    init {
        txBegin.value = source.begin.toLocalDate()
        txFinish.value = source.finish.toLocalDate()
        txRate.text = source.rate.toString()
    }

    override fun onSaveForm() {
        val begin = txBegin.value.toSql()
        val finish = txFinish.value.toSql()
        val rate = SafeParser.double(txRate.text, messages["col_electricRateValue"]) { x -> x < 0 } ?: return

        source.begin = begin
        source.finish = finish
        source.rate = rate

        setSaved()
    }
}
