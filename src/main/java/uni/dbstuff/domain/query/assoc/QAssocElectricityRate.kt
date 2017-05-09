package uni.dbstuff.domain.query.assoc

import io.ebean.typequery.PDouble
import io.ebean.typequery.PLong
import io.ebean.typequery.PSqlDate
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.ElectricityRate
import uni.dbstuff.domain.query.QElectricityRate

/**
 * Association query bean for AssocElectricityRate.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocElectricityRate<R>(name: String, root: R) : TQAssocBean<ElectricityRate,R>(name, root) {

  lateinit var ID: PLong<R>
  lateinit var begin: PSqlDate<R>
  lateinit var finish: PSqlDate<R>
  lateinit var rate: PDouble<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
