package movil
import puntos._


abstract class Movil (var posicion : Punto,var  velocidad : Velocidad, var camino:List[Punto]){
  
  def mover(dt:Int):Unit
  
  def getAngulo = velocidad.direccion.valor
  
  var fin:Boolean = true
}