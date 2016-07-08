package shopping

case class ProductsPricer(product: Option[Product], items: Map[String, Seq[String]], productOffers: ProductOffersRepository) {
  private def filterItems(product: Product) = items.get(product.name)

  private val selectedItems = product match {
    case Some(p) => items.getOrElse(p.name, Seq.empty)
    case None => Seq.empty
  }

  private def calculatePrice(product: Product): Price = Offer(product, selectedItems, productOffers.findOffer(product)).price

  val price = product.fold(Price.Zero)(calculatePrice)

}
