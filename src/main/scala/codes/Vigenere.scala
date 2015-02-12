package codes

object Vigenere {

  private def padTo(key: String, nb: Int)(paddedKey: String): String =
    if (paddedKey.length() < nb) padTo(key, nb)(paddedKey + key(paddedKey.length() % key.length()))
    else paddedKey

  private def encodeChar(char: Character, key: Character): Character = ('A' + (((char - 'A') + (key - 'A')) % 26)).toChar

  def encode(str: String, key: String): String = {
    val paddedKey = padTo(key, str.length())(key)
    (for (i <- 0 until str.length) yield encodeChar(str(i), paddedKey(i))).mkString
  }

  private def norm(p: Int): Int = if (p < 0) norm(p + 26) else p

  private def decodeChar(char: Character, key: Character): Character = ('A' + norm(((char - 'A') - (key - 'A')) % 26)).toChar

  def decode(str: String, key: String): String = {
    val paddedKey = padTo(key, str.length())(key)
    (for (i <- 0 until str.length) yield decodeChar(str(i), paddedKey(i))).mkString
  }

}