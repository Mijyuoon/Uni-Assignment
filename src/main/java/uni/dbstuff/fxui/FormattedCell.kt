package uni.dbstuff.fxui

import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import javafx.util.Callback
import java.text.Format

/**
 * Ячейка таблицы с поддержкой форматирования
 * @param S Тип объектов, отображаемых в таблице
 * @param T Тип столбца, содержащего данную ячейку
 * @param format Объект, задающий формат ячейки
 */
class FormattedCell<S,T>(var format: Format) : TableCell<S,T>() {
    /**
     * Обработчик события обновления ячейки
     * @param item Объект, связанный с ячейкой
     * @param empty Является ли ячейка пустой
     */
    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)

        if(item == null || empty) {
            setText(null)
        } else {
            setText(format.format(item))
        }
    }
}