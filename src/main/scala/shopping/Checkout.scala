package shopping

case class Checkout(products: ProductCatalogue) {
  def price(items: Seq[String], productsOffers: Map[Product, OfferType]) : Price = {
    val currentProducts = items.groupBy(_.toLowerCase)

    val appleProduct = products.findProduct(Apple.Key)
    val p1 = ProductsPricer(appleProduct, currentProducts, productsOffers).price

    val orangeProduct = products.findProduct(Orange.Key)
    val p2 = ProductsPricer(orangeProduct, currentProducts, productsOffers).price

    p1 + p2
  }

}
