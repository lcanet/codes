package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class BaconTest {

  @Test
  def encode() {

    assertEquals("aabbbaabaaababaababaabbabbabaaabbabbaaaaababaaaabb", Bacon.encode("Helloworld"));
  }

  @Test
  def decode() {
    assertEquals("helloworld", Bacon.decode("aabbbaabaaababaababaabbabbabaaabbabbaaaaababaaaabb"));
  }

}