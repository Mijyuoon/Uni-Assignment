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
@Table(name = "payment_data")
class PaymentData: BaseModel(){

    @NotNull
    @ManyToOne
    var area: Area? = null

    var date: Date? = null

    var firstCounterData: CounterData? = null

    var secondCounterData: CounterData? = null

    var total: Double? = null
}
