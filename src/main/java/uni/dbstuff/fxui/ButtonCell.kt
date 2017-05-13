package uni.dbstuff.fxui

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.TableCell
import tornadofx.*

/**
 * Created by mijyu on 13/05/2017.
 */
class ButtonCell<S,T>(text: String?) : TableCell<S,T>() {
    private val button = Button()

    var onAction by property<EventHandler<ActionEvent>>()
    fun onActionProperty() = getProperty(ButtonCell<S,T>::onAction)

    var linkText by property(text)
    fun linkTextProperty() = getProperty(ButtonCell<S,T>::linkText)

    init {
        button.addClass("table-cell-button")
        button.textProperty().bind(linkTextProperty())
        button.onAction = EventHandler { ev -> onAction?.handle(ev) }
    }

    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)

        graphic = if(empty) null else button
        text = if(empty) null else item.toString()
    }
}