package codes

/**
 * Substitution simple avec un décalage de 3 rangs
 */
object Caesar {

  private def modulo(x: Int): Int = {
    val a = x % 26
    if (a < 0) a + 26
    else a
  }

  def encode(str: String): String =
    str.toUpperCase().map { x =>
      x match {
        case ' ' => ' '
        case _ => ('A' + modulo(x - 'A' + 3)).toChar
      }
    }

  def decode(str: String): String =
    str.toUpperCase().map { x =>
      x match {
        case ' ' => ' '
        case _ => ('A' + modulo(x - 'A' - 3)).toChar
      }
    }
}