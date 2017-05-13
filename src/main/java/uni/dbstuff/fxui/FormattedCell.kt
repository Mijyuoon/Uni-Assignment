package uni.dbstuff.fxui

import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import javafx.util.Callback
import java.text.Format

/**
 * Created by mijyu on 13/05/2017.
 */
class FormattedCell<S,T>(var format: Format) : TableCell<S,T>() {
    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)

        if(item == null || empty) {
            setText(null)
        } else {
            setText(format.format(item))
        }
    }
}