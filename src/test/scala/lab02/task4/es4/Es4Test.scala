package lab02.task4.es4

import junit.framework.TestCase.assertTrue
import org.junit.Assert.{assertEquals, assertFalse, assertNotEquals}
import org.junit.Test
import ShapeModule.Shape.*

class Es4Test {
  @Test
  def testShapePerimeter() =
    val rectPer = perimeter(Rectangle(20, 10))
    assertTrue(rectPer >= 59.9 && rectPer <= 60.1)
    val circlePer = perimeter(Circle(5))
    assertTrue((circlePer >= 5 * (scala.math.Pi * 2) - 0.1) && circlePer <= (5 * (scala.math.Pi * 2) + 0.1))
    val squarePer = perimeter(Square(10))
    assertTrue(squarePer >= 39.9 && squarePer <= 40.1)

  @Test
  def testShapeContains() =
    assertTrue(contains(Square(10), (5, 5)))
    assertTrue(contains(Rectangle(20, 10), (10, 5)))
    assertTrue(contains(Circle(10), (5, 5)))
    assertFalse(contains(Square(10), (11, 0)))
    assertFalse(contains(Rectangle(20, 10), (20, 11)))
    assertFalse(contains(Circle(1), (5, 5)))
}
