package uni.dbstuff.views.template

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.Building
import uni.dbstuff.fxui.HyperlinkCell

/**
 * Created by mijyu on 13/05/2017.
 */
class BuildingPage : View() {
    override val root: TableView<Building> by fxml()

    val colArea: TableColumn<Building, Number> by fxid()
    val colType: TableColumn<Building, String> by fxid()
    val colInfo: TableColumn<Building, String> by fxid()

    init {
        colArea.cellValueFactory = Callback { ob ->
            val data = ob.value.area?.number
            SimpleIntegerProperty(data ?: 0)
        }

        colType.cellValueFactory = Callback { ob ->
            val data = ob.value.type?.buildingTypeName
            SimpleStringProperty(data ?: "")
        }

        colInfo.cellValueFactory = PropertyValueFactory("addintionalInfo")
    }
}
