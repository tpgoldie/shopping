package shopping

case class ProductsPricer(product: Option[Product], items: Map[String, Seq[String]], productsOffers: Map[Product, OfferType]) {
  private def filterItems(product: Product) = items.get(product.name)

  private val selectedItems = product match {
    case Some(p) => items.getOrElse(p.name, Seq.empty)
    case None => Seq.empty
  }

  private def calculatePrice(product: Product): Price = Offer(product, selectedItems, productsOffers.get(product)).price

  val price = product.fold(Price.Zero)(calculatePrice)

}
