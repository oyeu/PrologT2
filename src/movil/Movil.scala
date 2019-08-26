package movil
import puntos._


abstract class Movil (var posicion : Punto,var  velocidad : Velocidad,var aceleracion:Int){
  var tasaaceleracion = aceleracion
  def mover(dt:Int):Unit
  def getAngulo = velocidad.direccion.valor
  val velcrucero=()=>aceleracion=0
  val salircrucero=()=>aceleracion=tasaaceleracion
  val cambioPosicion=(punto:Punto)=>{
    posicion.x=(punto.x)
    posicion.y=(punto.y)
  }
}