package movil
import scala.math
import rectas.Angulo

case class Velocidad(var magnitud:Double=0,direccion:Angulo,val velcrucero:Double) {
  
  def vx = Velocidad.kmPorM(magnitud)*math.cos(direccion.valor.toRadians)
  def vy = Velocidad.kmPorM(magnitud)*math.sin(direccion.valor.toRadians)
  val acelerar=(tasaAceleracion:Double)=> if(tasaAceleracion+magnitud>velcrucero) magnitud=velcrucero else magnitud=magnitud+tasaAceleracion
  val frenar=(tasaAceleracion:Double)=>if(magnitud+tasaAceleracion<0) magnitud=0 else magnitud=magnitud+tasaAceleracion
}

object Velocidad {
  def mPorKm(cantidad : Double) : Double = {
    cantidad * 3.6
  }
  
  def kmPorM(cantidad : Double) : Double = {
    val metrosPorSegundo:Double = ((cantidad *5)/18)
    metrosPorSegundo
  }
}