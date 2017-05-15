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
 * Модель объекта "Оплата за электричество"
 */
@Entity
@Table(name = "payment_data")
class PaymentData: BaseModel() {
    /**
     * Оплативший участок
     */
    @ManyToOne
    var area: Area? = null

    /**
     * Дата оплаты
     */
    @NotNull
    var date: Date = Const.curDate()

    /**
     * Начальные показания счётчика
     */
    @ManyToOne
    var initialData: Double = 0.0

    /**
     * Конечные показания счётчика
     */
    @ManyToOne
    var finalData: Double = 0.0

    /**
     * Сумма оплаты
     */
    @NotNull
    var total: Double = 0.0

    companion object : PaymentDataFinder()
}
