package uni.dbstuff.domain

import uni.dbstuff.domain.finder.AreaFinder
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "area")
class Area: BaseModel() {
    @NotNull
    @ManyToOne
    var owner: Person? = null

    @NotNull
    var number: Int? = 0

    @NotNull
    var area: Int? = 0

    @NotNull
    var cadastreNumber: Long? = 0

    @NotNull
    var waterSupply: Boolean? = true

    @NotNull
    var electricityCounterID: Long? =0

    companion object : AreaFinder()
}
