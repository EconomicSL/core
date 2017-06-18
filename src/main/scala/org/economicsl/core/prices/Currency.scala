package org.economicsl.core.prices

import squants.UnitOfMeasure


class Currency(val symbol: String) extends UnitOfMeasure[Money] {

  def apply[N](n: N)(implicit num: Numeric[N]): Money = Money(num.toDouble(n))(this)

  protected def converterFrom: (Double) => Double = ???

  protected def converterTo: (Double) => Double = ???

}
