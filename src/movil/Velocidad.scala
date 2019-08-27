package movil
import scala.math
import rectas.Angulo

case class Velocidad(var magnitud:Int=0,direccion:Angulo,val velcrucero:Int) {
  
  def vx = magnitud*math.cos(direccion.valor.toRadians)
  def vy = magnitud*math.sin(direccion.valor.toRadians)
  val acelerar=(tasaAceleracion:Int)=> if(tasaAceleracion+magnitud>velcrucero) magnitud=velcrucero else magnitud=magnitud+tasaAceleracion
  val frenar=(tasaAceleracion:Int)=>if(magnitud-tasaAceleracion<0) magnitud=0 else magnitud=magnitud-tasaAceleracion
}

object Velocidad {
  def mPorKm(cantidad : Double) : Double = {
    cantidad * 3.6
  }
  
  def kmPorM(cantidad : Double) : Double = {
    cantidad / 3.6  
  }
}