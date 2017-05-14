package uni.dbstuff.fxui

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.TableCell
import tornadofx.*
import uni.dbstuff.utils.ActionFunc

/**
 * Created by mijyu on 13/05/2017.
 */
class ButtonCell<S,T>(text: String?, action: ActionFunc<S>) : TableCell<S,T>() {
    private val button = Button()

    var onAction: ActionFunc<S> = action

    var linkText by property(text)
    fun linkTextProperty() = getProperty(ButtonCell<S,T>::linkText)

    init {
        button.addClass("table-cell-button")
        button.textProperty().bind(linkTextProperty())
        button.onAction = EventHandler { onAction(rowItem) }
    }

    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)

        graphic = if(empty) null else button
        text = if(empty) null else item.toString()
    }
}