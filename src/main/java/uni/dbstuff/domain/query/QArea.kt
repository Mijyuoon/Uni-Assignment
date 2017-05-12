package uni.dbstuff.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PBoolean
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.query.assoc.QAssocPerson

/**
 * Query bean for Area.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QArea : TQRootBean<Area, QArea> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QArea(true)
  }

  lateinit var ID: PLong<QArea>
  lateinit var owner: QAssocPerson<QArea>
  lateinit var number: PInteger<QArea>
  lateinit var area: PInteger<QArea>
  lateinit var cadastreNumber: PLong<QArea>
  lateinit var waterSupply: PBoolean<QArea>
  lateinit var electricityCounterID: PLong<QArea>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Area::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Area::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
