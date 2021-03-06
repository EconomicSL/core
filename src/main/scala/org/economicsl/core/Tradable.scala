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

import java.util.UUID

import play.api.libs.json.{JsValue, Json, Writes}


/** Trait used to indicate that an object can be traded via an auction.
  *
  * @author davidrpugh
  * @since 0.1.0
  */
trait Tradable extends Serializable {

  /** Each `Tradable` must defined a unique identifier.
    *
    * @note Depending on desired usage, this identifier might be unique for each instance of some type of `Tradable`,
    *       or all instances of a particular type of `Tradable` might share a common identifier.
    */
  def uuid: UUID

}


object Tradable {

  implicit def writes[T <: Tradable]: Writes[T] = new Writes[T] {
    def writes(o: T): JsValue = Json.obj(
      "uuid" -> o.uuid
    )
  }

}