package uni.dbstuff.domain.finder

import io.ebean.Finder
import uni.dbstuff.domain.BuildingType
import uni.dbstuff.domain.query.QBuildingType

open class BuildingTypeFinder : Finder<Long,BuildingType> {

  val alias = QBuildingType._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(BuildingType::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(BuildingType::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QBuildingType {
     return QBuildingType(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QBuildingType {
     return QBuildingType(db()).text()
  }
}
