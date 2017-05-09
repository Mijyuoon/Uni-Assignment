package uni.dbstuff.domain.query.assoc

import io.ebean.typequery.PDouble
import io.ebean.typequery.PLong
import io.ebean.typequery.PSqlDate
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.CounterData
import uni.dbstuff.domain.query.QCounterData

/**
 * Association query bean for AssocCounterData.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocCounterData<R>(name: String, root: R) : TQAssocBean<CounterData,R>(name, root) {

  lateinit var ID: PLong<R>
  lateinit var date: PSqlDate<R>
  lateinit var data: PDouble<R>
  lateinit var area: QAssocArea<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
