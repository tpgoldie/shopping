package shopping

class ThreeForTwoSpec extends ShoppingSpec {
  describe("three for two") {
    it("calculates the price of an empty list") {
      Given("a product is on 3 for 2 offer")
      val product = products.findProduct(Orange.Key)

      And("An empty list")
      val items = List()
      val offer = ThreeForTwo(product.get, items)

      When("the price is required")
      val price = offer.price

      Then("it calculates the price")
      price must be(Price(0))
    }

    it("calculates the price of a list of containing 1 orange") {
      Given("a product is on 3 for 2 offer")
      val product = products.findProduct(Orange.Key)

      And("A list of 1 orange")
      val items = List("Orange")
      val offer = ThreeForTwo(product.get, items)

      When("the price is required")
      val price = offer.price

      Then("it calculates the price")
      price must be(Price(25))
    }

    it("calculates the price of a list of containing 2 oranges") {
      Given("orange is on 3 for 2 offer")
      val product = products.findProduct(Orange.Key)

      And("A list of 2 oranges")
      val items = List.fill(2)("Orange")
      val offer = ThreeForTwo(product.get, items)

      When("the price is required")
      val price = offer.price

      Then("it calculates the price")
      price must be(Price(50))
    }

    it("calculates the price of a list of containing 3 oranges") {
      Given("orange is on 3 for 2 offer")
      val product = products.findProduct(Orange.Key)

      And("A list of 3 oranges")
      val items = List.fill(3)("Orange")
      val offer = ThreeForTwo(product.get, items)

      When("the price is required")
      val price = offer.price

      Then("it calculates the price")
      price must be(Price(50))
    }

    it("calculates the price of a list of containing 4 oranges") {
      Given("orange is on 3 for 2 offer")
      val product = products.findProduct(Orange.Key)

      And("A list of 4 oranges")
      val items = List.fill(4)("Orange")
      val offer = ThreeForTwo(product.get, items)

      When("the price is required")
      val price = offer.price

      Then("it calculates the price")
      price must be(Price(75))
    }

    it("calculates the price of a list of containing 8 oranges") {
      Given("orange is on 3 for 2 offer")
      val product = products.findProduct(Orange.Key)

      And("A list of 4 oranges")
      val items = List.fill(8)("Orange")
      val offer = ThreeForTwo(product.get, items)

      When("the price is required")
      val price = offer.price

      Then("it calculates the price")
      price must be(Price(150))
    }
  }
}
