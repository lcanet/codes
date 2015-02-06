package codes

object Square {

  private def squarePadSize(n: Int, str: String): Int =
    if (n * n < str.length()) squarePadSize(n + 1, str)
    else n //> squarePadSize: (n: Int, str: String)Int

  private def padEnd(str: String, len: Int): String =
    if (str.length() < len) padEnd(str + " ", len)
    else str //> padEnd: (str: String, len: Int)String

  private def squareTraversal(str: String, len: Int): String =
    (for (i <- 0 to len - 1; j <- 0 to len - 1) yield str(j * len + i)).mkString
  //> squareTraversal: (str: String, len: Int)String

  def encode(str: String): String = {
    val sqSize = squarePadSize(0, str)
    squareTraversal(padEnd(str, sqSize * sqSize), sqSize)
  } //> encode: (str: String)String

  def decode(str: String): String = {
    val sqSize = Math.sqrt(str.length()).toInt
    squareTraversal(str, sqSize).trim()
  } //> decode: (str: String)String

}