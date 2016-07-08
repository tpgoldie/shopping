package shopping

sealed abstract class Product(val name: String, val price: Price) extends UnitCost {
}

case class Apple(override val unitPrice: Price) extends Product(Apple.Key, unitPrice)

object Apple {
  val Key = "apple"
}

case class Orange(override val unitPrice: Price) extends Product(Orange.Key, unitPrice)

object Orange {
  val Key = "orange"
}