package movil
import puntos._

trait MovimientoUniforme {
  val posicion : Punto
  val velocidad : Velocidad
  var camino:List[Punto]
  var fin:Boolean

  def mover(dt:Int):Unit = fin match{
    case true =>{val epsilon=50
                 if(math.sqrt((math.pow(posicion.x-camino.head.x, 2)+math.pow(posicion.y-camino.head.y,2)))<epsilon) {
                  posicion.x_=(camino.head.x)
                  posicion.y_=(camino.head.y)
                  camino=camino.drop(1)
                  camino.isEmpty match{
                    case true => fin=false
                    case false=> velocidad.direccion.valor_=(posicion,camino.head)
                  }
                 }
                 else {
                  posicion.x = posicion.x + velocidad.vx*dt
                  posicion.y= posicion.y + velocidad.vy*dt
                }
    }
    case false => 
  }
}