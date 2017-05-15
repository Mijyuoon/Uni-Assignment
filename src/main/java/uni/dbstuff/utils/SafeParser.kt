package uni.dbstuff.utils

import javafx.scene.control.Alert
import tornadofx.*

/**
 * Объект для безопасного преобразования строк с выводом сообщений об ошибке
 */
object SafeParser {
    /**
     * Пустая функция дополнительной проверки ошибок
     */
    private val errorFunc: ErrorFunc<Any> = { false }

    /**
     * Проверяет успешность преобразования и выводит сообщение об ошибке
     * @param name Имя преобразуемого поля или переменной
     * @param msg Идентификатор сообщения об ошибке
     * @param res Результат преобразования
     * @param errFn Функция дополнительной проверки ошибок
     * @return Результат преобразования
     */
    private fun <T> errCheck(name: String, msg: String, res: T?, errFn: ErrorFunc<T>): T? {
        if(res == null || errFn(res)) {
            val dialog = Alert(Alert.AlertType.ERROR)
            dialog.headerText = FX.messages["mt_parseError"].format(name)
            dialog.contentText = FX.messages["msg_${msg}ParseError"]
            dialog.showAndWait()
            return null
        }

        return res
    }

    /**
     * Преобразует строку в целое число типа {@link kotlin.Int}
     * @param s Входная строка
     * @param name Имя преобразуемого поля или переменной
     * @param errFn Функция дополнительной проверки ошибок
     * @return Полученное число либо null при наличии ошибки
     */
    fun int(s: String?, name: String, errFn: ErrorFunc<Int> = errorFunc): Int? {
        val res = s?.toIntOrNull(10)
        return errCheck(name, "int", res, errFn)
    }

    /**
     * Преобразует строку в целое число типа {@link kotlin.Long}
     * @param s Входная строка
     * @param name Имя преобразуемого поля или переменной
     * @param errFn Функция дополнительной проверки ошибок
     * @return Полученное число либо null при наличии ошибки
     */
    fun long(s: String?, name: String, errFn: ErrorFunc<Long> = errorFunc): Long? {
        val res = s?.toLongOrNull(10)
        return errCheck(name, "int", res, errFn)
    }

    /**
     * Преобразует строку в вещественное число типа {@link kotlin.Double}
     * @param s Входная строка
     * @param name Имя преобразуемого поля или переменной
     * @param errFn Функция дополнительной проверки ошибок
     * @return Полученное число либо null при наличии ошибки
     */
    fun double(s: String?, name: String, errFn: ErrorFunc<Double> = errorFunc): Double? {
        val res = s?.toDoubleOrNull()
        return errCheck(name, "float", res, errFn)
    }

    /**
     * Проверяет строку на пустоту либо равенство null
     * @param s Входная строка
     * @param name Имя преобразуемого поля или переменной
     * @return Входная строка либо null при наличии ошибки
     */
    fun string(s: String?, name: String): String? {
        val res = if(s?.isNotEmpty() ?: false) s else null
        return errCheck(name, "str", res, errorFunc)
    }
}