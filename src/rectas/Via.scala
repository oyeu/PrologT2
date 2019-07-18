package rectas
import puntos.Interseccion

class Via(origenR : Interseccion, finR : Interseccion,velMax : Int,
          tipo : TipoVia,val sentido : Sentido,numero : String,val nombre : String) extends Recta{
  type T = Interseccion
  val origen = origenR
  val fin = finR
}