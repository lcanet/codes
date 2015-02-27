package codes
import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class DiagonalTest {

  @Test
  def encode() {
    assertEquals("CLONEREOSTCNLEEHTSSSTAEPEITNATTETGLNRAON", Diagonal.encode("CORTESETLESESPAGNOLSENTRENTATENOCHTITLAN", 5, 8));

  }

  @Test
  def decode() {
    assertEquals("CORTESETLESESPAGNOLSENTRENTATENOCHTITLAN", Diagonal.decode("CLONEREOSTCNLEEHTSSSTAEPEITNATTETGLNRAON", 5, 8));

  }

  @Test
  def decodeBrut() {
    assertTrue(Diagonal.bruteForceDecode("CLONEREOSTCNLEEHTSSSTAEPEITNATTETGLNRAON").contains("CORTESETLESESPAGNOLSENTRENTATENOCHTITLAN"));

  }

}