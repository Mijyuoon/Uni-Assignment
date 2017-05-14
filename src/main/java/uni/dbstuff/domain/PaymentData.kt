package uni.dbstuff.domain

import uni.dbstuff.domain.finder.PaymentDataFinder
import org.jetbrains.annotations.NotNull
import org.w3c.dom.css.Counter
import uni.dbstuff.utils.Const
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "payment_data")
class PaymentData: BaseModel() {
    @ManyToOne
    var area: Area? = null

    @NotNull
    var date: Date = Const.curDate()

    @ManyToOne
    var initialData: Double = 0.0

    @ManyToOne
    var finalData: Double = 0.0

    @NotNull
    var total: Double = 0.0

    companion object : PaymentDataFinder()
}
