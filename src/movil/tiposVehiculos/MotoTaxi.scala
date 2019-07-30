package movil.tiposVehiculos
import movil._
import java.awt.Color
import puntos._

class MotoTaxi(ubicacion : Punto,destino:Interseccion, velocidad : Velocidad,placa : String) extends Vehiculo(ubicacion,None,velocidad,placa,destino){
  val color = Color.BLUE
  val forma = "Cuadrar"

}
object MotoTaxi {
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
    retornoN.concat(retornoL)
  }
}