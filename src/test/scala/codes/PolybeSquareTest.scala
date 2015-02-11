package codes
import org.junit.Test
import org.junit.Assert._

class PolybeSquareTest {
  @Test
  def encode() {
    assertEquals("33112224425115", PolybeSquare.encode("MAGIQUE"));
  }

  @Test
  def decode() {
    assertEquals("magique", PolybeSquare.decode("33112224425115"));
  }

  @Test
  def decode2() {
    assertEquals("devosmainsgrossieresparmidespoussieresecrivezsorcieresabracadabra", PolybeSquare.decode("1415523544331124344422433544442415431544411143332414154441355144442415431544151343245215554435431324154315441112431113111411124311"));
  }
}