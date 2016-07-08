package shopping

class OffersSpec extends ShoppingSpec {
  override def productsOffers = Map(products.findProduct(Apple.Key).get -> BuyOneGetOneFree,
    products.findProduct(Orange.Key).get -> Normal)

  describe("buy one get one free offer on apples") {
    it ("list contains 1 apple") {
      Given("a list of 1 apple and 2 oranges")
      And("a product catalogue")
      val items = List("Apple", "Orange", "Orange")

      When("a checkout calculates the price of a list of items")
      And("there is an offer of buy one get one free on apples")
      val checkout = Checkout(products)
      val actual = checkout.price(items, productsOffers)

      Then("the total price is calculated")
      actual.toString must be(s"£1.10")
    }

    it ("list contains 2 apples") {
      Given("a list of 2 apple and 2 oranges")
      And("a product catalogue")
      val items = List("Apple", "Orange", "Apple", "Orange")

      When("a checkout calculates the price of a list of items")
      And("there is an offer of buy one get one free on apples")
      val checkout = Checkout(products)

      val actual = checkout.price(items, productsOffers)

      Then("the total price is calculated")
      actual.toString must be(s"£1.10")
    }
  }
}
