package uni.dbstuff.domain.finder

import io.ebean.Finder
import uni.dbstuff.domain.CounterData
import uni.dbstuff.domain.query.QCounterData

open class CounterDataFinder : Finder<Long,CounterData> {

  val alias = QCounterData._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(CounterData::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(CounterData::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QCounterData {
     return QCounterData(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QCounterData {
     return QCounterData(db()).text()
  }
}
