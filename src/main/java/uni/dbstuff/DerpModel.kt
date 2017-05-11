package uni.dbstuff

import tornadofx.*
import java.util.*

/**
 * Created by mijyu on 11/05/2017.
 */
class DerpModel {
    var shite by property("")
    fun shiteProperty() = getProperty(DerpModel::shite)

    var herpDerp by property(0.0)
    fun herpDerpProperty() = getProperty(DerpModel::herpDerp)

    var beepBoop by property(Date())
    fun beepBoopProperty() = getProperty(DerpModel::beepBoop)

    var combobox by property("")
    fun comboboxProperty() = getProperty(DerpModel::combobox)
}