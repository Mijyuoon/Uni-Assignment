package uni.dbstuff.domain

import uni.dbstuff.domain.finder.AreaFinder
import org.jetbrains.annotations.NotNull
import tornadofx.*
import javax.persistence.*

/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "area")
class Area: BaseModel() {
    @ManyToOne
    var owner: Person? = null

    @NotNull
    var number: Int = 0

    @NotNull
    var areaSize: Double? = 0.0

    @NotNull
    var cadastreNumber: Long = 0L

    @NotNull
    var counterNumber: Long = 0L

    @NotNull
    var waterSupply: Boolean = true

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "area")
    var payments: MutableList<PaymentData> = ArrayList()

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "area")
    var counters: MutableList<CounterData> = ArrayList()

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "area")
    var buildings: MutableList<Building> = ArrayList()

    override fun toString() = String.format(FX.messages["format_areaid"], number)

    companion object : AreaFinder()
}
