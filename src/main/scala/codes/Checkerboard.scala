package codes

object Checkerboard {

  private def padTo(n: Int)(str: String): String =
    if (str.length < n) str + "_"
    else if (str.length == n) str
    else throw new IllegalArgumentException("Input too long")

  private def traverse(str: String, rows: Int, cols: Int) =
    (for (r <- 0 until rows; c <- 0 until cols) yield str(r + rows * c)).mkString

  def decode(str: String, rows: Int, cols: Int): String = {
    if (str.length != rows * cols) throw new IllegalArgumentException("Bad length")
    traverse(str, rows, cols)
  }

  def encode(str: String, rows: Int, cols: Int): String = {
    val padded = padTo(rows * cols)(str)
    traverse(padded, cols, rows)
  }

  private def possibleGrids(n: Int): Set[(Int, Int)] = {
    def accum(s: Set[(Int, Int)], p: Int): Set[(Int, Int)] = {
      if (p >= n) s
      else if ((n % p) == 0) accum(s + ((p, n / p)), p + 1)
      else accum(s, p + 1)
    }

    accum(Set(), 2)		// don't use 1 row/line
  }

  def bruteForceDecode(str: String): List[String] =
    possibleGrids(str.length).map({ x => decode(str, x._1, x._2) }).toList

}