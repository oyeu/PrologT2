package movil
import puntos._


abstract class Movil (var posicion : Punto,var  velocidad : Velocidad,var tasaAceleracion:Double){
  val aceleracion = tasaAceleracion
  val mover:(Int,Boolean)=>Unit
  def getAngulo = velocidad.direccion.valor
  val velcrucero=()=>tasaAceleracion=0
  val acelerar=()=>tasaAceleracion=aceleracion
  val cambioPosicion=(punto:Punto)=>{
    posicion.x=(punto.x)
    posicion.y=(punto.y)
  }
  val calcularTasaFrenado=(distancia:Double)=>{
    val tasa = ((math.pow(Velocidad.kmAM(velocidad.magnitud), 2))/(2*distancia))*(-1)
    tasa
  }
  
}