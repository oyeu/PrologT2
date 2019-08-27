package movil
import puntos._
import rectas._

trait MovimientoUniformeAcelerado {
  var posicion : Punto
  var velocidad : Velocidad
  var tasaAceleracion:Int
  
  val mover=(dt:Int)=>{
    if (velocidad.magnitud==velocidad.velcrucero){
      posicion.x=posicion.x+velocidad.vx*dt
      posicion.y=posicion.y+velocidad.vy*dt
    }else {
      
    }
  }
}