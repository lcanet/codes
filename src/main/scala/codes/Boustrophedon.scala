package codes

object Boustrophedon {

  private def padEnd(str: String)(nb: Int): String =
    if (str.length() <= nb) padEnd(str + " ")(nb - 1)
    else str 

  def encode(str: String, size: Int): String = {
    val sizeComp = Math.ceil(str.length() / size.toDouble).toInt
    val strPadded = padEnd(str)(sizeComp * size)

    def charPos(row: Int, col: Int): Character =
      if ((col % 2) == 0) strPadded(row * sizeComp + col)
      else strPadded((size - row - 1) * sizeComp + col)

    (for (col <- 0 until sizeComp; row <- 0 until size) yield charPos(row, col)).mkString
  } 

  def decode(str: String, size: Int): String = {
    val sizeComp = Math.ceil(str.length() / size.toDouble).toInt

    def charPos(row: Int, col: Int): Character =
      if ((col % 2) == 0) str(size * col + row)
      else str(size * col + (size - row - 1))

    (for (row <- 0 until size; col <- 0 until sizeComp) yield charPos(row, col)).mkString

  } 

}