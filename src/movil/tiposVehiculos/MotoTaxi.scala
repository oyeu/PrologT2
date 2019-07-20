package movil.tiposVehiculos
import movil._
import java.awt.Color
import puntos._

class MotoTaxi(ubicacion : Punto, velocidad : Velocidad,placa : String) extends Vehiculo(ubicacion,velocidad,placa){
  val color = Color.BLUE
  val forma = "Cuadrar"
}