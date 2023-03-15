package lab02.task2.es2b

import junit.framework.TestCase.assertTrue
import org.junit.Assert.{assertEquals, assertFalse, assertNotEquals}
import org.junit.Test
import Es2b.*

class Es2bTest {

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

  @Test
  def testGenericCompose() =
    //TODO
    //assertEquals(9, genericCompose(_ - 1, _ * 2)(5))
    assertEquals(9, 8)


}
