package movil.tiposVehiculos
import movil._
import java.awt.Color
import puntos._

class Carro(ubicacion : Punto, velocidad : Velocidad,placa : String) extends Vehiculo(ubicacion,velocidad,placa){
  val color = Color.BLACK
  val forma = "Cuadrar"
}