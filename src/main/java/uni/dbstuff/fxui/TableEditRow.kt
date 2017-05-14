package uni.dbstuff.fxui

import javafx.scene.control.TableRow
import javafx.scene.input.KeyCode
import uni.dbstuff.utils.ActionFunc

/**
 * Created by mijyu on 13/05/2017.
 */
class TableEditRow<T> : TableRow<T>() {
    var onEditRow: ActionFunc<T> = {}
    var onDeleteRow: ActionFunc<T> = {}

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