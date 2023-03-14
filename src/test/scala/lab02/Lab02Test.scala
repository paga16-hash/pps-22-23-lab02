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
    val empty : String => Boolean = _ == ""
    val notEmpty = negVal(empty)
    assertEquals(true, notEmpty("stringa"))
    assertEquals(false, notEmpty(""))
    assertEquals(true, notEmpty("foo") && !notEmpty(""))


  @Test
  def testNegDef() =
    val empty: String => Boolean = _ == ""
    val notEmpty = negDef(empty)
    assertEquals(true, notEmpty("stringa"))
    assertEquals(false, notEmpty(""))
    assertEquals(true, notEmpty("foo") && !notEmpty(""))

}
