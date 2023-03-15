package u02.lab02

object ShapeModule extends App {

  enum Shape:
    case Rectangle(h: Int, l: Int)
    case Circle(radius: Float)
    case Square(side: Int)
}
