package uni.dbstuff.domain

import uni.dbstuff.domain.finder.ElectricityRateFinder
import org.jetbrains.annotations.NotNull
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
    var begin: Date? = null

    @NotNull
    var finish: Date? = null

    @NotNull
    var rate: Double? = null

    companion object : ElectricityRateFinder()
}
