package uni.dbstuff.views.template

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.Area
import uni.dbstuff.fxui.ButtonCell

/**
 * Created by mijyu on 13/05/2017.
 */
class AreaPage : Fragment() {
    override val root: TableView<Area> by fxml()

    val colNumber: TableColumn<Area, Number> by fxid()
    val colSize: TableColumn<Area, Number> by fxid()
    val colCadNum: TableColumn<Area, Number> by fxid()
    val colCtrId: TableColumn<Area, Number> by fxid()
    val colWater: TableColumn<Area, Boolean> by fxid()
    val colBuilding: TableColumn<Area, String> by fxid()
    val colCounter: TableColumn<Area, String> by fxid()
    val colPayment: TableColumn<Area, String> by fxid()

    init {
        colNumber.cellValueFactory = PropertyValueFactory(Area::number.name)
        colSize.cellValueFactory = PropertyValueFactory(Area::areaSize.name)
        colCadNum.cellValueFactory = PropertyValueFactory(Area::cadastreNumber.name)
        colCtrId.cellValueFactory = PropertyValueFactory(Area::counterNumber.name)
        colWater.cellValueFactory = PropertyValueFactory(Area::waterSupply.name)

        colBuilding.cellValueFactory = Callback { ob ->
            val data = ob.value.buildings.count()
            val repr = String.format(messages["format_records"], data)
            SimpleStringProperty(repr)
        }
        colBuilding.cellFactory = Callback {
            ButtonCell(messages["cmd_openView"])
        }

        colCounter.cellValueFactory = Callback { ob ->
            val data = ob.value.counters.count()
            val repr = String.format(messages["format_records"], data)
            SimpleStringProperty(repr)
        }
        colCounter.cellFactory = Callback {
            ButtonCell(messages["cmd_openView"])
        }

        colPayment.cellValueFactory = Callback { ob ->
            val data = ob.value.payments.count()
            val repr = String.format(messages["format_records"], data)
            SimpleStringProperty(repr)
        }
        colPayment.cellFactory = Callback {
            ButtonCell(messages["cmd_openView"])
        }
    }
}
