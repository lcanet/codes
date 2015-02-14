package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class PolybeWithKeyTest {

  @Test
  def encode() {

    assertEquals("434235542312", PolybeWithKey.encode("RENAISSANCE", "POLYBE"));
  }

  @Test
  def decode() {
    assertEquals("POLYBE", PolybeWithKey.decode("RENAISSANCE", "434235542312"));
  }

  @Test
  def decode2() {
    assertEquals("LEPLAFONDDELACHAPELLESIXTINE", PolybeWithKey.decode("MICHELANGE", "21154121223235233131152122131422411521211544125345122315"));
  }

}
