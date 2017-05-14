package uni.dbstuff.views.form

import javafx.scene.control.TextField
import tornadofx.*
import uni.dbstuff.domain.Role
import uni.dbstuff.utils.SafeParser

/**
 * Created by mijyu on 13/05/2017.
 */
class RoleForm(var source: Role) : BaseForm() {

    val txName: TextField by fxid()

    init {
        txName.text = source.roleName
    }

    override fun onSaveForm() {
        val name = SafeParser.string(txName.text, messages["col_personRoleName"]) ?: return

        source.roleName = name
        setSaved()
    }
}
