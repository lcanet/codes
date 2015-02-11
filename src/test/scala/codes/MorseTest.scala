package codes

import org.junit.Test
import org.junit.Assert._

class MorseTest {

  
  @Test
  def encode() {
    assertEquals("... --- ...", Morse.encode("SOS"));
  }

  @Test
  def decode() {
    assertEquals("L/HOMME/DE/VITRUVE", Morse.decode(".-.. / .... --- -- -- . / -.. . / ...- .. - .-. ..- ...- ."));
  }
  
}