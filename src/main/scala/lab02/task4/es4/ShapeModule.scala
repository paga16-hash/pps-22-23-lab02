package lab02.task4.es4

import u02.ProductTypes.*

object ShapeModule extends App {

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

}
