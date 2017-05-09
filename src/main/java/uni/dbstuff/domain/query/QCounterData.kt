package uni.dbstuff.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PDouble
import io.ebean.typequery.PLong
import io.ebean.typequery.PSqlDate
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.CounterData
import uni.dbstuff.domain.query.assoc.QAssocArea

/**
 * Query bean for CounterData.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QCounterData : TQRootBean<CounterData, QCounterData> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QCounterData(true)
  }

  lateinit var ID: PLong<QCounterData>
  lateinit var date: PSqlDate<QCounterData>
  lateinit var data: PDouble<QCounterData>
  lateinit var area: QAssocArea<QCounterData>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(CounterData::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(CounterData::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
