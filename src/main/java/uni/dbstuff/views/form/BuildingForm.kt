package uni.dbstuff.views.form

import javafx.collections.FXCollections
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import uni.dbstuff.domain.*
import uni.dbstuff.domain.query.QArea
import uni.dbstuff.domain.query.QBuildingType
import uni.dbstuff.domain.query.QRole
import uni.dbstuff.matches
import uni.dbstuff.toSql

/**
 * Created by mijyu on 14/05/2017.
 */
class BuildingForm(var source: Building) : BaseForm() {
    val cbType: ComboBox<BuildingType> by fxid()
    val cbArea: ComboBox<Area> by fxid()
    val txInfo: TextArea by fxid()

    init {
        val types = QBuildingType().findList()
        cbType.items = FXCollections.observableList(types)

        val areas = QArea().findList()
        cbArea.items = FXCollections.observableList(areas)

        cbType.selectionModel.select(source.type)
        cbArea.selectionModel.select(source.area)
        txInfo.text = source.addintionalInfo
    }

    override fun onSaveForm() {
        val info = txInfo.text ?: ""

        val type = cbType.value
        if(type == null) return

        val area = cbArea.value
        if(area == null) return

        source.area = area
        source.type = type
        source.addintionalInfo = info

        setSaved()
    }
}