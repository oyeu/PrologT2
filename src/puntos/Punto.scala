package puntos

abstract class Punto(var _x : Int, var _y : Int) {
  
  def x=_x
  def y=_y
  
  def x_=(x:Int)= _x = x
  def y_=(y:Int)= _y = y
}