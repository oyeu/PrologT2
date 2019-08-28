package movil
import rectas._
import puntos._
import objetosTransito._
import scala.collection.mutable.ArrayBuffer

class Viaje (val _vehiculo:Vehiculo, var _ruta:Array[(Boolean,Via)]){
  var _semaforoDestino:Semaforo = null
  var _destino:Interseccion=null
  Viaje.alinear(this)
  var viaActual = ruta.head._2
  var _fin = false
  def semaforo = _semaforoDestino
  def fin = _fin
  def destino = _destino
  def vehiculo = _vehiculo
  def ruta = _ruta
  def fin_=(nuevo:Boolean)=_fin=nuevo
  def ruta_=(ruta:Array[(Boolean,Via)])=_ruta=ruta
  def semaforoDestino_=(sem:Semaforo)=_semaforoDestino=sem
  def destino_=(interseccion:Interseccion) = _destino =interseccion
  val movimiento=(dt:Int)=>{
    fin match{
      case false =>{
        if(semaforo.estado.equals("Amarillo")&&(Viaje.distancia(this)<20)) {
          vehiculo.mover(dt,false)
          val epsilon = 20
          if(Viaje.distancia(this)<epsilon){
          ruta=(ruta.drop(1))
          if(ruta.isEmpty) {fin=true;vehiculo.cambioPosicion(destino)}
          else Viaje.alinear(this)
          }
        }
        else if ((semaforo.estado.equals("Amarillo")||semaforo.estado.equals("Rojo"))&&Viaje.distancia(this)<40){
          vehiculo.tasaAceleracion match {
            case x if(x<0)=>{
              vehiculo.mover(dt,true)
              println("frenando")
            }
            case _=>{
              vehiculo.tasaAceleracion=vehiculo.calcularTasaFrenado(Viaje.distancia(this))
              vehiculo.mover(dt,true)
              println("estoy frenando")
            }
          }
        }
        else {
          vehiculo.mover(dt,false)
          val epsilon =20
          if(Viaje.distancia(this)<epsilon){
          ruta=(ruta.drop(1))
          if(ruta.isEmpty) {fin=true;vehiculo.cambioPosicion(destino)}
          else Viaje.alinear(this)
          }
          println("pausa")
        }
      }
      case true =>
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
    if(v.ruta.head._1){
      v.vehiculo.velocidad.direccion.valor_=(v.ruta.head._2.angulo.valor)
      v.vehiculo.cambioPosicion(v.ruta.head._2.origen)
      v.semaforoDestino_=(v.ruta.head._2.semaforoD)
      v.destino_=(v.ruta.head._2.fin)}
    else{
      v.vehiculo.velocidad.direccion.valor_=(Angulo.anguloOpuesto(v.ruta.head._2))
      v.vehiculo.cambioPosicion(v.ruta.head._2.fin)
      v.semaforoDestino_=(v.ruta.head._2.semaforoO)
      v.destino_=(v.ruta.head._2.origen)} 
  }
  val distancia=(v:Viaje)=> {
    val dist = Math.sqrt(Math.pow(v.destino.x-v.vehiculo.posicion.x, 2)+Math.pow(v.destino.y-v.vehiculo.posicion.y, 2))
    dist
  }
  
}
