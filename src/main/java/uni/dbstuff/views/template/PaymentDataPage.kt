package uni.dbstuff.views.template

import javafx.beans.property.SimpleIntegerProperty
import javafx.collections.FXCollections
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.VBox
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.PaymentData
import uni.dbstuff.domain.query.QPaymentData
import uni.dbstuff.fxui.FormattedCell
import uni.dbstuff.utils.TableViewEditFormAbstractor
import uni.dbstuff.views.IRefresher
import uni.dbstuff.views.form.PaymentDataForm
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Таблица данных "Оплата за электричество"
 */
class PaymentDataPage(val area: Area? = null) : Fragment(), IRefresher {
    override val root: VBox by fxml()
    val tbData: TableView<PaymentData> by fxid()

    val colArea: TableColumn<PaymentData, Number> by fxid()
    val colDate: TableColumn<PaymentData, Date> by fxid()
    val colCtrInit: TableColumn<PaymentData, Date> by fxid()
    val colCtrFinal: TableColumn<PaymentData, Date> by fxid()
    val colTotal: TableColumn<PaymentData, Number> by fxid()

    val editor = TableViewEditFormAbstractor(tbData) { x -> PaymentDataForm(x) }

    init {
        colArea.cellValueFactory = Callback { ob ->
            val data = ob.value.area?.number
            SimpleIntegerProperty(data ?: 0)
        }

        colCtrInit.cellValueFactory = PropertyValueFactory(PaymentData::initialData.name)
        colCtrFinal.cellValueFactory = PropertyValueFactory(PaymentData::finalData.name)

        colDate.cellValueFactory = PropertyValueFactory(PaymentData::date.name)
        colDate.cellFactory = Callback {
            FormattedCell(SimpleDateFormat(messages["format_date"]))
        }

        colTotal.cellValueFactory = PropertyValueFactory(PaymentData::total.name)

        refresh()
    }

    fun createItem() {
        val item = PaymentData()
        editor.add(item)
    }

    fun deleteItem() {
        val item = tbData.selectionModel.selectedItem ?: return
        editor.delete(item)
    }

    override fun refresh() {
        val items = if(area == null) {
            QPaymentData().findList()
        } else {
            QPaymentData().area.equalTo(area).findList()
        }

        tbData.items = FXCollections.observableList(items)
        tbData.refresh()
    }
}
