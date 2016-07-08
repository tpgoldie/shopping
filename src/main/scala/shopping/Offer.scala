package shopping

sealed abstract class Offer(product: Product, items: Seq[String]) extends Pricing {
}

object Offer {
  def apply(product: Product, items: Seq[String], offerType: Option[OfferType]): Offer = {
    val ot = offerType.getOrElse(Normal)
    ot match {
      case BuyOneGetOneFreeType => BuyOneGetOneFree(product, items)
      case _ => NormalPricing(product, items)
    }
  }
}

case class NormalPricing(product: Product, items: Seq[String]) extends Offer(product, items) {
  def price: Price = product.unitPrice * items.size
}

case class BuyOneGetOneFree(product: Product, items: Seq[String]) extends Offer(product, items) {
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

case class ThreeForTwo(product: Product, items: Seq[String]) extends Offer(product, items) {
  def price: Price = {
    val count = items.size

    val divisor = 3
    val quotient =  count / divisor

    val remainder = count % divisor

    val quantity = (divisor - 1) * quotient + (if (remainder == 0) { 0 } else { remainder })

    product.unitPrice * quantity
  }
}
