package rectas
import puntos.Interseccion

class Via(private var origen1 : Interseccion,private var fin1 : Interseccion) extends Recta{
  type T = Interseccion
  var origen = origen1
  var fin = fin1
}