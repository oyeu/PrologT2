package movil
import puntos._

abstract class Movil (p : Punto, v : Velocidad){
  var destino:Option[Interseccion]
  def mover(dt:Int):Unit
  
  def getAngulo = v.direccion.valor
}