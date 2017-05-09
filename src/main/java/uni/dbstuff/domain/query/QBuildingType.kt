package uni.dbstuff.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.BuildingType

/**
 * Query bean for BuildingType.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QBuildingType : TQRootBean<BuildingType, QBuildingType> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QBuildingType(true)
  }

  lateinit var ID: PLong<QBuildingType>
  lateinit var buildingTypeName: PString<QBuildingType>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(BuildingType::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(BuildingType::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
