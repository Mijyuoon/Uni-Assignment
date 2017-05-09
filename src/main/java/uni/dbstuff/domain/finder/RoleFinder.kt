package uni.dbstuff.domain.finder

import io.ebean.Finder
import uni.dbstuff.domain.Role
import uni.dbstuff.domain.query.QRole

open class RoleFinder : Finder<Long,Role> {

  val alias = QRole._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Role::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Role::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QRole {
     return QRole(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QRole {
     return QRole(db()).text()
  }
}
