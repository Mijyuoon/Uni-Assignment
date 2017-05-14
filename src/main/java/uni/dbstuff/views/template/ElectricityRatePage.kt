package uni.dbstuff.views.template

import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.VBox
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.ElectricityRate
import uni.dbstuff.domain.query.QElectricityRate
import uni.dbstuff.fxui.FormattedCell
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by mijyu on 13/05/2017.
 */
class ElectricityRatePage : Fragment() {
    override val root: VBox by fxml()
    val tbData: TableView<ElectricityRate> by fxid()

    val colInit: TableColumn<ElectricityRate, Date> by fxid()
    val colFinal: TableColumn<ElectricityRate, Date> by fxid()
    val colValue: TableColumn<ElectricityRate, Number> by fxid()

    init {
        colInit.cellValueFactory = PropertyValueFactory(ElectricityRate::begin.name)
        colInit.cellFactory = Callback {
            FormattedCell(SimpleDateFormat(messages["format_date"]))
        }

        colFinal.cellValueFactory = PropertyValueFactory(ElectricityRate::finish.name)
        colFinal.cellFactory = Callback {
            FormattedCell(SimpleDateFormat(messages["format_date"]))
        }

        colValue.cellValueFactory = PropertyValueFactory(ElectricityRate::rate.name)

        tbData.items = FXCollections.observableList(QElectricityRate().findList())
    }

    fun createItem() {

    }
}
