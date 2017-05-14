package uni.dbstuff.views.form

import javafx.collections.FXCollections
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import uni.dbstuff.domain.*
import uni.dbstuff.domain.query.QArea
import uni.dbstuff.toSql
import uni.dbstuff.utils.Const

/**
 * Created by mijyu on 14/05/2017.
 */
class CounterDataForm(var source: CounterData) : BaseForm() {
    val cbArea: ComboBox<Area> by fxid()
    val txDate: DatePicker by fxid()
    val txValue: TextField by fxid()

    init {
        val areas = QArea().findList()
        cbArea.items = FXCollections.observableList(areas)

        cbArea.selectionModel.select(source.area)
        txDate.value = source.date.toLocalDate()
        txValue.text = source.value.toString()
    }

    override fun onSaveForm() {
        val area = cbArea.value
        if(area == null) return

        val date = txDate.value

        val value = txValue.text
        if(!value.matches(Const.floatRx)) return

        source.area = area
        source.date = date.toSql()
        source.value = value.toDouble()

        setSaved()
    }
}
