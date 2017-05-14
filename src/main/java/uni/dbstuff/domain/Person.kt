package uni.dbstuff.domain


import uni.dbstuff.domain.finder.PersonFinder
import org.jetbrains.annotations.NotNull
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "person")
class Person: BaseModel() {
    @NotNull
    var firstName: String = ""

    @NotNull
    var middleName: String = ""

    @NotNull
    var lastName: String = ""

    @NotNull
    var birthday: Date = Date(0L)

    @NotNull
    var identCode: Long = 0L

    @NotNull
    var address: String = ""

    @NotNull
    var telephone: String = ""

    @ManyToOne
    var role: Role? = null

    override fun toString() = "$firstName $middleName $lastName"

    companion object : PersonFinder()

}

