package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class BoustrophedonTest {

  @Test
  def encode() {
    assertEquals("LELOIEDATASLEENETSTS", Boustrophedon.encode("LATETEDANSLESETOILES", 4));
  }

  @Test
  def decode() {
    assertEquals("LATETEDANSLESETOILES", Boustrophedon.decode("LELOIEDATASLEENETSTS", 4));
  }

}