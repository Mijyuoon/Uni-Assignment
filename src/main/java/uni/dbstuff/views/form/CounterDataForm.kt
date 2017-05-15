package uni.dbstuff.views.form

import javafx.collections.FXCollections
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import tornadofx.*
import uni.dbstuff.domain.*
import uni.dbstuff.domain.query.QArea
import uni.dbstuff.utils.toSql
import uni.dbstuff.utils.SafeParser

/**
 * Форма редактирования записей таблицы "Показания счётчика"
 * @param source Запись для редактирования
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
        val date = txDate.value
        val value = SafeParser.double(txValue.text, messages["col_counterDataValue"]) { x -> x < 0 } ?: return

        source.area = area
        source.date = date.toSql()
        source.value = value

        setSaved()
    }
}
