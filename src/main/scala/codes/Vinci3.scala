package codes

object Vinci3 {

	def decode(str:String):String = str.grouped(3).map(_.reverse).mkString

	def encode(str:String):String = decode(str.filter(Character.isAlphabetic(_)))

}