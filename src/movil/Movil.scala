package movil
import puntos._

abstract class Movil (p : Punto, v : Velocidad){
  
  def mover(dt:Int):Unit
  
  def getAngulo = v.direccion.valor
}