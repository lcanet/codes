package codes

object VariableCaesar {

  private def modulo(a: Int): Int =
    if ((a % 26) < 0) (a % 26) + 26
    else a % 26

  def encode(str: String, offset: Int): String =
    str.toUpperCase().map { x =>
      x match {
        case ' ' => ' '
        case _ => ('A' + modulo(x - 'A' + offset)).toChar
      }
    }

  def decode(str: String, offset: Int): String =
    str.toUpperCase().map { x =>
      x match {
        case ' ' => ' '
        case _ => ('A' + modulo(x - 'A' - offset)).toChar
      }
    }

  private def incrementFrequency(c: Char, l: List[(Char, Int)]): List[(Char, Int)] = l match {
    case Nil => List((c, 1))
    case (x, freq) :: tail if (x == c) => (c, freq + 1) :: tail
    case head :: tail => head :: incrementFrequency(c, tail)
  }

  private def frequencies(str: String) = str.toList.foldLeft(List[(Char, Int)]()) { (accum, x) => incrementFrequency(x, accum) }

  private def guessOffset(str:String) = frequencies(str).sortBy(_._2).last._1 - 'E' 
  
  def decodeFrequency(str: String): String = decode(str, guessOffset(str.toUpperCase()))

}