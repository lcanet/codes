package codes

object PolybeWithKey {

  private def alphabet = for (i <- 'A' to 'Z') yield i.toChar

  private def addLetters(sq: String, letters: List[Char]): String = letters match {
    case head :: tail if (sq.contains(head) || head == 'W') => addLetters(sq, tail)
    case head :: tail => addLetters(sq + head, tail)
    case Nil => sq
  }

  private def buildSquare(key: String): String = addLetters("", key.toList ++ alphabet)

  private def coordOf(sq: String, letter: Character): Int = {
    val ip = sq.indexOf(letter)
    val row = (ip / 5) + 1
    val col = (ip % 5) + 1
    row * 10 + col
  }

  private def encodeWithSquare(square: String, str: String): String = str.map({ x => coordOf(square, x) }).mkString

  def encode(key: String, str: String): String = encodeWithSquare(buildSquare(key), str)

  private def fromCoord(sq: String, v: Int): Character = {
    val row = v / 10 - 1;
    val col = v % 10 - 1;
    sq(row * 5 + col)
  }

  private def decodeWithSquare(square: String, str: String): String = str.grouped(2).map({ x => fromCoord(square, x.toInt) }).mkString

  def decode(key: String, str: String): String = decodeWithSquare(buildSquare(key), str)

}