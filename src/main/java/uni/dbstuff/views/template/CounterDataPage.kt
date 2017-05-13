package uni.dbstuff.views.template

import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.CounterData
import java.util.*

/**
 * Created by mijyu on 13/05/2017.
 */
class CounterDataPage : View() {
    override val root: TableView<CounterData> by fxml()

    val colArea: TableColumn<CounterData, Number> by fxid()
    val colDate: TableColumn<CounterData, Date> by fxid()
    val colValue: TableColumn<CounterData, Double> by fxid()

    init {
        colArea.cellValueFactory = Callback { ob ->
            val data = ob.value.area?.number
            SimpleIntegerProperty(data ?: 0)
        }

        colDate.cellValueFactory = PropertyValueFactory("date")
        colValue.cellValueFactory = PropertyValueFactory("data")
    }
}
