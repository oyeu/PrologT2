package movil.tiposVehiculos
import movil._
import puntos._
class Moto(placa:String)(posicion:Punto,velocidad:Velocidad,aceleracion:Int) extends Vehiculo(placa)(posicion,velocidad,aceleracion){
}
object Moto {
  def generarPlaca : String = {
    val alfabeto = Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
        'W','X','Y','Z')
    val r = scala.util.Random
    val l1 = alfabeto(r.nextInt(9))
    val l2 = alfabeto(r.nextInt(9))
    val l3 = alfabeto(r.nextInt(9))
    val l4 = alfabeto(r.nextInt(9))
    val n1 = r.nextInt(10)
    val n2 = r.nextInt(10)
    val retornoL = Array(l1,l2,l3).mkString("")
    val retornoN = Array(n1,n2).mkString("")
    retornoL.concat(retornoN).concat(l4.toString())
  }
}