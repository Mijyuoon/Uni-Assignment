package uni.dbstuff.report

import tornadofx.*
import uni.dbstuff.domain.query.QArea
import uni.dbstuff.domain.query.QPerson
import java.text.SimpleDateFormat

/**
 * Created by mijyu on 14/05/2017.
 */
object PersonReport {
    fun generate(): String {
        val builder = StringBuilder()
        val people = QPerson().findList()

        val areaMap = HashMap<Long, Int>()
        QArea().fetch("owner", "ID").findEach { ob ->
            val key = ob.owner!!.ID
            val sum = areaMap.getOrDefault(key, 0)
            areaMap[key] = sum + 1
        }

        builder.appendln(FX.messages["rpt_personMain"].format(people.count()))

        val ptpl = FX.messages["rpt_personItem"]
        val datefmt = SimpleDateFormat(FX.messages["format_date"])
        for(item in people) {
            val bday = datefmt.format(item.birthday)
            val areas = areaMap.getOrDefault(item.ID, 0)
            builder.appendln(ptpl.format(item.lastName, item.firstName,
                    item.middleName, bday, item.identCode, item.address,
                    item.telephone, item.role?.roleName, areas))
            builder.appendln()
        }

        return builder.toString()
    }
}