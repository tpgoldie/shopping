package shopping

import shopping.Price.Zero

case class Checkout(products: Products) {
  def price(items: Seq[String]) : Price = {
    val found = items map { item => products.findProduct(item) } flatten
    val prices = found map { _.price }

    if (prices.isEmpty) { Zero }
    else {
      prices.reduceLeft(_ + _)
    }
  }
}
