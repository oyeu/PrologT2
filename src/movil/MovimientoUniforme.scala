package movil
import puntos._
import rectas._

trait MovimientoUniforme {
  var posicion : Punto
  var velocidad : Velocidad
  var tasaaceleracion:Int

  def mover(dt:Int):Unit = {
        posicion.x_=(posicion.x + velocidad.vx*dt)
        posicion.y_=(posicion.y + velocidad.vy*dt)
  }
}