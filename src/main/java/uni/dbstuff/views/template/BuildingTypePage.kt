package uni.dbstuff.views.template

import javafx.collections.FXCollections
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.VBox
import tornadofx.*
import uni.dbstuff.domain.BuildingType
import uni.dbstuff.domain.query.QBuildingType
import uni.dbstuff.utils.TableViewEditFormAbstractor
import uni.dbstuff.views.IRefresher
import uni.dbstuff.views.form.BuildingTypeForm

/**
 * Created by mijyu on 13/05/2017.
 */
class BuildingTypePage : Fragment(), IRefresher {
    override val root: VBox by fxml()
    val tbData: TableView<BuildingType> by fxid()

    val colType: TableColumn<BuildingType, String> by fxid()

    val editor = TableViewEditFormAbstractor(tbData) { x -> BuildingTypeForm(x) }

    init {
        colType.cellValueFactory = PropertyValueFactory(BuildingType::buildingTypeName.name)

        tbData.items = FXCollections.observableList(QBuildingType().findList())
    }

    fun createItem() {
        val item = BuildingType()
        editor.add(item)
    }

    override fun refresh() = Unit
}
