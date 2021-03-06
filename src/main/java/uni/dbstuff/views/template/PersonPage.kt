package uni.dbstuff.views.template

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.VBox
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.query.QPerson
import uni.dbstuff.fxui.FormattedCell
import uni.dbstuff.utils.TableViewEditFormAbstractor
import uni.dbstuff.views.IRefresher
import uni.dbstuff.views.form.PersonForm
import java.text.SimpleDateFormat
import java.util.*

/**
 * Таблица данных "Садоводы"
 */
class PersonPage : Fragment(), IRefresher {
    override val root: VBox by fxml()
    val tbData: TableView<Person> by fxid()

    val colLastName: TableColumn<Person, String> by fxid()
    val colFirstName: TableColumn<Person, String> by fxid()
    val colMidName: TableColumn<Person, String> by fxid()
    val colBirthday: TableColumn<Person, Date> by fxid()
    val colIdent: TableColumn<Person, Long> by fxid()
    val colAddress: TableColumn<Person, String> by fxid()
    val colPhoneNum: TableColumn<Person, String> by fxid()
    val colRole: TableColumn<Person, String> by fxid()

    val editor = TableViewEditFormAbstractor(tbData) { x -> PersonForm(x) }

    init {
        colLastName.cellValueFactory = PropertyValueFactory(Person::lastName.name)
        colFirstName.cellValueFactory = PropertyValueFactory(Person::firstName.name)
        colMidName.cellValueFactory = PropertyValueFactory(Person::middleName.name)
        colIdent.cellValueFactory = PropertyValueFactory(Person::identCode.name)
        colAddress.cellValueFactory = PropertyValueFactory(Person::address.name)
        colPhoneNum.cellValueFactory = PropertyValueFactory(Person::telephone.name)

        colBirthday.cellValueFactory = PropertyValueFactory(Person::birthday.name)
        colBirthday.cellFactory = Callback {
            FormattedCell(SimpleDateFormat(messages["format_date"]))
        }

        colRole.cellValueFactory = Callback { ob ->
            val data = ob.value.role?.roleName
            SimpleStringProperty(data ?: "")
        }

        refresh()
    }

    fun createItem() {
        val item = Person()
        editor.add(item)
    }

    fun deleteItem() {
        val item = tbData.selectionModel.selectedItem ?: return
        editor.delete(item)
    }

    override fun refresh() {
        tbData.items = FXCollections.observableList(QPerson().findList())
        tbData.refresh()
    }
}
