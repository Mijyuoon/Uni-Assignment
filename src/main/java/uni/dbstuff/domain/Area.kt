package uni.dbstuff.domain

import uni.dbstuff.domain.finder.AreaFinder
import org.jetbrains.annotations.NotNull
import tornadofx.*
import javax.persistence.*

/**
 * Модель объекта "Участок"
 */
@Entity
@Table(name = "area")
class Area: BaseModel() {
    /**
     * Владелец участка
     */
    @ManyToOne
    var owner: Person? = null

    /**
     * Номер участка
     */
    @NotNull
    var number: Int = 0

    /**
     * Полщадь
     */
    @NotNull
    var areaSize: Double = 0.0

    /**
     * Кадастровый номер
     */
    @NotNull
    var cadastreNumber: Long = 0L

    /**
     * Номер электросчётчика
     */
    @NotNull
    var counterNumber: Long = 0L

    /**
     * Наличие водоснабжения
     */
    @NotNull
    var waterSupply: Boolean = true

    /**
     * Оплата за электричество для данного участка
     */
    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "area")
    var payments: MutableList<PaymentData> = ArrayList()

    /**
     * Показания электросчётчика для данного участка
     */
    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "area")
    var counters: MutableList<CounterData> = ArrayList()

    /**
     * Постройки на данном участке
     */
    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "area")
    var buildings: MutableList<Building> = ArrayList()

    /**
     * Преобразует объект в читаемое строковое представление
     * @return Строковое представление объекта
     */
    override fun toString() = String.format(FX.messages["format_areaid"], number)

    companion object : AreaFinder()
}
