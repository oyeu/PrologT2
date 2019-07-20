package simulacion
import puntos._
import net.liftweb.json._
import scala.io.Source
import movil._
object Simulacion extends App with Runnable{
  override def run(){
   val ruta = "./src/"
   val archivo = "parametros.json"
   val cadena = parse(ruta + archivo)//Source.fromFile(ruta+archivo).getLines().mkString
   println(cadena)
   
   /*while (true){
     
   }*/
  }
  run()
  
}