package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class BaconHideTest {

  @Test
  def encode() {

    assertEquals("POrteZ Ce VIEuX wHIsKy AU juGe", BaconHide.encode("hello", "Portez ce vieux whisky au juge"));
  }

  @Test
  def decode() {
    assertEquals("hello", BaconHide.decode("POrteZ Ce VIEuX wHIsKy AU juGe"));
  }

}