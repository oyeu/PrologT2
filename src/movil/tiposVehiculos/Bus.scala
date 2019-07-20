package movil.tiposVehiculos
import movil._
import puntos._
import java.awt.Color
class Bus(ubicacion : Punto, velocidad : Velocidad,placa : String) extends Vehiculo(ubicacion,velocidad,placa){
  val color = Color.RED
  val forma = "Cuadrar"
}