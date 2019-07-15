package rectas
import puntos.Interseccion

class Via(origen1 : Interseccion,fin1 : Interseccion,val velocidadMaxima : Int,
          tipoVia : TipoVia,sentido : Sentido,numero : Int, nombre : String) extends Recta{
  type T = Interseccion
  var origen = origen1
  var fin = fin1
}