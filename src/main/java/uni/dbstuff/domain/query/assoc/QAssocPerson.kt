package uni.dbstuff.domain.query.assoc

import io.ebean.typequery.PLong
import io.ebean.typequery.PSqlDate
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.Person
import uni.dbstuff.domain.query.QPerson

/**
 * Association query bean for AssocPerson.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocPerson<R>(name: String, root: R) : TQAssocBean<Person,R>(name, root) {

  lateinit var ID: PLong<R>
  lateinit var firstName: PString<R>
  lateinit var middleName: PString<R>
  lateinit var lastName: PString<R>
  lateinit var city: PString<R>
  lateinit var birthday: PSqlDate<R>
  lateinit var identCode: PString<R>
  lateinit var address: PString<R>
  lateinit var telephone: PString<R>
  lateinit var personeRole: QAssocRole<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
