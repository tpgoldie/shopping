package shopping

case class Checkout(products: ProductRepository) {
  def price(items: Seq[String], productsOffers: ProductOffersRepository) : Price = {
    val currentProducts = items.groupBy(_.toLowerCase)

    val appleProduct = products.findProduct(Apple.Key)
    val p1 = ProductsPricer(appleProduct, currentProducts, productsOffers).price

    val orangeProduct = products.findProduct(Orange.Key)
    val p2 = ProductsPricer(orangeProduct, currentProducts, productsOffers).price

    p1 + p2
  }
}

object Checkout {
  def main (args: Array[String]) {
    val productRepository = ProductRepository
    val productOffers = ProductOffers(Map(productRepository.findProduct(Apple.Key).get -> BuyOneGetOneFreeType,
      productRepository.findProduct(Orange.Key).get -> ThreeForTwoType))

    val checkout = Checkout(productRepository)
    checkout.price(args.toList, productOffers)
  }
}
