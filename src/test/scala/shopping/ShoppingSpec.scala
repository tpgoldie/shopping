package shopping

import org.scalatest.{GivenWhenThen, FunSpec, MustMatchers}

abstract class ShoppingSpec extends FunSpec with MustMatchers with GivenWhenThen {
  val products = ProductCatalogue

  def productsOffers: Map[Product, OfferType] = Seq(Apple.Key, Orange.Key) map { key => products.findProduct(key).get -> Normal } toMap
}
