package uni.dbstuff.utils

import io.ebean.Model
import javafx.event.EventHandler
import javafx.scene.control.TableRow
import javafx.scene.control.TableView
import javafx.scene.input.KeyCode
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.fxui.TableEditRow
import uni.dbstuff.views.form.BaseForm

/**
 * Created by mijyu on 13/05/2017.
 */
class TableViewEditFormAbstractor<T: Model>(var tableView: TableView<T>, var formFactory: (T) -> BaseForm): Callback<TableView<T>, TableRow<T>> {
    init {
        tableView.rowFactory = this
        tableView.onKeyPressed = EventHandler { ev ->
            if(ev.code == KeyCode.DELETE) {
                val sel = tableView.selectionModel
                delete(sel.selectedItem)
            }
        }
    }

    override fun call(param: TableView<T>): TableRow<T> {
        val row = TableEditRow<T>()
        row.onEditRow = { x -> edit(x) }
        row.onDeleteRow = { x -> delete(x) }
        return row
    }

    fun add(item: T) {
        if(formFactory(item).show()) {
            item.save()
            tableView.items.add(item)
        }
    }

    fun edit(item: T) {
        if(formFactory(item).show()) {
            item.save()
            tableView.refresh()
        }
    }

    fun delete(item: T) {
        item.delete()
        tableView.items.remove(item)
    }
}