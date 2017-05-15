package uni.dbstuff.domain

import uni.dbstuff.domain.finder.BuildingFinder
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

/**
 * Модель объекта "Постройка"
 */
@Entity
@Table(name = "building")
class Building: BaseModel() {
    /**
     * Тип постройки
     */
    @ManyToOne
    var type: BuildingType? = null

    /**
     * Участок размещения постройки
     */
    @NotNull
    @ManyToOne
    var area: Area? = null

    /**
     * Дополнительные сведения
     */
    var addintionalInfo: String = ""

    companion object : BuildingFinder()
}
