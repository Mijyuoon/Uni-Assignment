package uni.dbstuff.views

import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.util.Callback
import tornadofx.*
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.query.QArea
import uni.dbstuff.report.AreaReport
import uni.dbstuff.report.PaymentReport
import uni.dbstuff.report.PersonReport
import uni.dbstuff.utils.toSql
import uni.dbstuff.views.template.*
import java.time.LocalDate

/**
 * Главное окно приложения.
 */
class AppMainView : View() {
    init { title = messages["app_title"] }
    override val root: BorderPane by fxml()

    /**
     * Главная панель вкладок
     */
    val pnTabs: TabPane by fxid()

    /**
     * Объект с функциями для создания вкладок извне главного окна
     */
    val tabAdder = object : ITabAdder {
        override fun showTableBuildingForArea(area: Area) {
            val title = messages["tab_buildingsArea"]
            addTab(title.format(area.number), BuildingPage(area))
        }

        override fun showTableCtrDataForArea(area: Area) {
            val title = messages["tab_counterDataArea"]
            addTab(title.format(area.number), CounterDataPage(area))
        }

        override fun showTablePaymentForArea(area: Area) {
            val title = messages["tab_paymentDataArea"]
            addTab(title.format(area.number), PaymentDataPage(area))
        }
    }

    /**
     * Главный инициализатор
     */
    init {
        pnTabs.selectionModel.selectedItemProperty().addListener {
            _, _, tb -> (tb?.userData as? IRefresher)?.refresh()
        }
    }

    /**
     * Добавляет новую вкладку в главное окно программы
     * @param text Название вкладки
     * @param content Содержимое вкладки
     */
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

    /**
     * Выходит из программы
     */
    fun appExit() = System.exit(0)

    /**
     * Показывает вкладку "Участки"
     */
    fun showTableArea() = addTab(messages["tab_areas"], AreaPage(tabAdder))

    /**
     * Показывает вкладку "Садоводы"
     */
    fun showTablePerson() = addTab(messages["tab_people"], PersonPage())

    /**
     * Показывает вкладку "Постройки"
     */
    fun showTableBuilding() = addTab(messages["tab_buildings"], BuildingPage())

    /**
     * Показывает вкладку "Показания счётчика"
     */
    fun showTableCtrData() = addTab(messages["tab_counterData"], CounterDataPage())

    /**
     * Показывает вкладку "Оплата за электричество"
     */
    fun showTablePayment() = addTab(messages["tab_paymentData"], PaymentDataPage())

    /**
     * Показывает вкладку "Тарифы электроснабжения"
     */
    fun showTablePayRate() = addTab(messages["tab_payRates"], ElectricityRatePage())

    /**
     * Показывает вкладку "Типы построек"
     */
    fun showTableBuildType() = addTab(messages["tab_buildTypes"], BuildingTypePage())

    /**
     * Показывает вкладку "Роли садоводов"
     */
    fun showTablePersonRole() = addTab(messages["tab_personRoles"], RolePage())

    /**
     * Формирует информационную выписку по участку
     */
    fun showAreaStats() {
        val areas = QArea().select("number").findList()
        val dialog = ChoiceDialog(null, areas)
        dialog.headerText = messages["mt_areaReport"]
        dialog.contentText = messages["msg_areaReport"]

        val res = dialog.showAndWait()
        if(res.isPresent) {
            val report = AreaReport.generate(res.get())
            ReportView(report).openModal()
        }
    }

    /**
     * Формирует информационную выписку о садоводах
     */
    fun showPersonStats() {
        val report = PersonReport.generate()
        ReportView(report).openModal()
    }

    /**
     * Формирует отчёт по задолженности
     */
    fun showPaymentStats() {
        val dialog = Dialog<Pair<LocalDate, Area>?>()
        dialog.headerText = messages["mt_paymentReport"]
        dialog.dialogPane.buttonTypes.addAll(ButtonType.OK, ButtonType.CANCEL)
        dialog.dialogPane.styleClass.add("choice-dialog")

        val grid = GridPane()
        grid.hgap = 10.0
        grid.vgap = 10.0
        grid.padding = Insets(20.0, 10.0, 10.0, 10.0)

        val picker = DatePicker()
        picker.value = LocalDate.now()

        val areabox = ComboBox<Area>()
        val areas = QArea().select("number").findList()
        areabox.items = FXCollections.observableList(areas)

        grid.add(Label(messages["msg_paymentReport1"]), 0, 0)
        grid.add(picker, 1, 0)
        grid.add(Label(messages["msg_paymentReport2"]), 0, 1)
        grid.add(areabox, 1, 1)

        dialog.dialogPane.content = grid

        dialog.resultConverter = Callback { bt ->
            val data = Pair(picker.value, areabox.value)
            if(bt == ButtonType.OK) data else null
        }

        val res = dialog.showAndWait()
        if(res.isPresent) {
            val date = res.get().first.toSql()
            val area = res.get().second
            val report = PaymentReport.generate(date, area)
            ReportView(report).openModal()
        }
    }
}



