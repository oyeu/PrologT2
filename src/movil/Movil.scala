package movil
import puntos.Punto

abstract class Movil (posicion:Punto, velocidad:Velocidad){
  
  def mover(dt:Int):Unit
  
  def getAngulo = velocidad.direccion.valor
}