package uni.dbstuff.views.form

import tornadofx.*

/**
 * Базовый класс форм редактирования записей таблицы
 */
abstract class BaseForm : View() {
    init { title = messages["app_editform"] }
    override val root: Form by fxml()

    /**
     * Успешность сохранения данных
     */
    private var isSaved = false

    /**
     * Отмечает успешное сохранение данных
     */
    fun setSaved() { isSaved = true }

    /**
     * Обработчик события попытки сохранения
     */
    abstract fun onSaveForm()

    /**
     * Производит попытку сохранения данных
     */
    fun saveForm() {
        onSaveForm()
        if(isSaved)
            close()
    }

    /**
     * Показывает окно формы и ожидает её закрытия
     * @return Успешность сохранения данных
     */
    fun show(): Boolean {
        isSaved = false
        openModal(block = true)
        return isSaved
    }
}