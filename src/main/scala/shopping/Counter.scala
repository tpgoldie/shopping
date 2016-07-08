package shopping

case class Counter(product: Option[Product]) {
  var count = 0

  def add(aProduct: Product): Unit = {
    product foreach { p =>
      if (aProduct == p) {
        count = count + 1
      }
    }
  }
}
