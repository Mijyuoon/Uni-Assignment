package uni.dbstuff.views.form

import javafx.collections.FXCollections
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.Role
import uni.dbstuff.domain.query.QRole
import uni.dbstuff.matches
import uni.dbstuff.toSql

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
        val fname = txFirstName.text
        if(fname.isEmpty()) return

        val mname = txMidName.text
        if(mname.isEmpty()) return

        val lname = txLastName.text
        if(lname.isEmpty()) return

        val birthday = txBirthday.value

        val ident = txIdent.text
        if(!ident.matches("[0-9]+")) return

        val address = txAddress.text
        if(address.isEmpty()) return

        val phone = txPhoneNum.text
        if(phone.isEmpty()) return

        val role = cbRole.value
        if(role == null) return

        source.firstName = fname
        source.lastName = lname
        source.middleName = mname
        source.birthday = birthday.toSql()
        source.identCode = ident.toLong()
        source.address = address
        source.telephone = phone
        source.role = role

        setSaved()
    }
}
