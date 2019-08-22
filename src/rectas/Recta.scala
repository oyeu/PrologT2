package rectas
import puntos._

trait Recta {
  type T <: Punto
  val origen : T
  val fin : T
  val angulo:Angulo=Angulo(Angulo.calcularAngulo((origen,fin))) 
}