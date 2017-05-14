package uni.dbstuff.utils

import javafx.scene.control.Alert
import tornadofx.*

/**
 * Created by mijyu on 14/05/2017.
 */

object SafeParser {
    private fun <T> errCheck(name: String, msg: String, res: T?, errFn: ErrorFunc<T>): T? {
        if(res == null || errFn?.invoke(res) ?: false) {
            val dialog = Alert(Alert.AlertType.ERROR)
            dialog.headerText = FX.messages["mt_parseError"].format(name)
            dialog.contentText = FX.messages["msg_${msg}ParseError"]
            dialog.showAndWait()
            return null
        }

        return res
    }

    fun int(s: String?, name: String, errFn: ErrorFunc<Int> = null): Int? {
        val res = s?.toIntOrNull(10)
        return errCheck(name, "int", res, errFn)
    }

    fun long(s: String?, name: String, errFn: ErrorFunc<Long> = null): Long? {
        val res = s?.toLongOrNull(10)
        return errCheck(name, "int", res, errFn)
    }

    fun double(s: String?, name: String, errFn: ErrorFunc<Double> = null): Double? {
        val res = s?.toDoubleOrNull()
        return errCheck(name, "float", res, errFn)
    }

    fun string(s: String?, name: String): String? {
        val res = if(s?.isNotEmpty() ?: false) s else null
        return errCheck(name, "str", res, null)
    }
}