package uni.dbstuff.views.form

import javafx.collections.FXCollections
import javafx.scene.control.CheckBox
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import tornadofx.*
import uni.dbstuff.utils.Const
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.query.QPerson
import uni.dbstuff.utils.SafeParser

/**
 * Created by mijyu on 13/05/2017.
 */
class AreaForm(var source: Area) : BaseForm() {

    val txNum: TextField by fxid()
    val cbOwner: ComboBox<Person> by fxid()
    val txSize: TextField by fxid()
    val txCadNum: TextField by fxid()
    val txCtrId: TextField by fxid()
    val ciWater: CheckBox by fxid()

    init {
        val people = QPerson().findList()
        cbOwner.items = FXCollections.observableList(people)

        txNum.text = source.number.toString()
        cbOwner.selectionModel.select(source.owner)
        txSize.text = source.areaSize.toString()
        txCadNum.text = source.cadastreNumber.toString()
        txCtrId.text = source.counterNumber.toString()
        ciWater.isSelected = source.waterSupply
    }

    override fun onSaveForm() {
        val number = SafeParser.int(txNum.text, messages["col_areaNum"]) { x -> x < 0 } ?: return
        val owner = cbOwner.value
        val size = SafeParser.double(txSize.text, messages["col_areaSize"]) { x -> x < 0 } ?: return
        val cadNum = SafeParser.long(txCadNum.text, messages["col_areaCadNum"]) { x -> x < 0 } ?: return
        val ctrId = SafeParser.long(txCtrId.text, messages["col_areaCtrId"]) { x -> x < 0 } ?: return
        val water = ciWater.isSelected

        source.number = number
        source.owner = owner
        source.areaSize = size
        source.cadastreNumber = cadNum
        source.counterNumber = ctrId
        source.waterSupply = water

        setSaved()
    }
}
