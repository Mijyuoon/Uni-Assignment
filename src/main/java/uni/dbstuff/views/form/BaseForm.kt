package uni.dbstuff.views.form

import tornadofx.*

/**
 * Created by mijyu on 13/05/2017.
 */
abstract class BaseForm : View() {
    init { title = messages["app_editform"] }
    override val root: Form by fxml()

    private var isSaved = false

    fun setSaved() { isSaved = true }

    abstract fun onSaveForm()

    fun saveForm() {
        onSaveForm()
        if(isSaved)
            close()
    }

    fun show(): Boolean {
        isSaved = false
        openModal(block = true)
        return isSaved
    }
}