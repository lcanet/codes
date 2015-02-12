package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class ReverseTest {

  @Test
  def encode() {
    assertEquals("noitseuq ed nob snes", Reverse.encode("question de bon sens"));
  }

  @Test
  def decode() {
    assertEquals("question de bon sens", Reverse.decode("noitseuq ed nob snes"));
  }


}
