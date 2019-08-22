package puntos

case class Punto(private var _x : Double, private var _y : Double) {
  
  def x=_x
  def y=_y
  
  def x_=(x:Double)= _x = x
  def y_=(y:Double)= _y = y
}