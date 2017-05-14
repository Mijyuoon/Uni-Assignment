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
        if(area == null) return

        val date = txDate.value

        val initl = txInit.text
        if(!initl.matches(Const.floatRx)) return

        val final = txFinal.text
        if(!final.matches(Const.floatRx)) return

        val total = txTotal.text
        if(!total.matches(Const.floatRx)) return

        source.area = area
        source.date = date.toSql()
        source.initialData = initl.toDouble()
        source.finalData = final.toDouble()
        source.total = total.toDouble()

        setSaved()
    }
}
