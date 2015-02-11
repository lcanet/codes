package codes

object PolybeSquare {

  private def intCodeOf(ch: Character): Int =
    if (ch > 'w') ch - 'a' + 1
    else ch - 'a';

  private def coordOf(ch: Character): Int = {
    val ord: Int = intCodeOf(ch)
    val row: Int = 1 + ord / 5
    val col: Int = 1 + ord % 5
    row * 10 + col
  }

  private def encodeChar(ch: Character): String = {
    if (ch == 'w') ""
    else coordOf(ch).toString()
  }

  def encode(str: String): String = str.toLowerCase().map(coordOf(_)).mkString("")

  private def charCodeOfPos(row:Int, col:Int):Character = ('a' + row * 5 + col).toChar
  
  private def decodePos(v: Int): Character = {
    val row = v / 10 - 1;
    val col = v % 10 - 1;
    if (row == 4 && col >= 2) charCodeOfPos(row, col+1)
    else charCodeOfPos(row, col)
  }

  def decode(str: String): String = str.grouped(2).map({ x => decodePos(x.toInt) }).mkString
}