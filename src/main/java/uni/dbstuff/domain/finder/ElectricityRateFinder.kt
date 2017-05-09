package uni.dbstuff.domain.finder

import io.ebean.Finder
import uni.dbstuff.domain.ElectricityRate
import uni.dbstuff.domain.query.QElectricityRate

open class ElectricityRateFinder : Finder<Long,ElectricityRate> {

  val alias = QElectricityRate._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(ElectricityRate::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(ElectricityRate::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QElectricityRate {
     return QElectricityRate(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QElectricityRate {
     return QElectricityRate(db()).text()
  }
}
