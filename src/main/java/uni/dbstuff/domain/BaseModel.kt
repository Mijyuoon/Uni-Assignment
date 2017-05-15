package uni.dbstuff.domain

import io.ebean.Model
import org.jetbrains.annotations.NotNull
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * Базовый класс моделей объектов
 */
@MappedSuperclass
abstract class BaseModel: Model() {
    /**
     * Уникальный код объекта
     */
    @Id
    @NotNull
    var ID: Long = 0
}