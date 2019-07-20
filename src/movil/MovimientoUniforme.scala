package movil
import puntos._

trait MovimientoUniforme extends Movil{

  def mover(dt:Int):Unit = {
    posicion.x= posicion.x + velocidad.vx*dt
    posicion.y= posicion.y + velocidad.vy*dt}
}