package uni.dbstuff.views

import javafx.scene.control.Alert
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.stage.FileChooser
import tornadofx.*
import java.io.IOException
import java.io.PrintWriter
import javax.swing.filechooser.FileSystemView

/**
 * Окно показа отчётов
 * @param data Текст отчёта
 */
class ReportView(data: String) : View() {
    init { title = messages["app_reportform"] }
    override val root: BorderPane by fxml()

    /**
     * Текстовое поле для текста отчёта
     */
    val txData: TextArea by fxid()

    /**
     * Главный инициализатор
     */
    init {
        txData.text = data
    }

    /**
     * Запрашивает имя файла используя диалог и сохраняет отчёт
     */
    fun saveReport() {
        val dialog = FileChooser()
        dialog.title = messages["cmd_saveFile"]
        dialog.initialDirectory = FileSystemView.getFileSystemView().homeDirectory

        val filter = FileChooser.ExtensionFilter(messages["dlg_textFile"], "*.txt")
        dialog.extensionFilters.add(filter)

        val file = dialog.showSaveDialog(this.currentWindow)
        if(file != null) {
            try {
                val writer = PrintWriter(file)
                writer.println(txData.text)
                writer.close()
            } catch(e: IOException) {
                val errbox = Alert(Alert.AlertType.ERROR)
                errbox.headerText = messages["mt_fileWriteError"]
                errbox.contentText = e.localizedMessage
                errbox.showAndWait()
            }
        }
    }
}
