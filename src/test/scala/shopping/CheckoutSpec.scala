package shopping

import org.scalatest.{GivenWhenThen, MustMatchers, FunSpec}

class CheckoutSpec extends FunSpec with MustMatchers with GivenWhenThen {
  describe("A checkout") {
    val products = Products

    describe("calculates the price of a list of items") {
      it("when list of items contains multiple apples") {
        Given("a list of 3 apples and 1 orange")
        And("A product catalogue")
        val items = List("Apple", "Apple", "Orange", "Apple")

        When("a checkout calculates the price of a list of items")
        val checkout = Checkout(products)
        val actual = checkout.price(items)

        Then("the total price is calculated")
        actual.toString must be(s"£2.05")
      }

      it("when list of items contains multiple oranges") {
        Given("a list of 1 apple and 2 oranges")
        And("A product catalogue")
        val items = List("Apple", "Orange", "Orange")

        When("a checkout calculates the price of a list of items")
        val checkout = Checkout(products)
        val actual = checkout.price(items)

        Then("the total price is calculated")
        actual.toString must be(s"£1.10")
      }

      it("when list of items contains just apples") {
        Given("a list of 2 apples")
        And("A product catalogue")
        val items = List("Apple", "Apple")

        When("a checkout calculates the price of a list of items")
        val checkout = Checkout(products)
        val actual = checkout.price(items)

        Then("the total price is calculated")
        actual.toString must be(s"£1.20")
      }

      it("when list of items contains just oranges") {
        Given("a list of 3 oranges")
        And("A product catalogue")
        val items = List("Orange", "Orange", "Orange")

        When("a checkout calculates the price of a list of items")
        val checkout = Checkout(products)
        val actual = checkout.price(items)

        Then("the total price is calculated")
        actual.toString must be(s"£0.75")
      }

      it("when list of items is empty") {
        Given("an empty list")
        And("A product catalogue")
        val items = List()

        When("a checkout calculates the price of a list of items")
        val checkout = Checkout(products)
        val actual = checkout.price(items)

        Then("the total price is calculated")
        actual.toString must be(s"£0.00")
      }
    }
  }
}
