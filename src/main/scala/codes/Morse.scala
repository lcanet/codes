package codes

object Morse {

  private def morse = Map(
    ".-" -> "A",
    "-..." -> "B",
    "-.-." -> "C",
    "-.." -> "D",
    "." -> "E",
    "..-." -> "F",
    "--." -> "G",
    "...." -> "H",
    ".." -> "I",
    ".---" -> "J",
    "-.-" -> "K",
    ".-.." -> "L",
    "--" -> "M",
    "-." -> "N",
    "---" -> "O",
    ".--." -> "P",
    "--.-" -> "Q",
    ".-." -> "R",
    "..." -> "S",
    "-" -> "T",
    "..-" -> "U",
    "...-" -> "V",
    ".--" -> "W",
    "-..-" -> "X",
    "-.--" -> "Y",
    "--.." -> "Z")

  private def morseReverse = morse.map(_.swap)

  private def encodeChar(ch: Character): String =
    morseReverse.get(ch.toString()) match {
      case Some(s) => s
      case None => ""
    }

  def encode(str: String): String = str.toUpperCase().map(encodeChar(_)).mkString(" ")

  private def decodeBloc(str: String): String =
    morse.get(str) match {
      case Some(s) => s
      case None => str
    }

  def decode(str: String) = str.split(" ").map(decodeBloc(_)).mkString

}