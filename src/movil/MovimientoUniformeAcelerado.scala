package movil
import puntos._
import rectas._

trait MovimientoUniformeAcelerado {
  var posicion : Punto
  var velocidad : Velocidad
  
  val mover=(dt:Int)=>{
    posicion.x=posicion.x+velocidad.vx*dt
    posicion.y=posicion.y+velocidad.vy*dt
  }
}