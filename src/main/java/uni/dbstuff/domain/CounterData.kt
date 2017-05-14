package uni.dbstuff.domain

import uni.dbstuff.domain.finder.CounterDataFinder
import org.jetbrains.annotations.NotNull
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "counter_data")
class CounterData: BaseModel() {
    @NotNull
    var date: Date = Date(0L)

    @NotNull
    var value: Double = 0.0

    @ManyToOne
    var area: Area? = null

    companion object : CounterDataFinder()
}
