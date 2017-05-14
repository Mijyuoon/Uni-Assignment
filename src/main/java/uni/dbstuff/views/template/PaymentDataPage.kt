package uni.dbstuff.views.template

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.VBox
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.CounterData
import uni.dbstuff.domain.PaymentData
import uni.dbstuff.domain.query.QPaymentData
import uni.dbstuff.fxui.FormattedCell
import uni.dbstuff.toSql
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by mijyu on 13/05/2017.
 */
class PaymentDataPage : Fragment() {
    override val root: VBox by fxml()
    val tbData: TableView<PaymentData> by fxid()

    val colArea: TableColumn<PaymentData, Number> by fxid()
    val colDate: TableColumn<PaymentData, Date> by fxid()
    val colCtrInit: TableColumn<PaymentData, Date> by fxid()
    val colCtrFinal: TableColumn<PaymentData, Date> by fxid()
    val colTotal: TableColumn<PaymentData, Number> by fxid()

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

        tbData.items = FXCollections.observableList(QPaymentData().findList())
    }

    fun createItem() {

    }
}
