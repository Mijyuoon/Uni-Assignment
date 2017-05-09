package uni.dbstuff.domain.query.assoc

import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.BuildingType
import uni.dbstuff.domain.query.QBuildingType

/**
 * Association query bean for AssocBuildingType.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocBuildingType<R>(name: String, root: R) : TQAssocBean<BuildingType,R>(name, root) {

  lateinit var ID: PLong<R>
  lateinit var buildingTypeName: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
