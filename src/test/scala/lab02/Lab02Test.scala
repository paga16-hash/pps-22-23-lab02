package lab02
import junit.framework.TestCase.assertTrue
import org.junit.Assert.{assertEquals, assertFalse, assertNotEquals}
import org.junit.Test
import u02.lab02.lab02.*

class Lab02Test {

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
    assertTrue(notEmpty("stringa"))
    assertFalse(notEmpty(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))

  @Test
  def testNegDef() =
    val empty: String => Boolean = _ == ""
    val notEmpty = negDef(empty)
    assertTrue(notEmpty("stringa"))
    assertFalse(notEmpty(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))

  @Test
  def testGenNegDef() =
    val even: Int => Boolean = _ % 2 == 0
    val odd = genNegDef(even)
    assertTrue(odd(1))
    assertFalse(odd(2))

  @Test
  def testCheckNotCarrVal() =
    //x ≤ y = z
    assertTrue(checkNotCarrVal(1, 2, 2))
    assertTrue(checkNotCarrVal(2, 2, 2))
    assertFalse(checkNotCarrVal(3, 2, 2))
    assertFalse(checkNotCarrVal(2, 2, 1))
    assertFalse(checkNotCarrVal(3, 2, 1))


  @Test
  def testCheckCarrVal() =
    //x ≤ y = z
    assertTrue(checkCarrVal(1)(2)(2))
    assertTrue(checkCarrVal(2)(2)(2))
    assertFalse(checkCarrVal(3)(2)(2))
    assertFalse(checkCarrVal(2)(2)(1))
    assertFalse(checkCarrVal(3)(2)(1))


  def testCheckNotCarrDef() =
    //x ≤ y = z
    assertTrue(checkNotCarrDef(1, 2, 2))
    assertTrue(checkNotCarrDef(2, 2, 2))
    assertFalse(checkNotCarrDef(3, 2, 2))
    assertFalse(checkNotCarrDef(2, 2, 1))
    assertFalse(checkNotCarrDef(3, 2, 1))


  @Test
  def testCheckCarrDef() =
    //x ≤ y = z
    assertTrue(checkCarrDef(1)(2)(2))
    assertTrue(checkCarrDef(2)(2)(2))
    assertFalse(checkCarrDef(3)(2)(2))
    assertFalse(checkCarrDef(2)(2)(1))
    assertFalse(checkCarrDef(3)(2)(1))

  @Test
  def testCompose() =
    assertEquals(9, compose(_ - 1, _ * 2)(5))

  //@Test
  //def testGenericCompose() =
    //assertEquals(9, genericCompose(_ - 1, _ * 2)(5))

  @Test
  def testGCD() =
    assertEquals(4, gcd(12, 8))
    assertEquals(7, gcd(14, 7))
    assertNotEquals(6, gcd(14, 7))
    assertNotEquals(6, gcd(10, 5))


  @Test
  def testShapePerimeter() =
    assertEquals(40, perimeter(Rectangle(10, 20)))
    assertTrue(5 * scala.math.Pi - 0.1 < perimeter(Circle(5)) < 5 * scala.math.Pi + 0.1)
    assertEquals(40, perimeter(Square(10)))

}
