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


/** Mixin trait used to indicate that a `Security` is not fungible.
  *
  * If an asset is not fungible, this means that if such an asset is lent, or placed with a custodian, the borrower or
  * custodian is obliged at the end of the loan or custody arrangement to return assets equivalent the specific asset.
  *
  * @author davidrpugh
  * @since 0.1.0
  */
trait NonFungible {
  this: Security =>

}
