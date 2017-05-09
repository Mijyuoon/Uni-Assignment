package uni.dbstuff.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.Role

/**
 * Query bean for Role.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QRole : TQRootBean<Role, QRole> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QRole(true)
  }

  lateinit var ID: PLong<QRole>
  lateinit var roleName: PString<QRole>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Role::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Role::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
