package movil
import puntos._

abstract class Vehiculo (var posicion : Punto, var velocidad : Velocidad, p: String) extends Movil(posicion, velocidad) with MovimientoUniforme{
  
}

object Vehiculo {
 
}

