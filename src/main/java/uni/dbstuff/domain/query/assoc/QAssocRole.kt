package uni.dbstuff.domain.query.assoc

import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.Role
import uni.dbstuff.domain.query.QRole

/**
 * Association query bean for AssocRole.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocRole<R>(name: String, root: R) : TQAssocBean<Role,R>(name, root) {

  lateinit var ID: PLong<R>
  lateinit var roleName: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
