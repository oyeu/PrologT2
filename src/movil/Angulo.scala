package movil
import puntos._
import math._

case class Angulo (var _valor:Double = 0){
  def valor_=(tupla:(Punto,Punto)) ={
    val rad=math.atan2(math.abs(tupla._2.y-tupla._1.y),math abs (tupla._2.x-tupla._1.x))
    tupla match{
    case (p1,p2) if(p1.y == p2.y && p1.x < p2.x) => _valor=0
    case (p1,p2) if(p2.x > p1.x  && p2.y > p1.y) => _valor=Angulo.toGrade(rad)
    case (p1,p2) if(p1.x == p2.x && p2.y > p1.y) => _valor=90
    case (p1,p2) if(p1.x > p2.x  && p2.y > p1.y) => _valor=180-Angulo.toGrade(rad)
    case (p1,p2) if(p1.x > p2.x  && p1.y== p2.y) => _valor=180
    case (p1,p2) if(p1.x > p2.x  && p1.y > p2.y) => _valor=180+Angulo.toGrade(rad)
    case (p1,p2) if(p1.x == p2.x && p1.y > p2.y) => _valor=270
    case (p1,p2) if(p1.x < p2.x  && p1.y > p2.y) => _valor=360-Angulo.toGrade(rad)
  }
  }
  def valor = _valor
  
} 
object Angulo {
  def toGrade(x:Double):Double=(x*180)/math.Pi
}
  
