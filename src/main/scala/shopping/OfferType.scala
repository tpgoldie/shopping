package shopping

sealed abstract class OfferType(val name: String) {
}

case object Normal extends OfferType("normal pricing")

case object BuyOneGetOneFree extends OfferType("buy one get one frees")

