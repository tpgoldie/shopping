package shopping

import org.scalatest.{GivenWhenThen, FunSpec, MustMatchers}

abstract class ShoppingSpec extends FunSpec with MustMatchers with GivenWhenThen {
  val products = ProductRepository

  def productOffers: ProductOffersRepository = ProductOffers(Seq(Apple.Key, Orange.Key) map { key => products.findProduct(key).get -> Normal } toMap)
}
