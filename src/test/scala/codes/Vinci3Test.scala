package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class Vinci3Test {

  @Test
  def encode() {

    assertEquals("leHwollrod", Vinci3.encode("Helloworld"));
  }

  @Test
  def decode() {
    assertEquals("Helloworld", Vinci3.decode("leHwollrod"));
  }

}