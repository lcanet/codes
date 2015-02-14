package codes

import org.junit.Assert._
import org.junit.Test

class CheckerboardTest {

  @Test
  def encode() {
    assertEquals("QETSUTUDEAIPIOPCEENUAQRU", Checkerboard.encode("QUINEDOUTEPASACQUIERTPEU", 6, 4))
  }

  @Test
  def decode() {
    assertEquals("QUINEDOUTEPASACQUIERTPEU", Checkerboard.decode("QETSUTUDEAIPIOPCEENUAQRU", 6, 4))
  }

  @Test
  def decodeBrut() {
    assertTrue(Checkerboard.bruteForceDecode("QETSUTUDEAIPIOPCEENUAQRU").contains("QUINEDOUTEPASACQUIERTPEU"))
  }

}