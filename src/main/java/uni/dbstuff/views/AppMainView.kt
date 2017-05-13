package uni.dbstuff.views

import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import tornadofx.*
import uni.dbstuff.views.template.BuildingPage

class AppMainView : View() {
    init { title = messages["app_title"] }
    override val root: BorderPane by fxml()

    val pnTabs: TabPane by fxid()

    init {
        val tab = Tab("wat")
        tab.content = BuildingPage().root
        pnTabs.tabs.add(tab)
    }
}



