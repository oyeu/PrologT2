package objetosTransito
import movil.Vehiculo
import scala.collection.mutable.ArrayBuffer
import rectas.Via
protected class Comparendo(vehiculo : Vehiculo,velVehiculo : Int,velMax : Int, nombreVia : String) {
  
}

object Comparendo {
  
  var listaComparendos = ArrayBuffer[Comparendo]()
  def apply(vehiculo : Vehiculo, via : Via) = {
    val comparendo = new Comparendo(vehiculo,vehiculo.velocidad.magnitud,via.velMax,via._nombre)
    listaComparendos += comparendo
  }
}