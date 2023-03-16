package lab02
import junit.framework.TestCase.assertTrue
import org.junit.Assert.{assertEquals, assertFalse, assertNotEquals}
import org.junit.Test
import u02.lab02.Lab02.*
import u02.lab02.Lab02.Shape.*

class Lab02Test {

  //task 2a
  @Test
  def testPosNegVal() =
    assertEquals("Positive", intToString(1))
    assertEquals("Positive", intToString(1))
    assertEquals("Negative", intToString(-1))

  @Test
  def testPosNegDef() =
    assertEquals("Positive", intToStringDef(1))
    assertEquals("Positive", intToStringDef(1))
    assertEquals("Negative", intToStringDef(-1))

  @Test
  def testNegVal() =
    val empty: String => Boolean = _ == ""
    val notEmpty = negVal(empty)
    assertTrue(notEmpty("string"))
    assertFalse(notEmpty(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))

  @Test
  def testNegDef() =
    val empty: String => Boolean = _ == ""
    val notEmpty = negDef(empty)
    assertTrue(notEmpty("string"))
    assertFalse(notEmpty(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))

  @Test
  def testGenNegDef() =
    val even: Int => Boolean = _ % 2 == 0
    val odd = genNegDef(even)
    assertTrue(odd(1))
    assertFalse(odd(2))

    //task 2b
  @Test
  def testCheckNotCarrVal() =
    //x ≤ y = z
    assertTrue(checkNotCurrVal(1, 2, 2))
    assertTrue(checkNotCurrVal(2, 2, 2))
    assertFalse(checkNotCurrVal(3, 2, 2))
    assertFalse(checkNotCurrVal(2, 2, 1))
    assertFalse(checkNotCurrVal(3, 2, 1))

  @Test
  def testCheckCarrVal() =
    //x ≤ y = z
    assertTrue(checkCurrVal(1)(2)(2))
    assertTrue(checkCurrVal(2)(2)(2))
    assertFalse(checkCurrVal(3)(2)(2))
    assertFalse(checkCurrVal(2)(2)(1))
    assertFalse(checkCurrVal(3)(2)(1))

  def testCheckNotCarrDef() =
    //x ≤ y = z
    assertTrue(checkNotCurrDef(1, 2, 2))
    assertTrue(checkNotCurrDef(2, 2, 2))
    assertFalse(checkNotCurrDef(3, 2, 2))
    assertFalse(checkNotCurrDef(2, 2, 1))
    assertFalse(checkNotCurrDef(3, 2, 1))

  @Test
  def testCheckCarrDef() =
    //x ≤ y = z
    assertTrue(checkCurrDef(1)(2)(2))
    assertTrue(checkCurrDef(2)(2)(2))
    assertFalse(checkCurrDef(3)(2)(2))
    assertFalse(checkCurrDef(2)(2)(1))
    assertFalse(checkCurrDef(3)(2)(1))

  @Test
  def testCompose() =
    assertEquals(9, compose(_ - 1, _ * 2)(5))

  //task 3
  @Test
  def testGCD() =
    assertEquals(4, gcd(12, 8))
    assertEquals(7, gcd(14, 7))
    assertNotEquals(6, gcd(14, 7))
    assertNotEquals(6, gcd(10, 5))

  //task 4
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
