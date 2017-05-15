package uni.dbstuff.utils

import io.ebean.Model
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.TableRow
import javafx.scene.control.TableView
import javafx.scene.input.KeyCode
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.fxui.TableEditRow
import uni.dbstuff.views.form.BaseForm

/**
 * Класс для упрощения синхронизации изменений в визуальной таблице и в базе данных
 * @param T Тип данных, отображаемых в таблице
 * @param formFactory Функция, возвращающая экземпляр формы для редактирования записи
 * @param tableView Экземпляр {@link javafx.scene.control.TableView} для привязки
 */
class TableViewEditFormAbstractor<T: Model>(var tableView: TableView<T>, var formFactory: (T) -> BaseForm): Callback<TableView<T>, TableRow<T>> {
    /**
     * Главный инициализатор
     */
    init {
        tableView.rowFactory = this
        tableView.onKeyPressed = EventHandler { ev ->
            if(ev.code == KeyCode.DELETE) {
                val sel = tableView.selectionModel
                delete(sel.selectedItem)
            }
        }
    }

    /**
     * Обработчик события запроса создания новой строки в таблице
     * @param param Экземпляр {@link javafx.scene.control.TableView}, в котором создаётся строка
     * @return Созданная строка таблицы
     */
    override fun call(param: TableView<T>): TableRow<T> {
        val row = TableEditRow<T>()
        row.onEditRow = { x -> edit(x) }
        row.onDeleteRow = { x -> delete(x) }
        return row
    }

    /**
     * Функция для добавления нового элемента в таблицу
     * @param item Данные, добавляемые в таблицу
     */
    fun add(item: T) {
        if(formFactory(item).show()) {
            item.save()
            tableView.items.add(item)
        }
    }

    /**
     * Функция для редактировакия элемента в таблице
     * @param item Данные, подлежащие редактированию
     */
    fun edit(item: T) {
        if(formFactory(item).show()) {
            item.save()
            tableView.refresh()
        }
    }

    /**
     * Функция для удаления элемента из таблицы
     * @param item Данные, удаляемые из таблицы
     */
    fun delete(item: T) {
        val dialog = Alert(Alert.AlertType.CONFIRMATION)
        dialog.contentText = FX.messages["msg_deleteRecord"]
        dialog.headerText = FX.messages["mt_dataLoss"]

        val res = dialog.showAndWait()
        if(res.get() == ButtonType.OK) {
            item.delete()
            tableView.items.remove(item)
        }
    }
}