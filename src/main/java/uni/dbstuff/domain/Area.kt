package uni.dbstuff.domain

import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "area")
class Area: BaseModel(){

    @NotNull
    @ManyToOne
    var owner: Person? = null

    var number: Int? = 0

    var space: Int? = 0

    var cadastreNumber: Long? = 0

    var waterSupply: Boolean? = true

    var electricityCounterNumber: Long? =0


}