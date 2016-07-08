package shopping


case class Price(value: Int) extends Ordered[Price] {
  def +(that: Price) = Price(this.value + that.value)

  def *(thatValue: Int) = Price(value * thatValue)

  override def toString = f"£${BigDecimal(value / 100.0)}%1.2f"

  override def compare(that: Price): Int = this.value compareTo that.value
}

object Price {
  val Zero = Price(0)
}
