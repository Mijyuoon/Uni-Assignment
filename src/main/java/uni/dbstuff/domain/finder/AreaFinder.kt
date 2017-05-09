package uni.dbstuff.domain.finder

import io.ebean.Finder
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.query.QArea

open class AreaFinder : Finder<Long,Area> {

  val alias = QArea._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Area::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Area::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QArea {
     return QArea(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QArea {
     return QArea(db()).text()
  }
}
