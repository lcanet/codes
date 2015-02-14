package codes

import scala.util.Random

object Pollux {

  private def PList = List(0, 1, 3, 8) //> PList: => List[Int]
  private def TList = List(2, 4, 9) //> TList: => List[Int]
  private def EList = List(5, 6, 7) //> EList: => List[Int]

  private def encodeChar(c: Char): Int = c match {
    case '.' => Random.shuffle(PList).head
    case '-' => Random.shuffle(TList).head
    case _ => Random.shuffle(EList).head
  }

  def encode(str: String): String = Morse.encode(str).map(encodeChar(_)).mkString

  private def decodeChar(c: Int): Character =
    if (PList.contains(c)) '.'
    else if (TList.contains(c)) '-'
    else ' '

  def decode(str: String): String = Morse.decode(str.grouped(1).map(Integer.parseInt(_)).map(decodeChar(_)).mkString)

}