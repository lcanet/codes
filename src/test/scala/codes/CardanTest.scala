package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class CardanTest {

  @Test
  def encode() {

    assertEquals("CACACBCAACAACBA", Cardan.encode("Hello"));
  }

  @Test
  def decode() {
    assertEquals("HELLO", Cardan.decode("CACACBCAACAACBA"));
  }
  
  @Test
  def decode2()  {
    assertTrue(Cardan.decodeAll("ABBAACACACBBBABACBCCCACAAACBAABACABBACBBAA").contains("JACQUESCARTIER"));
  }

}

