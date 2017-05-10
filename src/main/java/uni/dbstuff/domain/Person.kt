package uni.dbstuff.domain


import uni.dbstuff.domain.finder.PersonFinder
import org.jetbrains.annotations.NotNull
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table


@Entity
@Table(name = "person")
class Person(firstName: String, middleName: String, lastName: String) : BaseModel() {
    @NotNull
    var firstName: String? = firstName

    @NotNull
    var middleName: String? = middleName

    @NotNull
    var lastName: String? = lastName

    @NotNull
    var city: String? = null

    @NotNull
    var birthday: Date? = null

    @NotNull
    var identCode: String? = null

    @NotNull
    var address: String? = null

    @NotNull
    var telephone: String? = null

    @ManyToOne()
    var personeRole: Role? = null

    companion object : PersonFinder()

}

