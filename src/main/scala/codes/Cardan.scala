package codes

object Cardan {

  private def alphabet = Map(
    "A" -> "AAC",
    "B" -> "AAB",
    "C" -> "ACA",
    "D" -> "ACC",
    "E" -> "ACB",
    "F" -> "ABA",
    "G" -> "ABC",
    "H" -> "CAC",
    "I" -> "ABB",
    "J" -> "ABB",
    "K" -> "CAB",
    "L" -> "CAA",
    "M" -> "CCA",
    "N" -> "CCB",
    "O" -> "CBA",
    "P" -> "CBC",
    "Q" -> "CBB",
    "R" -> "BAA",
    "S" -> "CCC",
    "T" -> "BAC",
    "U" -> "BAB",
    "V" -> "BAB",
    "W" -> "BAB",
    "X" -> "BCA",
    "Y" -> "BCC",
    "Z" -> "BCB")

  private def addToMultiMap(m: Map[String, List[String]], t: (String, String)): Map[String, List[String]] = {
    val key = t._1
    val value = t._2
    m.get(t._1) match {
      case Some(x) => m + (key -> (x :+ value))
      case None => m + (key -> List(value))
    }
  }

  private def alphabetReverse = alphabet.toList.map(_.swap).foldLeft(Map[String, List[String]]()) { (acc, pair) => addToMultiMap(acc, pair) }

  private def encodeChar(ch: Character): String =
    alphabet.get(ch.toString()) match {
      case Some(s) => s
      case None => ""
    }

  def encode(str: String): String = str.toUpperCase().map(encodeChar(_)).mkString

  private def appendAll(possibles: List[String], chars: List[String]) = for (i <- possibles; j <- chars) yield i + j

  private def decodeAllBloc(str: String, possibles: List[String]): List[String] =
    alphabetReverse.get(str) match {
      case Some(s) => appendAll(possibles, s)
      case None => possibles
    }

  def decodeAll(str: String): List[String] = str.grouped(3).foldLeft(List[String]("")) { (acc, char) => decodeAllBloc(char, acc) }

  def decode(str: String): String = decodeAll(str).head

}