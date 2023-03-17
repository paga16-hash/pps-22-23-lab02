package lab02
import junit.framework.TestCase.assertTrue
import org.junit.Assert.{assertEquals, assertFalse, assertNotEquals}
import org.junit.Test
import u02.lab02.Lab02.*
import u02.lab02.Lab02.Shape.*
import u02.lab02.Lab02.Option.*

class Lab02Test {

  //task 2a
  @Test
  def testToStr(): Unit =
    assertEquals("Positive", toStr(1))
    assertEquals("Positive", toStr(1))
    assertEquals("Negative", toStr(-1))

  @Test
  def testToStrD(): Unit =
    assertEquals("Positive", toStrD(1))
    assertEquals("Positive", toStrD(1))
    assertEquals("Negative", toStrD(-1))

  @Test
  def testNeg(): Unit =
    val empty: String => Boolean = _ == ""
    val notEmpty = neg(empty)
    assertTrue(notEmpty("string"))
    assertFalse(notEmpty(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))

  @Test
  def testNegD(): Unit =
    val empty: String => Boolean = _ == ""
    val notEmpty = negD(empty)
    assertTrue(notEmpty("string"))
    assertFalse(notEmpty(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))

  @Test
  def testGenNegD(): Unit =
    val even: Int => Boolean = _ % 2 == 0
    val odd = genNegD(even)
    assertTrue(odd(1))
    assertFalse(odd(2))

  //task 2b
  @Test
  def testCheckNotCur(): Unit =
    //x ≤ y = z
    assertTrue(checkNotCur(1, 2, 2))
    assertTrue(checkNotCur(2, 2, 2))
    assertFalse(checkNotCur(3, 2, 2))
    assertFalse(checkNotCur(2, 2, 1))
    assertFalse(checkNotCur(3, 2, 1))

  @Test
  def testCheckCur(): Unit =
    //x ≤ y = z
    assertTrue(checkCur(1)(2)(2))
    assertTrue(checkCur(2)(2)(2))
    assertFalse(checkCur(3)(2)(2))
    assertFalse(checkCur(2)(2)(1))
    assertFalse(checkCur(3)(2)(1))

  def testCheckNotCurD(): Unit =
    //x ≤ y = z
    assertTrue(checkNotCurD(1, 2, 2))
    assertTrue(checkNotCurD(2, 2, 2))
    assertFalse(checkNotCurD(3, 2, 2))
    assertFalse(checkNotCurD(2, 2, 1))
    assertFalse(checkNotCurD(3, 2, 1))

  @Test
  def testCheckCurD(): Unit =
    //x ≤ y = z
    assertTrue(checkCurD(1)(2)(2))
    assertTrue(checkCurD(2)(2)(2))
    assertFalse(checkCurD(3)(2)(2))
    assertFalse(checkCurD(2)(2)(1))
    assertFalse(checkCurD(3)(2)(1))

  @Test
  def testCompose(): Unit =
    assertEquals(9, compose(_ - 1, _ * 2)(5))

  @Test
  def testGenCompose(): Unit =
    val res = genCompose[Int, Double, Double](_ * 1, _ * 2.0)(5)
    println(res)
    assertTrue(res >= 9.999 && res <= 10.001)
    assertEquals(9, genCompose[Int, Int, Int](_ - 1, _ * 2)(5))

  //task 3
  @Test
  def testGCD(): Unit =
    assertEquals(4, gcd(12, 8))
    assertEquals(4, gcd(8, 12))
    assertEquals(7, gcd(14, 7))
    assertNotEquals(6, gcd(14, 7))
    assertNotEquals(6, gcd(10, 5))

  //task 4
  @Test
  def testShapePerimeter(): Unit =
    val rectPer = perimeter(Rectangle(20, 10))
    assertTrue(rectPer >= 59.9 && rectPer <= 60.1)
    val circlePer = perimeter(Circle(5))
    assertTrue((circlePer >= 5 * (scala.math.Pi * 2) - 0.1) && circlePer <= (5 * (scala.math.Pi * 2) + 0.1))
    val squarePer = perimeter(Square(10))
    assertTrue(squarePer >= 39.9 && squarePer <= 40.1)

  @Test
  def testShapeContains(): Unit =
    assertTrue(contains(Square(10), (5, 5)))
    assertTrue(contains(Rectangle(20, 10), (10, 5)))
    assertTrue(contains(Circle(10), (5, 5)))
    assertFalse(contains(Square(10), (11, 0)))
    assertFalse(contains(Rectangle(20, 10), (20, 11)))
    assertFalse(contains(Circle(1), (5, 5)))

  @Test
  def testFilter(): Unit =
    assertEquals(Some(5), filter(Some(5))(_ > 2))
    assertEquals(None(), filter(Some(5))(_ < 2))
    assertEquals(None(), filter(None[Int]())(_ > 2))

  @Test
  def testMap(): Unit =
    assertEquals(Some(true), map(Some(5))(_ > 2))
    assertEquals(Some(false), map(Some(5))(_ > 8))
    assertEquals(None(), map(None[Int]())(_ > 2))

  @Test
  def testFold(): Unit =
    assertEquals(6, fold(Some(5))(1)(_ + 1))
    assertEquals(1, fold(None[Int]())(1)(_ + 1))

}
