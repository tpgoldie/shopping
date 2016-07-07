package shopping

import org.scalatest.{GivenWhenThen, MustMatchers, FunSpec}

class CheckoutSpec extends FunSpec with MustMatchers with GivenWhenThen {
  describe("Checkout must calculate the price of a list of items") {
    Given("a list of 3 apples and 1 orange")
    And("A product catalogue")
    val items = List("Apple", "Apple", "Orange", "Apple")

    val products = Products

    When("a checkout calculates the price of a list of items")
    val checkout = Checkout(products)
    val actual = checkout.price(items)

    Then("the total price is calculated")
    actual.toString must be(s"£2.05")
  }
}
