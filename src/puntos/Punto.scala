package puntos

case class Punto(private var _x : Double=0, private var _y : Double=0) {
  
  def x=_x
  def y=_y
  
  def x_=(x:Double)= _x = x
  def y_=(y:Double)= _y = y
}