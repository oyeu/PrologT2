package rectas
import puntos._
import math._

case class Angulo (var _valor:Double = 0){
  def valor = _valor
  def valor_=(valorn:Double) = _valor = valorn
}
object Angulo {
  def toGrade(x:Double):Double=(x*180)/math.Pi
  
  val calcularAngulo=(tupla:(Punto,Punto)) =>{
    val angulo=toGrade(math.atan2(math.abs(tupla._2.y-tupla._1.y),math abs (tupla._2.x-tupla._1.x)))
    tupla match{
    case (p1,p2) if(p1.y == p2.y && p1.x < p2.x) => 0
    case (p1,p2) if(p2.x > p1.x  && p2.y > p1.y) => angulo
    case (p1,p2) if(p1.x == p2.x && p2.y > p1.y) => 90
    case (p1,p2) if(p1.x > p2.x  && p2.y > p1.y) => 180-angulo
    case (p1,p2) if(p1.x > p2.x  && p1.y== p2.y) => 180
    case (p1,p2) if(p1.x > p2.x  && p1.y > p2.y) => 180+angulo
    case (p1,p2) if(p1.x == p2.x && p1.y > p2.y) => 270
    case (p1,p2) if(p1.x < p2.x  && p1.y > p2.y) => 360-angulo
    }
  }
  
  val anguloOpuesto=(via:Via)=>{
    via.angulo match{
      case Angulo(0) => 180
      case Angulo(valor) if(valor>0 && valor<90)=> valor+180
      case Angulo(90)=> 90+180
      case Angulo(valor) if(valor>90 && valor<180)=>valor+180
      case Angulo(180)=>0
      case Angulo(valor) if(valor>180 && valor<270)=>valor-180
      case Angulo(270)=>90
      case Angulo(valor) if(valor>270 && valor<360)=>valor-180
    }
  }
    
}

  
