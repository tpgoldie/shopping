package shopping

case class Price(value: Int) {
  def +(that: Price) = Price(this.value + that.value)

  override def toString = f"£${BigDecimal(value / 100.0)}%1.2f"
}

object Price {
  val Zero = Price(0)
}
