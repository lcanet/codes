package codes

object RotatingMask {
	private val positions = Array((0,1), (0,3), (0,5), (1,4), (2,2), (3,1), (3,4), (4,5), (5,3))

	private def pad36(str:String):String =
		if (str.length() > 36) throw new IllegalArgumentException("too long")
		else if (str.length < 36) pad36(str + " ");
		else str                        

	private def rotate(p:(Int,Int)):(Int,Int) = (p._2, 5-p._1)

	private def rotateMask(a:Array[(Int,Int)]):Array[(Int,Int)] = a.map(rotate(_)).sorted

	private def cellRead(str:String, pos:(Int,Int)):Char =str(6*pos._1 + pos._2)
	
	private def maskRead(str:String, pos: Array[(Int, Int)]):String = pos.map(cellRead(str, _)).mkString
  
	private def readQuart(str:String, q:Int, pos:Array[(Int, Int)]):String =
  	if (q < 0) ""
  	else maskRead(str, pos) + readQuart(str, q-1, rotateMask(pos))
	
	def decode(str:String):String = readQuart(pad36(str), 3, positions)
}