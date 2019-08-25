package movil
import puntos._
import rectas._

trait MovimientoUniforme {
  var posicion : Punto
  var velocidad : Velocidad
  var fin:Boolean

  def mover(dt:Int):Unit = dt+1
}