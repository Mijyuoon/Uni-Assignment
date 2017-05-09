package uni.dbstuff.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PLong
import io.ebean.typequery.PSqlDate
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.query.assoc.QAssocRole

/**
 * Query bean for Person.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QPerson : TQRootBean<Person, QPerson> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QPerson(true)
  }

  lateinit var ID: PLong<QPerson>
  lateinit var firstName: PString<QPerson>
  lateinit var secondName: PString<QPerson>
  lateinit var lastName: PString<QPerson>
  lateinit var city: PString<QPerson>
  lateinit var birthday: PSqlDate<QPerson>
  lateinit var address: PString<QPerson>
  lateinit var telephone: PString<QPerson>
  lateinit var personeRole: QAssocRole<QPerson>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Person::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Person::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
