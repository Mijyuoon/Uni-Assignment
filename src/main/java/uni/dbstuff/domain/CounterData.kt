package uni.dbstuff.domain

import uni.dbstuff.domain.finder.CounterDataFinder
import org.jetbrains.annotations.NotNull
import uni.dbstuff.utils.Const
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Модель объекта "Показания электросчётчика"
 */
@Entity
@Table(name = "counter_data")
class CounterData: BaseModel() {
    /**
     * Дата снятия показаний
     */
    @NotNull
    var date: Date = Const.curDate()

    /**
     * Показания счётчика
     */
    @NotNull
    var value: Double = 0.0

    /**
     * Участок размещения счётчика
     */
    @ManyToOne
    var area: Area? = null

    companion object : CounterDataFinder()
}
