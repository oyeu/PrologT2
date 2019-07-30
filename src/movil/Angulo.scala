package movil
import puntos._
import math._

case class Angulo (var _valor:Double = 0){
  def valor_=(tupla:(Punto,Punto)) ={
    
    tupla match{
    case (p1,p2) if(p1.y == p2.y && p1.x < p2.x) => _valor=0
    case (p1,p2) if(p2.x > p1.x  && p2.y > p1.y) => _valor=Angulo.convertirRadianes(math.atan2(p2.y-p1.y, p2.x-p1.x))
    case (p1,p2) if(p1.x == p2.x && p2.y > p1.y) => _valor=90
    case (p1,p2) if(p1.x > p2.x  && p2.y > p1.y) => _valor=180-Angulo.convertirRadianes(math.atan2(math.abs(p2.y-p1.y), math.abs(p2.x-p1.x)))
    case (p1,p2) if(p1.x > p2.x  && p1.y== p2.y) => _valor=180
    case (p1,p2) if(p1.x > p2.x  && p1.y > p2.y) => _valor=180+Angulo.convertirRadianes(math.atan2(math.abs(p2.y-p1.y), math.abs(p2.x-p1.x)))
    case (p1,p2) if(p1.x == p2.x && p1.y > p2.y) => _valor=270
    case (p1,p2) if(p1.x < p2.x  && p1.y > p2.y) => _valor=360-Angulo.convertirRadianes(math.atan2(math.abs(p2.y-p1.y), math.abs(p2.x-p1.x)))
  }
  }
  def valor = _valor
  
} 
object Angulo {
  def convertirRadianes(x:Double):Double=(x*180)/math.Pi
}
  
