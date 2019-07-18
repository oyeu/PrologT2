package rectas

trait Recta {
  type T <: puntos.Punto
  val origen : T
  val fin : T
}