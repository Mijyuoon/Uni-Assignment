package uni.dbstuff.domain

import javax.persistence.Entity
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */


@Entity
@Table(name = "role")
class Role: BaseModel() {

    var roleName: String? = null

}