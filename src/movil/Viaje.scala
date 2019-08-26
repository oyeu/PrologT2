package movil
import rectas._
import puntos._
import scala.collection.mutable.ArrayBuffer

class Viaje (val _vehiculo:Vehiculo, var _ruta:Array[(Boolean,Via)]){
  var _destino:Interseccion = Viaje.alinear(this)
  var viaActual = ruta.head._2
  var _fin = false
  def fin = _fin
  def fin_=(nuevo:Boolean)=_fin=nuevo
  def destino = _destino
  def vehiculo = _vehiculo
  def ruta = _ruta
  def ruta_=(ruta:Array[(Boolean,Via)])=_ruta=ruta
  def destino_=(interseccion:Interseccion) = _destino =interseccion
  val movimiento=(dt:Int)=>{
    fin match{
      case false =>{
        vehiculo.mover(dt)
        val epsilon = 300
        if(math.sqrt((math.pow(vehiculo.posicion.x-destino.x, 2)+math.pow(vehiculo.posicion.y-destino.y,2)))<epsilon){
          ruta=(ruta.drop(1))
          if(ruta.isEmpty) {fin=true;vehiculo.cambioPosicion(destino)}
          else destino=(Viaje.alinear(this))
        }
      }
      case true=>s"El viaje del carro ${vehiculo.placa} ha terminado"
    }   
  }
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
  val alinear =(v:Viaje)=> {
    if(v.ruta.head._1){v.vehiculo.velocidad.direccion.valor_=(v.ruta.head._2.angulo.valor);v.vehiculo.cambioPosicion(v.ruta.head._2.origen);v.ruta.head._2.fin}
    else{v.vehiculo.velocidad.direccion.valor_=(Angulo.anguloOpuesto(v.ruta.head._2));v.vehiculo.cambioPosicion(v.ruta.head._2.fin);v.ruta.head._2.origen} 
  }
}
