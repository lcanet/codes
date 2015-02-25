package codes
import org.junit.Assert._
import org.junit.Test

class PlayfairTest {
  @Test
  def encode() {
    assertEquals("ALNJRBCYFHOGBDCT", Playfair.encode("LEONARDDEVINCI", "LATHEORIEGRAVITATIONNELLE"));
  }

  @Test
  def decode() {
    assertEquals("LEONARDXDEVINCIX", Playfair.decode("ALNJRBCYFHOGBDCT", "LATHEORIEGRAVITATIONNELLE"));
  }

}