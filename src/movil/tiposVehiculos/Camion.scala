package movil.tiposVehiculos
import movil._
import puntos._
class Camion(placa:String)(posicion:Punto,velocidad:Velocidad) extends Vehiculo(placa)(posicion,velocidad){
}
object Camion {
  def generarPlaca : String = {
    val alfabeto = Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
        'W','X','Y','Z')
    val r = scala.util.Random
    val n1 = r.nextInt(10)
    val n2 = r.nextInt(10)
    val n3 = r.nextInt(10)
    val n4 = r.nextInt(10)
    val n5 = r.nextInt(10)
    val retornoN = Array(n1,n2,n3,n4,n5).mkString("")
    "R".concat(retornoN)
  }
}