package uni.dbstuff.domain.finder

import io.ebean.Finder
import uni.dbstuff.domain.PaymentData
import uni.dbstuff.domain.query.QPaymentData

open class PaymentDataFinder : Finder<Long,PaymentData> {

  val alias = QPaymentData._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(PaymentData::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(PaymentData::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QPaymentData {
     return QPaymentData(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QPaymentData {
     return QPaymentData(db()).text()
  }
}
