package movil
import puntos._

abstract class Movil (posicion:Ubicacion, velocidad:Velocidad){
  
  def mover(dt:Int):Unit
  
  def getAngulo = velocidad.direccion.valor
}