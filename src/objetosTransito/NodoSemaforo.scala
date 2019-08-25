package objetosTransito

import rectas.Via

class NodoSemaforo(arreglo : Array[Semaforo],tiempoAmarillo : Int) {
  private var semaforoActual = 0
  arreglo(semaforoActual).cambiarEstado
  private var tiempoTranscurrido = 0
  
  private def cambiarEstadoSemaforoActual = arreglo(semaforoActual).estado match{
    case "Verde" => arreglo(semaforoActual).cambiarEstado
    case "Amarillo" => {
      arreglo(semaforoActual).cambiarEstado
      cambiarSemaforoActual
      arreglo(semaforoActual).cambiarEstado
    }
  }
  
  private def cambiarSemaforoActual = {
    if(semaforoActual + 1 < arreglo.length){
      semaforoActual = semaforoActual+1
    }else{
      semaforoActual = 0
    }
  }
  
  def incrementarTiempo = {
    tiempoTranscurrido +=1
    println(s"""${arreglo(semaforoActual).nombre} ${arreglo(semaforoActual).estado} ${tiempoTranscurrido}""")
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