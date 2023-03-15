package lab02
import junit.framework.TestCase.assertTrue
import org.junit.Assert.{assertEquals, assertFalse}
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
  def testCarriedFunType() =
    //x ≤ y = z
    assertTrue(check(1, 2, 2))
    assertTrue(check(2, 2, 2))
    assertFalse(check(3, 2, 2))
    assertFalse(check(2, 2, 1))
    assertFalse(check(3, 2, 1))
}
