package uni.dbstuff.domain

import uni.dbstuff.domain.finder.RoleFinder
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */


@Entity
@Table(name = "role")
class Role: BaseModel() {
    @NotNull
    var roleName: String? = null

    companion object : RoleFinder()
}
