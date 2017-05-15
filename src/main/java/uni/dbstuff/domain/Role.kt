package uni.dbstuff.domain

import uni.dbstuff.domain.finder.RoleFinder
import org.jetbrains.annotations.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

/**
 * Модель объекта "Роль садовода"
 */
@Entity
@Table(name = "role")
class Role: BaseModel() {
    /**
     * Название роли
     */
    @NotNull
    var roleName: String = ""

    /**
     * Садоводы с данной ролью
     */
    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "role")
    var persons: MutableList<Person> = ArrayList()

    /**
     * Преобразует объект в читаемое строковое представление
     * @return Строковое представление объекта
     */
    override fun toString() = roleName

    companion object : RoleFinder()
}
