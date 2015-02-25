package codes

object RailFence {

  // a bit abstract, may be useful later
  type Permutation = List[Int]

  private def toTuples(p: Permutation): List[(Int, Int)] = p.foldLeft(List[(Int, Int)]())({ (accum, x) => accum :+ (accum.length, x) })
  private def toMap(p: Permutation) = toTuples(p).toMap

  private def applyPermutation(str: String, p: Permutation) = {
    def m = toMap(p)
    (for (i <- 0 until str.length()) yield str(m(i))).mkString
  }

  private def reverse(p: Permutation): Permutation = toTuples(p).map(_.swap).sortBy(_._1).map(_._2)

  // rail fence
  
  private def railPermutT(len: Int, period: Int, row: Int, pos: Int): List[Int] =
    if (pos >= len) Nil
    else if (row == 0 || row == period / 2) (pos + row) :: railPermutT(len, period, row, pos + period)
    else (pos + row) :: (pos + period - row) :: railPermutT(len, period, row, pos + period)

  private def railPermut(len: Int, period: Int): Permutation = (for (i <- 0 to period / 2) yield railPermutT(len, period, i, 0)).flatten.toList.filter(_ < len)

  def encode(str: String, period: Int): String = applyPermutation(str, railPermut(str.length(), period))

  def decode(str: String, period: Int): String = applyPermutation(str, reverse(railPermut(str.length(), period)))

}