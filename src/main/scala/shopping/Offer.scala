package shopping

sealed abstract class Offer(product: Product, items: Seq[String]) extends Pricing {
}

object Offer {
  def apply(product: Product, items: Seq[String], offerType: Option[OfferType]): Offer = {
    val ot = offerType.getOrElse(Normal)
    ot match {
      case BuyOneGetOneFree => Bogof(product, items)
      case _ => NormalPricing(product, items)
    }
  }
}

case class NormalPricing(product: Product, items: Seq[String]) extends Offer(product, items) {
  def price: Price = product.unitPrice * items.size
}

case class Bogof(product: Product, items: Seq[String]) extends Offer(product, items) {
  def price: Price = {
    val count = items.size

    val quotient =  count / 2

    val remainder = count % 2

    val quantity = if (remainder == 0) {
      quotient
    }
    else {
      quotient + 1
    }

    product.unitPrice * quantity
  }
}
