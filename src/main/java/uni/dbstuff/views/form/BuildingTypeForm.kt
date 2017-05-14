package uni.dbstuff.views.form

import javafx.scene.control.TextField
import tornadofx.*
import uni.dbstuff.domain.BuildingType
import uni.dbstuff.domain.Role

/**
 * Created by mijyu on 13/05/2017.
 */
class BuildingTypeForm(var source: BuildingType) : BaseForm() {
    val txName: TextField by fxid()

    init {
        txName.text = source.buildingTypeName
    }

    override fun onSaveForm() {
        val name = txName.text
        if(name.isEmpty()) return

        source.buildingTypeName = name
        setSaved()
    }
}
