package uni.dbstuff.domain.finder

import io.ebean.Finder
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.query.QPerson

open class PersonFinder : Finder<Long,Person> {

  val alias = QPerson._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Person::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Person::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QPerson {
     return QPerson(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QPerson {
     return QPerson(db()).text()
  }
}
