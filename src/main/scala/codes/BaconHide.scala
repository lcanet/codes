package codes

object BaconHide {

  private def decodeChar(c: Int): String =
    if (Character.isAlphabetic(c) && Character.isLowerCase(c)) "b"
    else if (Character.isAlphabetic(c) && Character.isUpperCase(c)) "a"
    else ""

  private def toBacon(str: String): String = str.map(decodeChar(_)).mkString

  def decode(str: String): String = Bacon.decode(toBacon(str))

  private def capitalizeChar(bacon: Char, text: Char): Char =
    if (bacon == 'a') Character.toUpperCase(text)
    else Character.toLowerCase(text)

  private def capitalize(bacon: List[Char], text: List[Char]): List[Char] =
    if (bacon.isEmpty) Nil
    else if (text.isEmpty) throw new IllegalArgumentException("Hide text too short")
    else if (Character.isAlphabetic(text.head)) capitalizeChar(bacon.head, text.head) :: capitalize(bacon.tail, text.tail)
    else text.head :: capitalize(bacon, text.tail)

  def encode(str: String, hideText: String):String = capitalize(Bacon.encode(str).toList, hideText.toList).mkString

}