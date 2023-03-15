package u02.lab02

import scala.compiletime.ops.boolean.!

object lab02 extends App:

  val intToString: Int => String = _ match
    case n if n >= 0 => "Positive"
    case n if n < 0 => "Negative"

  def intToStringDef(n: Int): String = n match
    case n if n >= 0 => "Positive"
    case n if n < 0 => "Negative"

  val negVal: (String => Boolean) => String => Boolean = pred => x => !pred(x)
  def negDef(pred: String => Boolean): String => Boolean = !pred(_)

  def genNegDef[A](pred: A => Boolean): A => Boolean = !pred(_)

  val check: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z
