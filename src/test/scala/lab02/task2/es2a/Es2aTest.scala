package lab02.task2.es2a

import junit.framework.TestCase.assertTrue
import org.junit.Assert.{assertEquals, assertFalse, assertNotEquals}
import org.junit.Test
import Es2a.*

class Es2aTest {

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

}
