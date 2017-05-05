package uni.dbstuff.domain


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
class Person: BaseModel(){

    @NotNull
    var firstName: String? = null

    var secondName: String? = null

    var lastName: String? = null

    var city: String? = null

    var birthday: Date? = null

    var address: String? = null

    var telephone: String? = null

    @ManyToOne()
    var personeRole: Role? = null

}

