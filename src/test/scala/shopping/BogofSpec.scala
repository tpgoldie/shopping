package shopping

class BogofSpec extends ShoppingSpec {
  describe("buy one get one free") {
    it("calculates the price of an empty list") {
      Given("a product is not on offer")
      val product = products.findProduct(Apple.Key)

      And("An empty list")
      val items = List.empty
      val offer = Bogof(product.get, items)

      When("the price is required")
      val price = offer.price

      price must be(Price(0))
    }

    it("calculates the price of a list of containing 1 apple") {
      Given("a product is not on offer")
      val product = products.findProduct(Apple.Key)

      And("A list of 1 apple")
      val items = List("Apple")
      val offer = Bogof(product.get, items)

      When("the price is required")
      val price = offer.price

      price must be(Price(60))
    }

    it("calculates the price of a list of containing 2 apples") {
      Given("a product is not on offer")
      val product = products.findProduct(Apple.Key)

      And("A list of 2 apples")
      val items = List.fill(2)("Apple")
      val offer = Bogof(product.get, items)

      When("the price is required")
      val price = offer.price

      price must be(Price(60))
    }

    it("calculates the price of a list of containing 3 apples") {
      Given("a product is not on offer")
      val product = products.findProduct(Apple.Key)

      And("A list of 3 apples")
      val items = List.fill(3)("Apple")
      val offer = Bogof(product.get, items)

      When("the price is required")
      val price = offer.price

      price must be(Price(120))
    }

    it("calculates the price of a list of containing 5 apples") {
      Given("a product is not on offer")
      val product = products.findProduct(Apple.Key)

      And("A list of 3 apples")
      val items = List.fill(5)("Apple")
      val offer = Bogof(product.get, items)

      When("the price is required")
      val price = offer.price

      price must be(Price(180))
    }
  }
}
