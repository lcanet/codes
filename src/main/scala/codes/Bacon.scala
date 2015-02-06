package codes

object Bacon {

  private def padBin(to: Int)(nb: String): String =
    if (nb.length() < to) "0" + padBin(to - 1)(nb)
    else nb

  private def pad5(nb: String) = padBin(5)(nb)

  private def binVal(x: Int) = pad5(x.toBinaryString).map { v => if (v == '0') 'a' else 'b' }

  private def correct(v: Char): Int = 
    if (v > 'u') v - 2
    else if (v > 'i') v - 1
    else v

  def encode(str: String): String = str.toLowerCase().flatMap { x => binVal(correct(x) - 'a') }

  private def recorrect(v: Int): Int = 
    if (v >= 'u') v + 2
    else if (v >= 'j') v + 1
    else v

  private def fromBin(s: String): Int = Integer.parseInt(s.map { v => if (v == 'a') '0' else '1' }, 2)
  private def recodeCharBloc(s: String): Int = recorrect('a' + fromBin(s))

  def decode(str: String): String = str.grouped(5).map { x => recodeCharBloc(x).toChar }.mkString

}