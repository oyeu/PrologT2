package movil.tiposVehiculos
import movil._
import puntos._
import java.awt.Color
class Bus(ubicacion : Punto, velocidad : Velocidad,placa : String) extends Vehiculo(ubicacion,velocidad,placa){
  val color = Color.RED
  val forma = "Cuadrar"
}

object Bus {
  def generarPlaca : String = {
    val alfabeto = Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
        'W','X','Y','Z')
    val r = scala.util.Random
    val l1 = alfabeto(r.nextInt(9))
    val l2 = alfabeto(r.nextInt(9))
    val l3 = alfabeto(r.nextInt(9))
    val n1 = r.nextInt(10)
    val n2 = r.nextInt(10)
    val n3 = r.nextInt(10)
    val retornoL = Array(l1,l2,l3).mkString("")
    val retornoN = Array(n1,n2,n3).mkString("")
    retornoL.concat(retornoN)
  }
}