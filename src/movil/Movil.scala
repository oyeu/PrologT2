package movil
import puntos._


abstract class Movil (var posicion : Punto,var  velocidad : Velocidad,var tasaAceleracion:Int){
  val aceleracion = tasaAceleracion
  val mover:(Int)=>Unit
  def getAngulo = velocidad.direccion.valor
  val velcrucero=()=>tasaAceleracion=0
  val acelerar=()=>tasaAceleracion=aceleracion
  val cambioPosicion=(punto:Punto)=>{
    posicion.x=(punto.x)
    posicion.y=(punto.y)
  }
  val calcularTasaFrenado=1
  
}