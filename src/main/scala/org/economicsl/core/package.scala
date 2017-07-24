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
package org.economicsl


package object core {

  type Currency = Long

  /** Classes representing discrete and continuous quantities. */
  sealed abstract class Quantity[@specialized (Long, Double) +T](implicit ev: T => Double) {

    def value: T

  }

  final case class DiscreteQuantity(value: Long) extends Quantity[Long]

  final case class ContinuousQuantity(value: Double) extends Quantity[Double]

}
