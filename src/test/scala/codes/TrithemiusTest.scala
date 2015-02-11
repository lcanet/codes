package codes
import org.junit.Test
import org.junit.Assert._

class TrithemiusTest {
  @Test
  def encode() {
    assertEquals("ekvwnsbtjdtaa", Trithemius.encode("dissimulation"));
  }

  @Test
  def decode() {
    assertEquals("dissimulation", Trithemius.decode("ekvwnsbtjdtaa"));
  }

  @Test
  def decode2() {
    assertEquals("lecodexleicesteracquisparbillgates", Trithemius.decode("mgfsiketnsnqfhthrujodomyqbjnokfzla"));
  }
}

