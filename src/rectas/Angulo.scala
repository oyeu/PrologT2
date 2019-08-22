package rectas
import puntos._
import math._

case class Angulo (var _valor:Double = 0){
  def valor = _valor
  def valor_=(valorn:Double) = _valor = valorn
}
object Angulo {
  def toGrade(x:Double):Double=(x*180)/math.Pi
  
  val calcularAngulo=(tupla:(Punto,Punto)) =>toGrade(math.atan2(math.abs(tupla._2.y-tupla._1.y),math abs (tupla._2.x-tupla._1.x)))
    
}

  
