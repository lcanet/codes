package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class RotatingMask4Test {


  @Test
  def decode() {
    assertEquals("LADAMEALALICORNE", RotatingMask4.decode("MLEAAODARLLIANCE"));
  }

}