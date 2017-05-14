package uni.dbstuff.views.template

import javafx.collections.FXCollections
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.VBox
import tornadofx.*
import uni.dbstuff.domain.Role
import uni.dbstuff.domain.query.QRole
import uni.dbstuff.utils.TableViewEditFormAbstractor
import uni.dbstuff.views.IRefresher
import uni.dbstuff.views.form.RoleForm

/**
 * Created by mijyu on 13/05/2017.
 */
class RolePage : Fragment(), IRefresher {
    override val root: VBox by fxml()
    val tbData: TableView<Role> by fxid()

    val colName: TableColumn<Role, String> by fxid()

    val editor = TableViewEditFormAbstractor(tbData) { x -> RoleForm(x) }

    init {
        colName.cellValueFactory = PropertyValueFactory(Role::roleName.name)

        tbData.items = FXCollections.observableList(QRole().findList())
    }

    fun createItem() {
        val item = Role()
        editor.add(item)
    }

    fun deleteItem() {
        val item = tbData.selectionModel.selectedItem ?: return
        editor.delete(item)
    }

    override fun refresh() = Unit
}
