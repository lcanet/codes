package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class VariableCaesarTest {

  @Test
  def encode() {
    assertEquals("PRULWXUL WH VDOXWDQW", VariableCaesar.encode("Morituri te salutant", 3));
  }

  @Test
  def decode() {
    assertEquals("MORITURI TE SALUTANT", VariableCaesar.decode("PRULWXUL WH VDOXWDQW", 3));
  }

  @Test
  def decodeFrequency() {
    assertEquals("LEFERSEROUILLEFAUTEDESENSERVIRLEAUSTAGNANTEPERDDESAPURETEETSEGLACEPARSEFROIDDEMEMELINACTIONSAPELAVIGUEURDELESPRIT", VariableCaesar.decodeFrequency("SLMLYZLYVBPSSLMHBALKLZLUZLYCPYSLHBZAHNUHUALWLYKKLZHWBYLALLAZLNSHJLWHYZLMYVPKKLTLTLSPUHJAPVUZHWLSHCPNBLBYKLSLZWYPA"));
  }

}