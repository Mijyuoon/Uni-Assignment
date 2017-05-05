package uni.dbstuff.domain

import javax.persistence.Entity
import javax.persistence.Table


/**
 * Created by Max on 5/5/2017.
 */

@Entity
@Table(name = "building_type")
class BuildingType: BaseModel(){

    var buildingTypeName: String? = null
}

