package org.economicsl.core.prices

import squants.{Dimension, PrimaryUnit, SiUnit, UnitOfMeasure}


class Money private(value: Double)(unit: Currency) extends Numeraire[Money](value)(unit) {

  def dimension: Dimension[Money] = Money

}


object Money extends Dimension[Money] {

  def apply(value: Double)(implicit unit: Currency): Money = {
    new Money(value)(unit)
  }

  def name: String = "Money"

  def units: Set[UnitOfMeasure[Money]] = ???

  def primaryUnit: UnitOfMeasure[Money] with PrimaryUnit = ???

  def siUnit: UnitOfMeasure[Money] with SiUnit = ???

}