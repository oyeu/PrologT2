package movil
import scala.math
import rectas.Angulo

case class Velocidad(var magnitud:Double=0,direccion:Angulo,val velcrucero:Double) {
  
  def vx = Velocidad.kmAM(magnitud)*math.cos(direccion.valor.toRadians)
  def vy = Velocidad.kmAM(magnitud)*math.sin(direccion.valor.toRadians)
  val acelerar=(tasaAceleracion:Double)=> if(Velocidad.mAKm(tasaAceleracion)+magnitud>velcrucero) magnitud=velcrucero else magnitud=magnitud+Velocidad.mAKm(tasaAceleracion)
  val frenar=(tasaAceleracion:Double)=>if(magnitud+Velocidad.mAKm(tasaAceleracion)<0) magnitud=0 else magnitud=magnitud+Velocidad.mAKm(tasaAceleracion)
}

object Velocidad {
  def mAKm(cantidad : Double) : Double = {
    val kilometrosPorSegundoCuadrado:Double = cantidad/1000
    kilometrosPorSegundoCuadrado
  }
  
  def kmAM(cantidad : Double) : Double = {
    val metrosPorSegundo:Double = ((cantidad *5)/18)
    metrosPorSegundo
  }
}