package shopping

class NotOnOfferSpec extends ShoppingSpec {
  describe("not on offer") {
    it("calculates the price of a list of items") {
      Given("a product is not on offer")
      val product = products.findProduct(Apple.Key)

      And("A list of 2 apples")
      val items = List("Apple", "Apple")
      val offer = NormalPricing(product.get, items)

      When("the price is required")
      val price = offer.price

      Then("the price is calculated")
      price must be(Price(120))
    }
  }
}
