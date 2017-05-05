package uni.dbstuff.domain

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
class CounterData: BaseModel(){
    var date: Date? = null

    var data: Double? = null

    @NotNull
    @ManyToOne
    var area: Area? = null
}