package uni.dbstuff.domain

import uni.dbstuff.domain.finder.PaymentDataFinder
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

    @NotNull
    var date: Date? = null

    @NotNull
    var initialData: Double? = null

    @NotNull
    var finalData: Double? = null

    @NotNull
    var total: Double? = null

    companion object : PaymentDataFinder()
}
