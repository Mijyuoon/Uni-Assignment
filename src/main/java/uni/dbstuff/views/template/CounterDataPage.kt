package uni.dbstuff.views.template

import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.CounterData
import uni.dbstuff.fxui.FormattedCell
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by mijyu on 13/05/2017.
 */
class CounterDataPage : Fragment() {
    override val root: TableView<CounterData> by fxml()

    val colArea: TableColumn<CounterData, Number> by fxid()
    val colDate: TableColumn<CounterData, Date> by fxid()
    val colValue: TableColumn<CounterData, Double> by fxid()

    init {
        colArea.cellValueFactory = Callback { ob ->
            val data = ob.value.area?.number
            SimpleIntegerProperty(data ?: 0)
        }

        colDate.cellValueFactory = PropertyValueFactory(CounterData::date.name)
        colDate.cellFactory = Callback {
            FormattedCell(SimpleDateFormat(messages["format_date"]))
        }

        colValue.cellValueFactory = PropertyValueFactory(CounterData::value.name)

    }
}
