package uni.dbstuff.views.form

import javafx.scene.control.TextField
import tornadofx.*
import uni.dbstuff.domain.BuildingType
import uni.dbstuff.domain.Role
import uni.dbstuff.utils.SafeParser

/**
 * Форма редактирования записей таблицы "Типы построек"
 * @param source Запись для редактирования
 */
class BuildingTypeForm(var source: BuildingType) : BaseForm() {
    val txName: TextField by fxid()

    init {
        txName.text = source.buildingTypeName
    }

    override fun onSaveForm() {
        val name = SafeParser.string(txName.text, messages["col_buildTypeName"]) ?: return

        source.buildingTypeName = name
        setSaved()
    }
}
