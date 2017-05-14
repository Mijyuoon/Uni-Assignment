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
 * Created by mijyu on 14/05/2017.
 */
class PaymentDataForm(var source: PaymentData) : BaseForm() {
    val cbArea: ComboBox<Area> by fxid()
    val txDate: DatePicker by fxid()
    val txInit: TextField by fxid()
    val txFinal: TextField by fxid()
    val txTotal: TextField by fxid()

    init {
        val areas = QArea().findList()
        cbArea.items = FXCollections.observableList(areas)

        cbArea.selectionModel.select(source.area)
        txDate.value = source.date.toLocalDate()
        txInit.text = source.initialData.toString()
        txFinal.text = source.finalData.toString()
        txTotal.text = source.total.toString()
    }

    override fun onSaveForm() {
        val area = cbArea.value
        val date = txDate.value.toSql()
        val initl = SafeParser.double(txInit.text, messages["col_paymentCtrInit"]) { x -> x < 0 } ?: return
        val final = SafeParser.double(txFinal.text, messages["col_paymentCtrFinal"]) { x -> x < 0 } ?: return
        val total = SafeParser.double(txTotal.text, messages["col_paymentTotal"]) { x -> x < 0 } ?: return

        source.area = area
        source.date = date
        source.initialData = initl
        source.finalData = final
        source.total = total

        setSaved()
    }
}
