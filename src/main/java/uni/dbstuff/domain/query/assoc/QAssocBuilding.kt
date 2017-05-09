package uni.dbstuff.domain.query.assoc

import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.Building
import uni.dbstuff.domain.query.QBuilding

/**
 * Association query bean for AssocBuilding.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocBuilding<R>(name: String, root: R) : TQAssocBean<Building,R>(name, root) {

  lateinit var ID: PLong<R>
  lateinit var type: QAssocBuildingType<R>
  lateinit var area: QAssocArea<R>
  lateinit var addintionalInfo: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
