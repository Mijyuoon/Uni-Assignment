package uni.dbstuff.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PDouble
import io.ebean.typequery.PLong
import io.ebean.typequery.PSqlDate
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.ElectricityRate

/**
 * Query bean for ElectricityRate.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QElectricityRate : TQRootBean<ElectricityRate, QElectricityRate> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QElectricityRate(true)
  }

  lateinit var ID: PLong<QElectricityRate>
  lateinit var begin: PSqlDate<QElectricityRate>
  lateinit var finish: PSqlDate<QElectricityRate>
  lateinit var rate: PDouble<QElectricityRate>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(ElectricityRate::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(ElectricityRate::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
