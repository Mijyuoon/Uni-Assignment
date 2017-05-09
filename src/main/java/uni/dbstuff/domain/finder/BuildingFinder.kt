package uni.dbstuff.domain.finder

import io.ebean.Finder
import uni.dbstuff.domain.Building
import uni.dbstuff.domain.query.QBuilding

open class BuildingFinder : Finder<Long,Building> {

  val alias = QBuilding._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Building::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Building::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QBuilding {
     return QBuilding(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QBuilding {
     return QBuilding(db()).text()
  }
}
