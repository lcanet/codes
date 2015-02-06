package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class CaesarTest {

  @Test
  def encode() {
    assertEquals("PRULWXUL WH VDOXWDQW", Caesar.encode("Morituri te salutant"));
  }

  @Test
  def decode() {
    assertEquals("MORITURI TE SALUTANT", Caesar.decode("PRULWXUL WH VDOXWDQW"));
  }

}