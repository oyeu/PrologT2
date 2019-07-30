package movil
import puntos._


abstract class Movil (var posicion : Punto,var  velocidad : Velocidad){
  
  def mover(dt:Int):Unit
  
  def getAngulo = velocidad.direccion.valor
}