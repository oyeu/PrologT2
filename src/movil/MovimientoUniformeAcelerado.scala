package movil
import puntos._
import rectas._

trait MovimientoUniformeAcelerado {
  var posicion : Punto
  var velocidad : Velocidad
  var tasaAceleracion:Double
  val velcrucero:()=>Unit
  val acelerar:()=>Unit
  
  val mover=(dt:Int,frenar:Boolean)=>{
    frenar match{
      case false =>{
        if (velocidad.magnitud==velocidad.velcrucero){
          velcrucero()
          posicion.x=posicion.x+velocidad.vx*dt
          posicion.y=posicion.y+velocidad.vy*dt
        }else {
          acelerar()
          velocidad.acelerar(tasaAceleracion)
          posicion.x=posicion.x+velocidad.vx*dt
          posicion.y=posicion.y+velocidad.vy*dt
        }
      }case true=>{
        velocidad.frenar(tasaAceleracion)
        posicion.x=velocidad.magnitud+posicion.x+(tasaAceleracion/2)
        posicion.y=velocidad.magnitud+posicion.y+(tasaAceleracion/2)
        
      }
    }
    
  }
}