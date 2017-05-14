package uni.dbstuff.domain

import uni.dbstuff.domain.finder.ElectricityRateFinder
import org.jetbrains.annotations.NotNull
import uni.dbstuff.utils.Const
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "electricity_rate")
class ElectricityRate: BaseModel() {
    @NotNull
    var begin: Date = Const.curDate()

    @NotNull
    var finish: Date = Const.curDate()

    @NotNull
    var rate: Double = 0.0

    companion object : ElectricityRateFinder()
}
