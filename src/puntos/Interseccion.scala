package puntos
import scala.collection.mutable.ArrayBuffer

class Interseccion(x: Int,y: Int, _nombre : String = "") extends Punto(x,y){
  override def toString() : String = {
    nombre
  }
  def nombre=_nombre
}


