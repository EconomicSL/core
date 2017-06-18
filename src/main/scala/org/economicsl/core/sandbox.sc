import org.economicsl.core.prices.{Numeraire, Price}
import squants.{Dimension, Quantity, UnitOfMeasure}


class Apple(value: Double)(implicit unit: UnitOfMeasure[Apple]) extends Numeraire[Apple](value)(unit) {

  def dimension: Dimension[Apple] = ???

}


object Apple {

  def apply(value: Double)(implicit unit: UnitOfMeasure[Apple]): Apple = new Apple(value)(unit)

  implicit val unit: UnitOfMeasure[Apple] = new UnitOfMeasure[Apple] {

    def apply[N](n: N)(implicit num: Numeric[N]): Apple = Apple(num.toDouble(n))(this)

    protected def converterFrom = ???

    val symbol: String = "Apple"

    protected def converterTo = ???


  }

}


case class Orange(value: Double)(implicit val unit: UnitOfMeasure[Orange]) extends Quantity[Orange] {

  def dimension: Dimension[Orange] = ???

}


object Orange {

  implicit val unit: UnitOfMeasure[Orange] = new UnitOfMeasure[Orange] {

    def apply[N](n: N)(implicit num: Numeric[N]): Orange = Orange(num.toDouble(n))(this)

    protected def converterFrom = ???

    val symbol: String = "Orange"

    protected def converterTo = ???


  }

}

val apple = Apple(20)

val orange = Orange(10)

val price = Price(apple, orange)

val cost = price * Orange(30)