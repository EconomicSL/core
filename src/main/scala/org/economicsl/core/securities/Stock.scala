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
package org.economicsl.core.securities
import java.util.UUID

import play.api.libs.json.{JsValue, Json, Writes}


/** Base trait for modeling stock.
  *
  * @note See [[https://en.wikipedia.org/wiki/Stock wikipedia entry]] for details.
  * @author davidrpugh
  * @since 0.1.0
  */
trait Stock extends Security with Fungible {

  /** Sub-types of `Stock` should be uniquely identified by their respective ticker symbols. */
  def ticker: String

  lazy val uuid: UUID = UUID.nameUUIDFromBytes(ticker.getBytes)

}


object Stock {

  implicit def writes[T <: Stock]: Writes[T] = new Writes[T] {
    def writes(o: T): JsValue = Json.obj(
      "ticker" -> o.ticker,
      "uuid" -> o.uuid
    )
  }

}
