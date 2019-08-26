package puntos

case class Punto(var x : Double=0, var y : Double=0) {
  override def toString() :String= s"($x,$y)"
}