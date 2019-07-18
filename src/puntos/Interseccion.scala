package puntos
import scala.collection.mutable.ArrayBuffer
class Interseccion(x: Int,y: Int, nombre : String = "") extends Punto(x,y){
  override def toString() : String = {
    nombre
  }
}


