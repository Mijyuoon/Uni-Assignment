package uni.dbstuff.domain

import uni.dbstuff.domain.finder.RoleFinder
import org.jetbrains.annotations.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

/**
 * Created by Max on 5/5/2017.
 */


@Entity
@Table(name = "role")
class Role: BaseModel() {
    @NotNull
    var roleName: String = ""

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "role")
    var persons: MutableList<Person> = ArrayList()

    override fun toString() = roleName

    companion object : RoleFinder()
}
