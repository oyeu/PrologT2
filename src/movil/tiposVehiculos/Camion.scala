package movil.tiposVehiculos
import movil._
import puntos._
import java.awt.Color
class Camion(ubicacion : Punto, velocidad : Velocidad,placa : String) extends Vehiculo(ubicacion,velocidad,placa){
  val color = Color.YELLOW
  val forma = "Cuadrar"
}