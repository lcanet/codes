package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class SawTest {

  @Test
  def encode() {

    assertEquals("perpioohleiidlnuveirehlspaelxreogei", Saw.encode("pierrephilosophaleelixirdelonguevie"));
  }

  @Test
  def decode() {
    assertEquals("pierrephilosophaleelixirdelonguevie", Saw.decode("perpioohleiidlnuveirehlspaelxreogei"));
  }

}