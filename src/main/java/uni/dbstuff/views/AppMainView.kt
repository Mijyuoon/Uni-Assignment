package uni.dbstuff.views

import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import tornadofx.*
import uni.dbstuff.domain.Area
import uni.dbstuff.views.form.RoleForm
import uni.dbstuff.views.template.*

class AppMainView : View() {
    init { title = messages["app_title"] }
    override val root: BorderPane by fxml()

    val pnTabs: TabPane by fxid()

    val tabAdder = object : ITabAdder {
        override fun showTableBuildingForArea(area: Area) {
            val title = messages["tab_buildingsArea"]
            addTab(title.format(area.number), BuildingPage(area))
        }
    }

    init {
        showTablePerson()
        showTableBuilding()
        showTableArea()

        pnTabs.selectionModel.selectedItemProperty().addListener {
            _, _, tb -> (tb.userData as IRefresher).refresh()
            System.out.println("works?")
        }
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
            pnTabs.selectionModel.select(tab)
        }
    }

    fun appExit() = System.exit(0)

    fun showTableArea() = addTab(messages["tab_areas"], AreaPage(tabAdder))
    fun showTablePerson() = addTab(messages["tab_people"], PersonPage())
    fun showTableBuilding() = addTab(messages["tab_buildings"], BuildingPage())
    fun showTableCtrData() = addTab(messages["tab_counterData"], CounterDataPage())
    fun showTablePayment() = addTab(messages["tab_paymentData"], PaymentDataPage())
    fun showTablePayRate() = addTab(messages["tab_payRates"], ElectricityRatePage())
    fun showTableBuildType() = addTab(messages["tab_buildTypes"], BuildingTypePage())
    fun showTablePersonRole() = addTab(messages["tab_personRoles"], RolePage())
}



