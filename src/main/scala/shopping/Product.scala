package shopping

sealed class Product(val name: String, val price: Price) {
}

case class Apple(override val price: Price) extends Product("apple", price)

case class Orange(override val price: Price) extends Product("orange", price)
