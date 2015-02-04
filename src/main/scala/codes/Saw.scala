package codes

object Saw {
	
	
  private def appendTail(from: String, orig: String) =
    if ((orig.length() % 2) == 1) from + orig.last
    else from                                    

  def encode(str: String): String = {
    val mid = str.length() / 2
    val chars1 = for (i <- 0 to mid - 1) yield str(2*i)
    val chars2 = for (i <- 0 to mid - 1) yield str(2*i+1)
    
    appendTail(chars1.mkString + chars2.mkString, str)
  }                                             

  def decode(str:String):String = {
    val mid = str.length() / 2
    val offset = if ((str.length() % 2) == 1) 1 else 0
    (for (i <- 0 to mid-1) yield (str(i) + "" + str(mid+i+offset))).flatten.mkString
  }                                             

}