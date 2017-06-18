package org.economicsl.core.prices

import play.api.libs.json.{Json, Writes}
import squants.{Quantity, UnitOfMeasure}


/** Abstract class representing a numeraire.
  *
  * @param value
  * @param unit
  * @tparam A
  * @note See the [[https://en.wikipedia.org/wiki/Num%C3%A9raire wikipedia entry]] for more details.
  */
abstract class Numeraire[A <: Numeraire[A]](val value: Double)(val unit: UnitOfMeasure[A]) extends Quantity[A] {
  self: A =>



}


object Numeraire {

  implicit def unitOfMeasureWrites[A <: Quantity[A]]: Writes[UnitOfMeasure[A]] = {
    o => Json.obj("symbol" -> o.symbol)
  }

  implicit def writes[A <: Numeraire[A]]: Writes[Numeraire[A]] = {
    o => Json.obj(
      "value" -> o.value,
      "unit" -> o.unit
    )
  }

}
