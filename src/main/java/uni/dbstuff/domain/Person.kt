package uni.dbstuff.domain

import uni.dbstuff.domain.finder.PersonFinder
import org.jetbrains.annotations.NotNull
import uni.dbstuff.utils.Const
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Модель объекта "Садовод"
 */
@Entity
@Table(name = "person")
class Person: BaseModel() {
    /**
     * Имя
     */
    @NotNull
    var firstName: String = ""

    /**
     * Отчество
     */
    @NotNull
    var middleName: String = ""

    /**
     * Фамилия
     */
    @NotNull
    var lastName: String = ""

    /**
     * Дата рождения
     */
    @NotNull
    var birthday: Date = Const.curDate()

    /**
     * ИНН
     */
    @NotNull
    var identCode: Long = 0L

    /**
     * Адрес
     */
    @NotNull
    var address: String = ""

    /**
     * Номер телефона
     */
    @NotNull
    var telephone: String = ""

    /**
     * Роль садовода
     */
    @ManyToOne
    var role: Role? = null

    /**
     * Преобразует объект в читаемое строковое представление
     * @return Строковое представление объекта
     */
    override fun toString() = "$firstName $middleName $lastName"

    companion object : PersonFinder()

}

