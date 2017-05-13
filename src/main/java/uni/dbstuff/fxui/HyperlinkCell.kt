package uni.dbstuff.fxui

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Hyperlink
import javafx.scene.control.TableCell
import tornadofx.*

/**
 * Created by mijyu on 13/05/2017.
 */
class HyperlinkCell<T>(text: String?) : TableCell<T, Unit>() {
    private val hyperlink = Hyperlink()

    var onAction by property<EventHandler<ActionEvent>>()
    fun onActionProperty() = getProperty(HyperlinkCell<T>::onAction)

    var linkText by property(text)
    fun linkTextProperty() = getProperty(HyperlinkCell<T>::linkText)

    init {
        hyperlink.textProperty().bind(linkTextProperty())
        hyperlink.onAction = EventHandler { ev -> onAction?.handle(ev) }
    }

    override fun updateItem(item: Unit?, empty: Boolean) {
        super.updateItem(item, empty)

        graphic = if(empty) null else hyperlink
    }
}