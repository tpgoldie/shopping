package shopping

class ProductsPricerSpec extends ShoppingSpec {
  describe("products pricer") {
    val product = products.findProduct(Apple.Key)
    val items = Map(product.get.name -> Seq.fill(3)("Apple"))

    it ("calculates price of a list of products when no offers exist for product") {
      Given("a product pricer")
      And("A list of items")
      val pricer = ProductsPricer(product, items, Map())

      When("the price of the list of items is required")
      val price = pricer.price

      Then("it calculates the price")
      price must be(Price(180))
    }

    it ("calculates price of a list of products when BOGOF offers exist for product") {
      Given("a product pricer")
      And("A list of items")
      val pricer = ProductsPricer(product, items, Map(product.get -> BuyOneGetOneFreeType))

      When("the price of the list of items is required")
      val price = pricer.price

      Then("it calculates the price")
      price must be(Price(120))
    }
  }
}
