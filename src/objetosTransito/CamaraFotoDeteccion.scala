package objetosTransito

import rectas.Via
import puntos.Punto
import movil.Viaje
class CamaraFotoDeteccion(via : Via) {
  val punto : Punto = new Punto((via.origen.x+via.fin.x)/2,(via.origen.y+via.fin.y)/2)
  
  def revisarVia(viajes:Array[Viaje]) = {
    val vehiculosEnVia = viajes.filter(_.viaActual.equals(via)).map(_.vehiculo)
    val multados = vehiculosEnVia.filter(_.velocidad.magnitud > via.velMax)
    multados.foreach(Comparendo(_,via))
  }
}