package uni.dbstuff.views.form

import javafx.collections.FXCollections
import javafx.scene.control.CheckBox
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import uni.dbstuff.utils.Const
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.query.QPerson

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
        val number = txNum.text
        if(!number.matches(Const.intRx)) return

        val owner = cbOwner.value
        if(owner == null) return

        val size = txSize.text
        if(!size.matches(Const.floatRx)) return

        val cadNum = txCadNum.text
        if(!cadNum.matches(Const.intRx)) return

        val ctrId = txCtrId.text
        if(!ctrId.matches(Const.intRx)) return

        val water = ciWater.isSelected

        source.number = number.toInt()
        source.owner = owner
        source.areaSize = size.toDouble()
        source.cadastreNumber = cadNum.toLong()
        source.counterNumber = ctrId.toLong()
        source.waterSupply = water

        setSaved()
    }
}
