package uni.dbstuff.views.template

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.CounterData
import uni.dbstuff.domain.PaymentData
import uni.dbstuff.fxui.FormattedCell
import uni.dbstuff.toSql
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by mijyu on 13/05/2017.
 */
class PaymentDataPage : Fragment() {
    override val root: TableView<PaymentData> by fxml()

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

        colCtrInit.cellValueFactory = Callback { ob ->
            val data = ob.value.initialData?.date
            SimpleObjectProperty(data)
        }
        colCtrInit.cellFactory = Callback {
            FormattedCell(SimpleDateFormat(messages["format_date"]))
        }

        colCtrFinal.cellValueFactory = Callback { ob ->
            val data = ob.value.finalData?.date
            SimpleObjectProperty(data)
        }
        colCtrFinal.cellFactory = Callback {
            FormattedCell(SimpleDateFormat(messages["format_date"]))
        }

        colDate.cellValueFactory = PropertyValueFactory(PaymentData::date.name)
        colDate.cellFactory = Callback {
            FormattedCell(SimpleDateFormat(messages["format_date"]))
        }

        colTotal.cellValueFactory = PropertyValueFactory(PaymentData::total.name)
    }
}
