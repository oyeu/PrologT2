package rectas
import puntos.Punto

trait Recta {
  type T <: Punto
  var origen : T
  var fin : T
}