package uni.dbstuff.domain


import uni.dbstuff.domain.finder.PersonFinder
import org.jetbrains.annotations.NotNull
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Created by Max on 5/4/2017.
 */

@Entity
@Table(name = "person")
class Person: BaseModel() {
    @NotNull
    var firstName: String? = null

    @NotNull
    var middleName: String? = null

    @NotNull
    var lastName: String? = null

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

