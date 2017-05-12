package uni.dbstuff.domain.query.assoc

import io.ebean.typequery.PBoolean
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.Area
import uni.dbstuff.domain.query.QArea

/**
 * Association query bean for AssocArea.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocArea<R>(name: String, root: R) : TQAssocBean<Area,R>(name, root) {

  lateinit var ID: PLong<R>
  lateinit var owner: QAssocPerson<R>
  lateinit var number: PInteger<R>
  lateinit var area: PInteger<R>
  lateinit var cadastreNumber: PLong<R>
  lateinit var waterSupply: PBoolean<R>
  lateinit var electricityCounterID: PLong<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
