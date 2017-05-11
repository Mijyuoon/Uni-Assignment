package uni.dbstuff.domain

import uni.dbstuff.domain.finder.RoleFinder
import org.jetbrains.annotations.*
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */


@Entity
@Table(name = "role")
class Role(name:String?): BaseModel() {
    @NotNull
    var roleName: String? = name

    override fun toString(): String {
        return "roleName:$roleName"
    }

    companion object : RoleFinder()
}
