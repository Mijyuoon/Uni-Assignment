package uni.dbstuff.domain

import uni.dbstuff.domain.finder.BuildingFinder
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "building")
class Building: BaseModel() {
    @ManyToOne
    var type: BuildingType? = null

    @NotNull
    @ManyToOne
    var area: Area? = null

    var addintionalInfo: String? = null

    companion object : BuildingFinder()
}
