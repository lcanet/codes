package codes

object Reverse {
  
	def encode(str:String):String = str.split(" ").map(_.reverse).mkString(" ")

	def decode(str:String):String = encode(str)

	
}