package lab02.task3.es3

import junit.framework.TestCase.assertTrue
import org.junit.Assert.{assertEquals, assertFalse, assertNotEquals}
import org.junit.Test
import Es3.*

class Es3Test {
  @Test
  def testGCD() =
    assertEquals(4, gcd(12, 8))
    assertEquals(7, gcd(14, 7))
    assertNotEquals(6, gcd(14, 7))
    assertNotEquals(6, gcd(10, 5))
}
