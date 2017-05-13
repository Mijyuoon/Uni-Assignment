package uni.dbstuff.views

import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import tornadofx.*
import uni.dbstuff.views.template.*

class AppMainView : View() {
    init { title = messages["app_title"] }
    override val root: BorderPane by fxml()

    val pnTabs: TabPane by fxid()

    init {

    }

    private fun addTab(text: String, content: Fragment) {
        val hasTab = pnTabs.tabs.find { t -> t.text == text }

        if(hasTab != null) {
            pnTabs.selectionModel.select(hasTab)
        } else {
            val tab = Tab(text)
            tab.content = content.root
            tab.userData = content
            pnTabs.tabs.add(tab)
        }
    }

    fun appExit() = System.exit(0)

    fun showTableArea() = addTab(messages["tab_areas"], AreaPage())
    fun showTablePerson() = addTab(messages["tab_people"], PersonPage())
    fun showTableBuilding() = addTab(messages["tab_buildings"], BuildingPage())
    fun showTableCtrData() = addTab(messages["tab_counterData"], CounterDataPage())
    fun showTablePayment() = addTab(messages["tab_paymentData"], PaymentDataPage())
    fun showTablePayRate() = addTab(messages["tab_payRates"], ElectricityRatePage())
}



