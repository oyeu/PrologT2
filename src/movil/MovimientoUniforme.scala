package movil
import puntos.Punto

trait MovimientoUniforme {
  var posicion:Punto
  var velocidad:Velocidad
  def mover(dt:Int):Unit = {
    posicion.x= posicion.x + velocidad.vx*dt
    posicion.y= posicion.y + velocidad.vy*dt}
}