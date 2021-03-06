package uni.dbstuff.views.template

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.Parent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.VBox
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.Building
import uni.dbstuff.domain.query.QBuilding
import uni.dbstuff.utils.TableViewEditFormAbstractor
import uni.dbstuff.views.IRefresher
import uni.dbstuff.views.form.BuildingForm

/**
 * Таблица данных "Постройки"
 */
class BuildingPage(val area: Area? = null) : Fragment(), IRefresher {
    override val root: VBox by fxml()
    val tbData: TableView<Building> by fxid()

    val colArea: TableColumn<Building, Number> by fxid()
    val colType: TableColumn<Building, String> by fxid()
    val colInfo: TableColumn<Building, String> by fxid()

    val editor =  TableViewEditFormAbstractor(tbData) { x -> BuildingForm(x) }

    init {
        colArea.cellValueFactory = Callback { ob ->
            val data = ob.value.area?.number
            SimpleIntegerProperty(data ?: 0)
        }

        colType.cellValueFactory = Callback { ob ->
            val data = ob.value.type?.buildingTypeName
            SimpleStringProperty(data ?: "")
        }

        colInfo.cellValueFactory = PropertyValueFactory(Building::addintionalInfo.name)

        refresh()
    }

    fun createItem() {
        val item = Building()
        editor.add(item)
    }

    fun deleteItem() {
        val item = tbData.selectionModel.selectedItem ?: return
        editor.delete(item)
    }

    override fun refresh() {
        val items = if(area == null) {
            QBuilding().findList()
        } else {
            QBuilding().area.equalTo(area).findList()
        }

        tbData.items = FXCollections.observableList(items)
        tbData.refresh()
    }
}
