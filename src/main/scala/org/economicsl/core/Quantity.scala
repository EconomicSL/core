package org.economicsl.core

/**
  * Created by pughdr on 6/18/2017.
  */
abstract class Quantity[A <: Quantity[A]] extends squants.Quantity[A] {
  self: A =>

}
