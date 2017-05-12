package uni.dbstuff.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PDouble
import io.ebean.typequery.PLong
import io.ebean.typequery.PSqlDate
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import uni.dbstuff.domain.PaymentData
import uni.dbstuff.domain.query.assoc.QAssocArea
import uni.dbstuff.domain.query.assoc.QAssocCounterData

/**
 * Query bean for PaymentData.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QPaymentData : TQRootBean<PaymentData, QPaymentData> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QPaymentData(true)
  }

  lateinit var ID: PLong<QPaymentData>
  lateinit var area: QAssocArea<QPaymentData>
  lateinit var date: PSqlDate<QPaymentData>
  lateinit var initialData: QAssocCounterData<QPaymentData>
  lateinit var finalData: QAssocCounterData<QPaymentData>
  lateinit var total: PDouble<QPaymentData>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(PaymentData::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(PaymentData::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
