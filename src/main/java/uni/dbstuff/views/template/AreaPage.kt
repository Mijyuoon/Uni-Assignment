package uni.dbstuff.views.template

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.VBox
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.query.QArea
import uni.dbstuff.fxui.ButtonCell
import uni.dbstuff.utils.TableViewEditFormAbstractor
import uni.dbstuff.views.AppMainView
import uni.dbstuff.views.IRefresher
import uni.dbstuff.views.ITabAdder
import uni.dbstuff.views.form.AreaForm

/**
 * Created by mijyu on 13/05/2017.
 */
class AreaPage(adder: ITabAdder) : Fragment(), IRefresher {
    override val root: VBox by fxml()
    val tbData: TableView<Area> by fxid()

    val colNumber: TableColumn<Area, Number> by fxid()
    val colOwner: TableColumn<Area, Person> by fxid()
    val colSize: TableColumn<Area, Number> by fxid()
    val colCadNum: TableColumn<Area, Number> by fxid()
    val colCtrId: TableColumn<Area, Number> by fxid()
    val colWater: TableColumn<Area, String> by fxid()
    val colBuilding: TableColumn<Area, String> by fxid()
    val colCounter: TableColumn<Area, String> by fxid()
    val colPayment: TableColumn<Area, String> by fxid()

    val editor = TableViewEditFormAbstractor(tbData) { x -> AreaForm(x) }

    init {
        colNumber.cellValueFactory = PropertyValueFactory(Area::number.name)
        colOwner.cellValueFactory = PropertyValueFactory(Area::owner.name)
        colSize.cellValueFactory = PropertyValueFactory(Area::areaSize.name)
        colCadNum.cellValueFactory = PropertyValueFactory(Area::cadastreNumber.name)
        colCtrId.cellValueFactory = PropertyValueFactory(Area::counterNumber.name)

        colWater.cellValueFactory = Callback { ob ->
            val msg = "bool_${ob.value.waterSupply}"
            SimpleStringProperty(messages[msg])
        }

        colBuilding.cellValueFactory = Callback { ob ->
            val data = ob.value.buildings.count()
            val repr = String.format(messages["format_records"], data)
            SimpleStringProperty(repr)
        }
        colBuilding.cellFactory = Callback {
            ButtonCell(messages["cmd_openView"]) {
                x -> adder.showTableBuildingForArea(x)
            }
        }

        colCounter.cellValueFactory = Callback { ob ->
            val data = ob.value.counters.count()
            val repr = String.format(messages["format_records"], data)
            SimpleStringProperty(repr)
        }
        colCounter.cellFactory = Callback {
            ButtonCell(messages["cmd_openView"]) {
                x -> adder.showTableCtrDataForArea(x)
            }
        }

        colPayment.cellValueFactory = Callback { ob ->
            val data = ob.value.payments.count()
            val repr = String.format(messages["format_records"], data)
            SimpleStringProperty(repr)
        }
        colPayment.cellFactory = Callback {
            ButtonCell(messages["cmd_openView"]) {
                x -> adder.showTablePaymentForArea(x)
            }
        }

        tbData.items = FXCollections.observableList(QArea().fetch("owner").findList())
    }

    fun createItem() {
        val item = Area()
        editor.add(item)
    }

    fun deleteItem() {
        val item = tbData.selectionModel.selectedItem ?: return
        editor.delete(item)
    }

    override fun refresh() = Unit
}
