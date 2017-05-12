package uni.dbstuff.views

import javafx.beans.binding.Bindings
import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.*
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.layout.BorderPane
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.DerpModel
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.Role
import uni.dbstuff.domain.query.QPerson
import uni.dbstuff.domain.query.QRole
import java.util.*

class AppMainView : View() {
    init { title = messages["app_title"] }
    override val root: BorderPane by fxml()

    val comboSrc = FXCollections.observableArrayList<String>()

    val tbTest: TableView<DerpModel> by fxid()
    val tclDerp1: TableColumn<DerpModel, String> by fxid()
    val tclDerp2: TableColumn<DerpModel, Double> by fxid()
    val tclDerp3: TableColumn<DerpModel, Date> by fxid()
    val tclCombobox: TableColumn<DerpModel, String> by fxid()

    val TP: TabPane by fxid()
    val tbRoles: TableView<Role> by fxid()
    val tclRoleID: TableColumn<Role,Long> by fxid()
    val tclRoleName: TableColumn<Role,String> by fxid()

    init {
        tbTest.isEditable = true

        tclDerp1.onEditCommit = EventHandler { e ->
            System.out.println("Set 'shite' to: " + e.newValue)
        }

        tclCombobox.cellFactory = ComboBoxTableCell.forTableColumn(comboSrc)

        tbTest.rowFactory = Callback {
            val row = TableRow<DerpModel>()

            val menu = ContextMenu()
            val menuDerp = MenuItem("Derp")
            menuDerp.onAction = EventHandler {
                System.out.println("DERP!")
            }
            menu.items.add(menuDerp)
            row.contextMenuProperty().bind(
                    Bindings.`when`(Bindings.isNotNull(row.itemProperty()))
                            .then(menu)
                            .otherwise(null as ContextMenu?))

            row
        }

    }

    fun addShit() {
        val item = DerpModel()
        item.shite = "Shite"
        item.herpDerp = 13.37

        val dataItems = tbTest.items
        dataItems.add(item)
    }

    fun addCombo() {
        comboSrc.add("Item ${comboSrc.count() + 1}")
    }

    fun newTab(){
        val tab  = Tab("Tab " + (TP.tabs.size + 1))
        //tab.content.add()
        TP.tabs.add(tab)
        TP.selectionModel.select(tab);
    }

    fun createRole(){
        Role("Bugger").save()
        System.out.printf("creating bugger")
    }
    fun deleteRole(){
        Role.where().roleName.equalTo("Bugger").delete()
        System.out.printf("deleting bugger")
    }

    fun loadRoles(){
        val roles = FXCollections.observableArrayList<Role>(QRole().findList())
        tbRoles.items = roles

    }


}



