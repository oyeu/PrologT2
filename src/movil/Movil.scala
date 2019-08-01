package movil
import puntos._


abstract class Movil (val posicion : Punto,val  velocidad : Velocidad, private var _camino:List[Punto]){
  velocidad.direccion.valor_=(posicion,camino.head)
  private var _fin:Boolean = true
  def mover(dt:Int):Unit
  def getAngulo = velocidad.direccion.valor
  def camino=_camino
  def fin = _fin
  def camino_=(cam:List[Punto])=_camino=cam
  def fin_=(bol:Boolean)= _fin=bol
  
}