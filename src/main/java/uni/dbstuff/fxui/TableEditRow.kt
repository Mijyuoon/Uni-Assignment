package uni.dbstuff.fxui

import javafx.scene.control.TableRow
import javafx.scene.input.KeyCode

/**
 * Created by mijyu on 13/05/2017.
 */
class TableEditRow<T> : TableRow<T>() {
    var onEditRow: (T) -> Unit = {}
    var onDeleteRow: (T) -> Unit = {}

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