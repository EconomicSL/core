/*
Copyright (c) 2017 KAPSARC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package org.economicsl.core.prices

import play.api.libs.json.{Json, Writes}
import squants.{Quantity, Ratio}


/** Class representing a price.
  *
  * A `Price` is a ratio between some `Numeraire` and some other `Quantity`.
  * @author davidrpugh
  * @since 0.1.0
  */
case class Price[A <: Numeraire[A], B <: Quantity[B]](numeraire: A, quantity: B) extends Ratio[A, B] with Serializable {

  def base: A = numeraire

  def counter: B = quantity

  def plus(that: Price[A, B]): Price[A, B] = {
    Price(this.numeraire + that.numeraire, quantity)
  }

  def +(that: Price[A, B]): Price[A, B] = plus(that)

  def times(scalar: Double): Price[A, B] = Price(this.numeraire * scalar, quantity)

  def *(scalar: Double): Price[A, B] = times(scalar)

  /** Returns the Cost (in units of the numeriare `A`) for a quantity `that` of `B`.
    *
    * @param that Quantity
    * @return
    */
  def *(that: B): A = convertToBase(that)

}


/** Companion object for the Price value class.
  *
  * @author davidrpugh
  * @since 0.1.0
  */
object Price {

  /** Default ordering for `Price` instances is low to high based on the underlying value. */
  implicit def ordering[A <: Numeraire[A], B <: Quantity[B]]: Ordering[Price[A, B]] = new PriceOrdering[A, B]

  implicit def quantityWrites[A <: Quantity[A]]: Writes[Quantity[A]] = {
    o => Json.obj("value" -> o.value)
  }

  implicit def writes[A <: Numeraire[A], B <: Quantity[B]]: Writes[Price[A, B]] = Json.writes[Price[A, B]]

  implicit def mkOrderingOps[A <: Numeraire[A], B <: Quantity[B]](lhs: Price[A, B]): Ordering[Price[A, B]]#Ops = {
    ordering.mkOrderingOps(lhs)
  }

}


/** Default ordering for `Price` instances is low to high based on the underlying value.
  *
  * @author davidrpugh
  * @since 0.1.0
  */
class PriceOrdering[A <: Numeraire[A], B <: Quantity[B]] extends Ordering[Price[A, B]] {

  /** Instances of `Price` are compared using their underlying values.
    *
    * @param p1 some `Price` instance.
    * @param p2 another `Price` instance.
    * @return -1 if `p1` is less than `p2`, 0 if `p1` equals `p2`, 1 otherwise.
    */
  def compare(p1: Price[A, B], p2: Price[A, B]): Int = p1.numeraire compare p2.numeraire

}

