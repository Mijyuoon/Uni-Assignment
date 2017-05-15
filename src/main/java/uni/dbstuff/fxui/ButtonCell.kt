package uni.dbstuff.fxui

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.TableCell
import tornadofx.*
import uni.dbstuff.utils.ActionFunc

/**
 * Ячейка таблицы с астроенной кнопкой
 * @param S Тип объектов, отображаемых в таблице
 * @param T Тип столбца, содержащего данную ячейку
 * @param text Текст кнопки
 * @param action Событие нажатия на кнопку
 */
class ButtonCell<S,T>(text: String?, action: ActionFunc<S>) : TableCell<S,T>() {
    private val button = Button()

    /**
     * Событие нажатия на кнопку
     */
    var onAction: ActionFunc<S> = action

    /**
     * Текст кнопки
     */
    var linkText by property(text)
    fun linkTextProperty() = getProperty(ButtonCell<S,T>::linkText)

    /**
     * Главный инициализатор
     */
    init {
        button.addClass("table-cell-button")
        button.textProperty().bind(linkTextProperty())
        button.onAction = EventHandler { onAction(rowItem) }
    }

    /**
     * Обработчик события обновления ячейки
     * @param item Объект, связанный с ячейкой
     * @param empty Является ли ячейка пустой
     */
    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)

        graphic = if(empty) null else button
        text = if(empty) null else item.toString()
    }
}