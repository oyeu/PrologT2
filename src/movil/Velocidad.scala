package velocidad
import scala.math

case class Velocidad(magnitud : Int)(direccion : Angulo) {
  
  def vx = magnitud*math.cos(direccion.valor)
  def vy = magnitud*math.sin(direccion.valor)
}