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
package org.economicsl.core

import play.api.libs.json.{Json, Writes}


/** Value class representing prices.
  *
  * @author davidrpugh
  * @since 0.1.0
  */
case class Price(value: Long) extends AnyVal {

  def + (that: Price): Price = {
    Price(value + that.value)
  }

  def - (that: Price): Price = {
    Price(value - that.value)
  }

  def * (x: Long): Price = {
    Price(value * x)
  }

  def * (quantity: Quantity): Currency = {
    value * quantity.value
  }

  def / (x: Long): Price = {
    Price(value / x)
  }

  def isMultipleOf(tickSize: Currency): Boolean = {
    value % tickSize == 0
  }

}


/** Companion object for the Price value class.
  *
  * @author davidrpugh
  * @since 0.1.0
  */
object Price {

  /** Default ordering for `Price` instances is low to high based on the underlying value. */
  implicit val ordering: Ordering[Price] = PriceOrdering

  implicit val writes: Writes[Price] = Json.writes[Price]

  implicit def mkOrderingOps(lhs: Price): PriceOrdering.Ops = PriceOrdering.mkOrderingOps(lhs)

  val Zero: Price = Price(0L)

  val MaxValue: Price = Price(Long.MaxValue)

  val MinValue: Price = Price(1L)

  /** Computes a price that is the largest multiple of a tick size less than some upper bound. */
  def largestMultipleOf(tickSize: Currency, lessThan: Price): Price = {
    (lessThan / tickSize) * tickSize
  }

  /** Computes a price that is the smallest multiple of a tick size greater than some lower bound. */
  def smallestMultipleOf(tickSize: Currency, greaterThan: Price): Price = {
    ((greaterThan / tickSize) + MinValue) * tickSize
  }

}


/** Default ordering for `Price` instances is low to high based on the underlying value.
  *
  * @author davidrpugh
  * @since 0.1.0
  */
object PriceOrdering extends Ordering[Price] {

  /** Instances of `Price` are compared using their underlying values.
    *
    * @param p1 some `Price` instance.
    * @param p2 another `Price` instance.
    * @return -1 if `p1` is less than `p2`, 0 if `p1` equals `p2`, 1 otherwise.
    */
  def compare(p1: Price, p2: Price): Int = p1.value compare p2.value

}

