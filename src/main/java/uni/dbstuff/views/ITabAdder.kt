package uni.dbstuff.views

import uni.dbstuff.domain.Area

/**
 * Интерфейс для создания вкладок извне главного окна
 */
interface ITabAdder {
    fun showTableBuildingForArea(area: Area)
    fun showTableCtrDataForArea(area: Area)
    fun showTablePaymentForArea(area: Area)
}