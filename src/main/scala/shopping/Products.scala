package shopping

case class Products(product: Option[Product], products: Seq[Product], counter: Counter) extends Pricing {
  override def price: Price = product map { p => p.price * count } getOrElse Price.Zero

  def count: Int = products.size
}

object Products {
  def apply(product: Option[Product], products: Seq[Product]): Products = {
    val selectedProducts = product match {
      case Some(p) => products filter { p => p == product }
      case None => Seq.empty
    }

    Products(product, selectedProducts, Counter(product))
  }
}
