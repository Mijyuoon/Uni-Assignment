package uni.dbstuff.domain

import io.ebean.Model
import org.jetbrains.annotations.NotNull
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * Created by Max on 5/5/2017.
 */

@MappedSuperclass
abstract class BaseModel: Model() {
    @Id
    @NotNull
    var ID: Long = 0
}