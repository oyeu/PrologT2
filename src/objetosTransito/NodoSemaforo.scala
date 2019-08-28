package objetosTransito

import rectas.Via
import puntos._
import scala.collection.mutable.ArrayBuffer
class NodoSemaforo(arreglo : ArrayBuffer[Semaforo],tiempoAmarillo : Int,val inter:Interseccion) {
  private var semaforoActual = 0
  arreglo(semaforoActual).cambiarEstado
  private var tiempoTranscurrido = 0
  
  private def cambiarEstadoSemaforoActual = arreglo(semaforoActual).estado match{
    case "Verde" => arreglo(semaforoActual).cambiarEstado
    case "Amarillo" => {
      arreglo(semaforoActual).cambiarEstado
      cambiarSemaforoActual
      val semaforoActualI = arreglo(semaforoActual)
        if(semaforoActualI != null)  arreglo(semaforoActual).cambiarEstado  
      }
    }
  
  
  private def cambiarSemaforoActual = {
    if(semaforoActual + 1 < arreglo.length){
      semaforoActual += 1
    }else{
      semaforoActual = 0
    }
  }
  
  def incrementarTiempo = {
    tiempoTranscurrido +=1
    val semaforoActualI = arreglo(semaforoActual)
    if(semaforoActualI != null){
    if(arreglo(semaforoActual).estado == "Verde"){
      if(tiempoTranscurrido > arreglo(semaforoActual).tiempoVerde){
        cambiarEstadoSemaforoActual
        tiempoTranscurrido = 0
      }
    }else{
      if(tiempoTranscurrido > tiempoAmarillo){
        cambiarEstadoSemaforoActual
        tiempoTranscurrido = 0
      }
    }
    }
  }
  
  def getArreglo = arreglo
}
object NodoSemaforo {
  val nodosSemaforos = (intersecciones : Map[String,Interseccion],
                        vias:Array[Via],tAmarillo : Int) => {
   var nodosSemaforos = ArrayBuffer[NodoSemaforo]()
   for(i <- intersecciones){
     var Semaforos = ArrayBuffer[Semaforo]()
     for(j <- vias){
       if(j.origen.equals(i._2)){
         Semaforos += j.semaforoO
       }
     }
     for(j <- vias){
       if(j.fin.equals(i._2)){
         Semaforos += j.semaforoD
       }
     }
     if(!Semaforos.isEmpty){
       nodosSemaforos += new NodoSemaforo(Semaforos,tAmarillo,i._2)
     }
   }
   
   nodosSemaforos
  }
}