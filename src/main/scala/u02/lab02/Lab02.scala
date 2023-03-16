package u02.lab02

object Lab02 extends App:

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
  val checkNotCurrVal: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z

  val checkCurrVal: Int => (Int => (Int => Boolean)) = x => y => z => x <= y && y == z

  def checkNotCurrDef: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z
  def checkCurrDef(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  //il vincolo sarà che l'output di g dovrà essere uguale a l'input di f.
  def genericCompose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

  //Task 3
  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = (a, b) match
    case (_, 0) => a
    case _ if a > b => gcd(b, a % b)

  println(gcd(12, 8))

  //Task 4
  enum Shape:
    case Rectangle(l: Int, h: Int)
    case Circle(r: Float)
    case Square(s: Int)

  object Shape:
    def perimeter(shape: Shape): Double = shape match
      case Rectangle(l, h) => (l + h) * 2
      case Circle(r) => r * (scala.math.Pi * 2)
      case Square(s) => s * 4

    def contains(shape: Shape, point: (Double, Double)): Boolean = shape match
      case Rectangle(l, h) => abs(l / 2, point._1)(h / 2, point._2)
      case Circle(r) => abs(r, point._1)(r, point._2)
      case Square(s) => abs(s / 2, point._1)(s / 2, point._2)

    def abs(x1: Double, x2: Double)(y1: Double, y2: Double): Boolean =
      scala.math.abs(x1) >= scala.math.abs(x2)
        && scala.math.abs(y1) >= scala.math.abs(y2)

  //Task 5
  object Optionals:

    enum Option[A]:
      case Some(a: A)
      case None() // here parens are needed because of genericity

    object Option:

      def isEmpty[A](opt: Option[A]): Boolean = opt match
        case None() => true
        case _ => false

      def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
        case Some(a) => a
        case _ => orElse

      def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
        case Some(a) => f(a)
        case _ => None()

    import Option.*

    val s1: Option[Int] = Some(1)
    val s2: Option[Int] = Some(2)
    val s3: Option[Int] = None()

    println(s1) // Some(1)
    println(orElse(s1, 0))
    println(orElse(s3, 0)) // 1,0
    println(flatMap(s1)(i => Some(i + 1))) // Some(2)
    println(flatMap(s1)(i => flatMap(s2)(j => Some(i + j)))) // Some(3)
    println(flatMap(s1)(i => flatMap(s3)(j => Some(i + j)))) // None
