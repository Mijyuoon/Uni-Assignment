package uni.dbstuff.domain

import org.jetbrains.annotations.NotNull
import uni.dbstuff.domain.finder.BuildingTypeFinder
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table


/**
 * Модель объекта "Тип постройки"
 */
@Entity
@Table(name = "building_type")
class BuildingType: BaseModel() {
    /**
     * Название типа постройки
     */
    @NotNull
    var buildingTypeName: String = ""

    /**
     * Постройки данного типа
     */
    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "type")
    var buildings: MutableList<Building> = ArrayList()

    /**
     * Преобразует объект в читаемое строковое представление
     * @return Строковое представление объекта
     */
    override fun toString() = buildingTypeName

    companion object : BuildingTypeFinder()
}

