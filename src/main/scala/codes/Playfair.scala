package codes

object Playfair {

  type Square = List[Char]
  type Coord = (Int, Int)

  // square building
  
  private def alphabet = for (i <- 'A' to 'Z') yield i.toChar

  private def addLetters(sq: Square, letters: List[Char]): Square = letters match {
    case head :: tail if (sq.contains(head) || head == 'W') => addLetters(sq, tail)
    case head :: tail => addLetters(sq :+ head, tail)
    case Nil => sq
  }

  private def buildSquare(key: String): Square = addLetters(List(), key.toList ++ alphabet)
  private def coord(ip: Int): Coord = (ip / 5, ip % 5)
  private def coordOf(sq: Square, ch: Char): Coord = coord(sq.indexOf(ch))

  private def norm(v: Int): Int = if (v < 0) norm(v + 5) else v % 5
  private def charOf(sq: Square, c: Coord): Char = sq(norm(c._1) * 5 + norm(c._2))
  
  // encoding
  private def encodeTransposed(sq:Square, p1:Coord, p2:Coord, offsetX:Int, offsetY:Int) = 
    charOf(sq, (p1._1 + offsetX, p1._2 + offsetY)) + "" + charOf(sq, (p2._1 + offsetX, p2._2 + offsetY))
  private def encodeBiGramSquare(sq: Square, p1: Coord, p2: Coord) = charOf(sq, (p1._1, p2._2)) + "" + charOf(sq, (p2._1, p1._2))

  private def encodeBiGram(sq: Square, str: String) = {
    val coord1 = coordOf(sq, str(0))
    val coord2 = coordOf(sq, str(1))
    if (coord1._1 == coord2._1) encodeTransposed(sq, coord1, coord2, 0, 1)
    else if (coord1._2 == coord2._2) encodeTransposed(sq, coord1, coord2, 1, 0)
    else encodeBiGramSquare(sq, coord1, coord2)
  }

  private def dedup(str: String): String = {
    def dedupPairs(ch: List[Char]): List[Char] = ch match {
      case Nil => ch
      case d1 :: d2 :: tail if (d1 == d2) => d1 :: dedupPairs('X' :: d2 :: tail)
      case head :: tail => head :: dedupPairs(tail)
    }
    def appendPadding(ch: List[Char]): List[Char] = if ((ch.length % 2) == 0) ch else ch :+ 'X'
    appendPadding(dedupPairs(str.toList)).mkString
  }

  def encode(str: String, key: String) = {
    val sq = buildSquare(key)
    (dedup(str).grouped(2).map({ x => encodeBiGram(sq, x) })).mkString
  }
  
  // decoding


  private def decodeBiGram(sq: Square, str: String) = {
    val coord1 = coordOf(sq, str(0))
    val coord2 = coordOf(sq, str(1))
    if (coord1._1 == coord2._1) encodeTransposed(sq, coord1, coord2, 0, -1)
    else if (coord1._2 == coord2._2) encodeTransposed(sq, coord1, coord2, -1, 0)
    else encodeBiGramSquare(sq, coord1, coord2)
  }

  def decode(str: String, key: String) = {
    val sq = buildSquare(key)
    str.grouped(2).map({ x => decodeBiGram(sq, x) }).mkString
  }

}