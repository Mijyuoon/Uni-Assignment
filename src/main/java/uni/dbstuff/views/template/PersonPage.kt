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
import uni.dbstuff.utils.TableViewEditFormAbstractor
import uni.dbstuff.views.form.PersonForm
import java.util.*

/**
 * Created by mijyu on 13/05/2017.
 */
class PersonPage : Fragment() {
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
        colBirthday.cellValueFactory = PropertyValueFactory(Person::birthday.name)
        colIdent.cellValueFactory = PropertyValueFactory(Person::identCode.name)
        colAddress.cellValueFactory = PropertyValueFactory(Person::address.name)
        colPhoneNum.cellValueFactory = PropertyValueFactory(Person::telephone.name)

        colRole.cellValueFactory = Callback { ob ->
            val data = ob.value.role?.roleName
            SimpleStringProperty(data ?: "")
        }

        tbData.items = FXCollections.observableList(QPerson().findList())
    }

    fun createItem() {
        val item = Person()
        editor.add(item)
    }
}
