package uni.dbstuff.domain

import uni.dbstuff.domain.finder.ElectricityRateFinder
import org.jetbrains.annotations.NotNull
import uni.dbstuff.utils.Const
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Модель объекта "Тариф электроснабжения"
 */
@Entity
@Table(name = "electricity_rate")
class ElectricityRate: BaseModel() {
    /**
     * Дата начала действия
     */
    @NotNull
    var begin: Date = Const.curDate()

    /**
     * Дата окончания действия
     */
    @NotNull
    var finish: Date = Const.curDate()

    /**
     * Тариф
     */
    @NotNull
    var rate: Double = 0.0

    companion object : ElectricityRateFinder()
}
