package uni.dbstuff.views.form

import javafx.collections.FXCollections
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import tornadofx.*
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.Role
import uni.dbstuff.domain.query.QRole
import uni.dbstuff.utils.toSql
import uni.dbstuff.utils.SafeParser

/**
 * Created by mijyu on 14/05/2017.
 */
class PersonForm(var source: Person) : BaseForm() {
    val txLastName: TextField by fxid()
    val txMidName: TextField by fxid()
    val txFirstName: TextField by fxid()
    val txBirthday: DatePicker by fxid()
    val txIdent: TextField by fxid()
    val txAddress: TextField by fxid()
    val txPhoneNum: TextField by fxid()
    val cbRole: ComboBox<Role> by fxid()

    init {
        val roles = QRole().findList()
        cbRole.items = FXCollections.observableList(roles)

        txFirstName.text = source.firstName
        txLastName.text = source.lastName
        txMidName.text = source.middleName
        txBirthday.value = source.birthday.toLocalDate()
        txIdent.text = source.identCode.toString()
        txAddress.text = source.address
        txPhoneNum.text = source.telephone
        cbRole.selectionModel.select(source.role)
    }

    override fun onSaveForm() {
        val lname = SafeParser.string(txLastName.text, messages["col_personLastName"]) ?: return
        val fname = SafeParser.string(txFirstName.text, messages["col_personFirstName"]) ?: return
        val mname = SafeParser.string(txMidName.text, messages["col_personMidName"]) ?: return
        val birthday = txBirthday.value.toSql()
        val ident = SafeParser.long(txIdent.text, messages["col_personIdent"]) { x -> x < 0 } ?: return
        val address = SafeParser.string(txAddress.text, messages["col_personAddress"]) ?: return
        val phone = SafeParser.string(txPhoneNum.text, messages["col_personPhoneNum"]) ?: return
        val role = cbRole.value

        source.firstName = fname
        source.lastName = lname
        source.middleName = mname
        source.birthday = birthday
        source.identCode = ident
        source.address = address
        source.telephone = phone
        source.role = role

        setSaved()
    }
}
