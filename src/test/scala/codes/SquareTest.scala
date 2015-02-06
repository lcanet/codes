package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class SquareTest {

  @Test
  def encode() {
    assertEquals("crseseeiuscdmnaaiumgrslee", Square.encode("cecarredissimuleunmessage"));
  }

  @Test
  def decode() {
    assertEquals("cecarredissimuleunmessage", Square.decode("crseseeiuscdmnaaiumgrslee"));
  }

  @Test
  def encodePad() {
    assertEquals("slegmesears lma ", Square.encode("smallermessage"));
  }

  @Test
  def decodePad() {
    assertEquals("smallermessage", Square.decode("slegmesears lma "));
  }

}