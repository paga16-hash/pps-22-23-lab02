package u02.lab02

import u02.lab02.Lab02.Option

object Lab02 extends App:

  //Task 1
  def greet: String = "Hello, Scala!"
  println(greet)

  //Task 2a
  val toStr: Int => String = _ match
    case n if n >= 0 => "Positive"
    case _ => "Negative"

  def toStrD(n: Int): String = n match
    case n if n >= 0 => "Positive"
    case _ => "Negative"

  val neg: (String => Boolean) => String => Boolean = p => x => !p(x)

  def negD(p: String => Boolean): String => Boolean = !p(_)

  def genNegD[A](p: A => Boolean): A => Boolean = !p(_)

  //Task 2b
  val checkNotCur: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z

  val checkCur: Int => (Int => (Int => Boolean)) = x => y => z => x <= y && y == z

  def checkNotCurD: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z
  def checkCurD(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  //il vincolo sarà che l'output di g dovrà essere uguale a l'input di f.
  def genCompose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

  //Task 3
  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = (a, b) match
    case (_, 0) => a
    case _ => gcd(b, a % b)

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

    def filter[A](opt: Option[A])(p: A => Boolean): Option[A] = opt match
      case Some(a) if p(a) => Some(a)
      case _ => None()

    def map[A, B](opt: Option[A])(m: A => B): Option[B] = opt match
      case Some(a) => Some(m(a))
      case _ => None()

    def fold[A, B](opt: Option[A])(dv: A)(m: A => B): Any = opt match
      case Some(a) => m(a)
      case _ => dv
