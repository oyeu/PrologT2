package simulacion
import puntos._
import movil._
object Simulacion extends App with Runnable{
  override def run(){
    val inter = new Movil(new Ubicacion(10,10),new Velocidad(87,new Angulo(9))) {
      def mover (dt:Int)= 1+dt
    }
    println(inter.getAngulo)
  }
  run()
  
}