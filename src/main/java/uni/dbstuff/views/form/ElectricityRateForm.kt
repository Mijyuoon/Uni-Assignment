package uni.dbstuff.views.form

import javafx.collections.FXCollections
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import uni.dbstuff.domain.ElectricityRate
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.Role
import uni.dbstuff.domain.query.QRole
import uni.dbstuff.matches
import uni.dbstuff.toSql
import uni.dbstuff.utils.Const

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
        val begin = txBegin.value
        val finish = txFinish.value

        val rate = txRate.text
        if(!rate.matches(Const.floatRx)) return

        source.begin = begin.toSql()
        source.finish = finish.toSql()
        source.rate = rate.toDouble()

        setSaved()
    }
}
