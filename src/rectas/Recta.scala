package rectas
import puntos._

trait Recta {
  type T <: Punto
  val origen : T
  val fin : T
  var angulo:Angulo=Angulo()
  val calcular=()=>angulo.valor_=(Angulo.calcularAngulo(origen,fin))
  
}