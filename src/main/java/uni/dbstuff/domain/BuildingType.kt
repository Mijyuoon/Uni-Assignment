package uni.dbstuff.domain

import org.jetbrains.annotations.NotNull
import uni.dbstuff.domain.finder.BuildingTypeFinder
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table


/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "building_type")
class BuildingType: BaseModel() {
    @NotNull
    var buildingTypeName: String = ""

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "type")
    var buildings: MutableList<Building> = ArrayList()

    override fun toString() = buildingTypeName

    companion object : BuildingTypeFinder()
}

