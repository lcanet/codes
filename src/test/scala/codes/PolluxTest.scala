package codes

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Assert._

class PolluxTest {


  @Test
  def decode() {
    assertEquals("HELLOWORLD", Pollux.decode("30186350933534316229639452226043582085410"));
  }


}