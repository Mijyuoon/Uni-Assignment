package uni.dbstuff.report

import tornadofx.*
import uni.dbstuff.domain.Area

/**
 * Объект для создания информационной выписки по участку.
 */
object AreaReport {
    /**
     * Создаёт информационную выписку по участку.
     * @param area Требуемый участок
     * @return Сгенерированная выписка
     */
    fun generate(area: Area): String {
        val builder = StringBuilder()

        val atpl = FX.messages["rpt_areaMain"]
        val isWater = FX.messages["bool_${area.waterSupply}"]
        builder.appendln(atpl.format(area.number, area.areaSize,
                area.owner, area.cadastreNumber, area.counterNumber,
                isWater, area.buildings.count()))

        val btpl = FX.messages["rpt_areaBuilding"]
        for(item in area.buildings) {
            builder.appendln(btpl.format(item.type?.buildingTypeName,
                    item.addintionalInfo.replace("\n", "\n  ")))
            builder.appendln()
        }

        return builder.toString()
    }
}