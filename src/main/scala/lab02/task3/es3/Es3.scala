package lab02.task3.es3

object Es3 {
  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = (a, b) match
    case (_, 0) => a
    case _ if a > b => gcd(b, a % b)

  println(gcd(12, 8))
}
