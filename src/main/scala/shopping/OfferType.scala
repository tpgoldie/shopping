package shopping

sealed abstract class OfferType(val name: String) {
}

case object Normal extends OfferType("normal pricing")

case object BuyOneGetOneFreeType extends OfferType("buy one get one free")
case object ThreeForTwoType extends OfferType("three for two")

