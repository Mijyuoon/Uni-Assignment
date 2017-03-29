package uni.dbstuff.views

import javafx.scene.layout.BorderPane
import tornadofx.*

class AppMainView : View() {
    init { title = messages["app_title"] }
    override val root: BorderPane by fxml()

}


