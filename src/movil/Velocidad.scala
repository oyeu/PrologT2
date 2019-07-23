package movil
import scala.math

class Velocidad(magnitud : Int,_direccion : Angulo) {
  
  def vx = magnitud*math.cos(_direccion.valor).toInt
  def vy = magnitud*math.sin(_direccion.valor).toInt
  def direccion = _direccion
}

object Velocidad {
  def mPorKm(cantidad : Double) : Double = {
    cantidad * 3.6
  }
  
  def kmPorM(cantidad : Double) : Double = {
    cantidad / 3.6  
  }
}