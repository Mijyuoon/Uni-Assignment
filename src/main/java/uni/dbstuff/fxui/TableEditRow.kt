package uni.dbstuff.fxui

import javafx.scene.control.TableRow
import javafx.scene.input.KeyCode
import uni.dbstuff.utils.ActionFunc

/**
 * Строка таблицы с событиями для манипуляции
 * @param T Тип объектов, отображаемых в таблице
 */
class TableEditRow<T> : TableRow<T>() {
    /**
     * Обработчик события редактирования
     */
    var onEditRow: ActionFunc<T> = {}

    /**
     * Обработчик события едаления
     */
    var onDeleteRow: ActionFunc<T> = {}

    /**
     * Главный инициализатор
     */
    init {
        setOnMouseClicked { ev ->
            if(ev.clickCount == 2 && !isEmpty)
                onEditRow(item)
        }
        setOnKeyPressed { ev ->
            if(ev.code == KeyCode.DELETE)
                onDeleteRow(item)
        }
    }
}