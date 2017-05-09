package uni.dbstuff.domain.query.assoc

import io.ebean.typequery.PDouble
import io.ebean.typequery.PLong
import io.ebean.typequery.PSqlDate
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.PaymentData
import uni.dbstuff.domain.query.QPaymentData

/**
 * Association query bean for AssocPaymentData.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocPaymentData<R>(name: String, root: R) : TQAssocBean<PaymentData,R>(name, root) {

  lateinit var ID: PLong<R>
  lateinit var area: QAssocArea<R>
  lateinit var date: PSqlDate<R>
  lateinit var firstCounterData: QAssocCounterData<R>
  lateinit var secondCounterData: QAssocCounterData<R>
  lateinit var total: PDouble<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
