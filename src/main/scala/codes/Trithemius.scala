package codes

object Trithemius {

  private def encodeChar(ch: Character, pos: Int): Character = ('a' + (ch - 'a' + pos + 1) % 26).toChar

  private def encodeChars(str: String) = for (i <- 0 until str.length) yield encodeChar(str(i), i)

  def encode(str: String) = encodeChars(str.toLowerCase()).mkString

  private def norm(i: Int): Int = if (i < 0) norm(i + 26) else i

  private def decodeChar(ch: Character, pos: Int): Character = ('a' + norm(ch - 'a' - pos - 1) % 26).toChar

  private def decodeChars(str: String) = for (i <- 0 until str.length) yield decodeChar(str(i), i)

  def decode(str: String) = decodeChars(str.toLowerCase()).mkString

}