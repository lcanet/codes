package codes

object Diagonal {

  // common types
  type Permutation = List[Int]

  private def toTuples(p: Permutation): List[(Int, Int)] = p.foldLeft(List[(Int, Int)]())({ (accum, x) => accum :+ (accum.length, x) })
  private def toMap(p: Permutation) = toTuples(p).toMap

  private def applyPermutation(str: String, p: Permutation) = {
    def m = toMap(p)
    (for (i <- 0 until str.length()) yield str(m(i))).mkString
  }

  private def reverse(p: Permutation): Permutation = toTuples(p).map(_.swap).sortBy(_._1).map(_._2)

  // diagonal

  type Coord = (Int, Int)
  private def index(cols: Int, c: Coord): Int = cols * c._1 + c._2

  private def diag(cols: Int, pos: Coord): Permutation =
    if (pos._1 < 0 || pos._2 >= cols) Nil
    else index(cols, pos) :: diag(cols, (pos._1 - 1, pos._2 + 1))

  private def diagRows(rows: Int, cols: Int): Permutation = (for (i <- 0 until rows) yield diag(cols, (i, 0))).toList.flatten
  private def diagCols(rows: Int, cols: Int): Permutation = (for (i <- 1 until cols) yield diag(cols, (rows - 1, i))).toList.flatten

  private def diagPermut(rows: Int, cols: Int): Permutation = diagRows(rows, cols) ::: diagCols(rows, cols)

  private def padTo(n: Int)(str: String): String =
    if (str.length < n) str + "_"
    else if (str.length == n) str
    else throw new IllegalArgumentException("Input too long")

  def encode(str: String, rows: Int, cols: Int): String = applyPermutation(padTo(rows * cols)(str), diagPermut(rows, cols))

  def decode(str: String, rows: Int, cols: Int): String = applyPermutation(str, reverse(diagPermut(rows, cols)))

  private def possibleGrids(n: Int): Set[(Int, Int)] = {
    def accum(s: Set[(Int, Int)], p: Int): Set[(Int, Int)] = {
      if (p >= n) s
      else if ((n % p) == 0) accum(s + ((p, n / p)), p + 1)
      else accum(s, p + 1)
    }
    accum(Set(), 2) // don't use 1 row/line
  }

  def bruteForceDecode(str: String): List[String] =
    possibleGrids(str.length).map({ x => decode(str, x._1, x._2) }).toList

}