import org.economicsl.core.Quantity
import org.economicsl.core.prices.{Numeraire, Price}
import squants.{Dimension, UnitOfMeasure}


class Sugar(value: Double)(implicit unit: UnitOfMeasure[Sugar]) extends Numeraire[Sugar](value)(unit) {

  def dimension: Dimension[Sugar] = ???

}


object Sugar {

  def apply(value: Double)(implicit unit: UnitOfMeasure[Sugar]): Sugar = new Sugar(value)(unit)

  implicit val unit: UnitOfMeasure[Sugar] = new UnitOfMeasure[Sugar] {

    def apply[N](n: N)(implicit num: Numeric[N]): Sugar = Sugar(num.toDouble(n))(this)

    protected def converterFrom = ???

    val symbol: String = "Sugar"

    protected def converterTo = ???


  }

}


case class Spice(value: Double)(implicit val unit: UnitOfMeasure[Spice]) extends Quantity[Spice] {

  def dimension: Dimension[Spice] = ???

}


object Spice {

  implicit val unit: UnitOfMeasure[Spice] = new UnitOfMeasure[Spice] {

    def apply[N](n: N)(implicit num: Numeric[N]): Spice = Spice(num.toDouble(n))(this)

    protected def converterFrom = ???

    val symbol: String = "Spice"

    protected def converterTo = ???


  }

}

val sugar = Sugar(20)

val spice = Spice(10)

val price = Price(sugar, spice)

val cost = price * Spice(30)