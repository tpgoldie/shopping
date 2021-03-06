package shopping

trait ProductRepository {
  def findProduct(name: String): Option[Product]
}

object ProductRepository extends ProductRepository {
  private val products = Seq(Apple(Price(60)), Orange(Price(25))) map {product => product.name.toLowerCase -> product } toMap

  override def findProduct(name: String): Option[Product] = products.get(name.toLowerCase)
}
