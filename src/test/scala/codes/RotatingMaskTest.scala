package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class RotatingMaskTest {


  @Test
  def decode() {
    assertEquals("FAITESTAIREGIORDANOBRUNOBRULEZLEVITE", RotatingMask.decode("LFOAEIBZRLTEEREGUVISINTOTOREDABARIUN"));
  }

}