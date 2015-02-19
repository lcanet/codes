package codes

import org.junit.Test
import org.junit.Assert._

class VigenereTest {
 @Test
  def encode() {
    assertEquals("XSBNLZVDQJVNNQ", Vigenere.encode("LEONARDDEVINCI", "MONALISA"));
  }

  @Test
  def decode() {
    assertEquals("LEONARDDEVINCI", Vigenere.decode("XSBNLZVDQJVNNQ", "MONALISA"));
  }

  @Test
  def decode2() {
    assertEquals("LAVIERGEAUXROCHERS", Vigenere.decode("WOPDVVRSUPOVZQBZIW", "LOUVRE"));
  }

  @Test
  def decode3() {
    assertEquals("LADAMEALHERMINE", Vigenere.decode("DFXMMXODMYDMBBW", "SFUMATO"));
  }


}