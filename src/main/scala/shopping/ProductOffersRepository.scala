package shopping

trait ProductOffersRepository {
  def findOffer(product: Product): Option[OfferType]
}

case class ProductOffers(productOffers: Map[Product, OfferType]) extends ProductOffersRepository {
  override def findOffer(product: Product): Option[OfferType] = productOffers.get(product)
}