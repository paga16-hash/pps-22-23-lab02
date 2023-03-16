package u02.lab02

import scala.compiletime.ops.boolean.!

object lab02 extends App:

  //Task 1
  def greet: String = "Hello, Scala!"
  println(greet)

  //Task 2a
  val intToString: Int => String = _ match
    case n if n >= 0 => "Positive"
    case n if n < 0 => "Negative"

  def intToStringDef(n: Int): String = n match
    case n if n >= 0 => "Positive"
    case n if n < 0 => "Negative"

  val negVal: (String => Boolean) => String => Boolean = pred => x => !pred(x)
  def negDef(pred: String => Boolean): String => Boolean = !pred(_)

  def genNegDef[A](pred: A => Boolean): A => Boolean = !pred(_)

  //Task 2b
  val checkNotCarrVal: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z

  val checkCarrVal: Int => Int => Int => Boolean = x => y => z => x <= y && y == z

  def checkNotCarrDef: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z
  def checkCarrDef(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  //il vincolo molto semplicemente sarà che l'output di g dovrà essere uguale a l'input di f.

  //def genericCompose[A, B, C](f: B => C, g: A => B): C => A = f(g(_))

  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = (a, b) match
    case (_, 0) => a
    case _ if a > b => gcd(b, a % b)

  println(gcd(12, 8))





