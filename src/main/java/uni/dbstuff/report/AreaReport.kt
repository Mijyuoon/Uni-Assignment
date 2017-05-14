package uni.dbstuff.report

import tornadofx.*
import uni.dbstuff.domain.Area

/**
 * Created by mijyu on 14/05/2017.
 */
object AreaReport {
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