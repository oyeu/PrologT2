package movil
import rectas._
import scala.collection.mutable.ArrayBuffer

class Viaje (_vehiculo:Vehiculo, _ruta:Array[(Boolean,Via)]){
  def vehiculo=_vehiculo
  def ruta = _ruta
}
object Viaje {
  val crearViajes = (vehiculos:Array[Vehiculo],rutas:Array[Array[(Boolean, Via)]]) => {
    var i=0
    var viajes = ArrayBuffer[Viaje]()
    for(x <-vehiculos){
      viajes+=new Viaje(x,rutas(i))
      i+=1
    }
    viajes.toArray    
  }
}
