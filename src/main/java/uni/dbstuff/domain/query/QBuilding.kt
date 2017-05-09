package uni.dbstuff.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.Building
import uni.dbstuff.domain.query.assoc.QAssocArea
import uni.dbstuff.domain.query.assoc.QAssocBuildingType

/**
 * Query bean for Building.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QBuilding : TQRootBean<Building, QBuilding> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QBuilding(true)
  }

  lateinit var ID: PLong<QBuilding>
  lateinit var type: QAssocBuildingType<QBuilding>
  lateinit var area: QAssocArea<QBuilding>
  lateinit var addintionalInfo: PString<QBuilding>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Building::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Building::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
