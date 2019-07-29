package movil
import puntos._
import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import movil.tiposVehiculos._

abstract class Vehiculo (pos : Punto, vel : Velocidad, p: String, _destino:Punto) extends Movil(pos, vel) with MovimientoUniforme{
  def placa = p
  def destino = _destino
  val color : java.awt.Color
}

object Vehiculo {
  def crearVehiculos(minV:Int,Vmin:Int,proporciones:Array[Double],intersecciones:Map[String,Interseccion],maxV : Int, Vmax : Int):Array[Vehiculo]={
     var vehiculos = ArrayBuffer[Vehiculo]()
     val inter = intersecciones.toArray
     var numAutos = (Math.random()*minV) + maxV
     val totalVehiculos = for(x<-proporciones) yield (x*numAutos).round.toInt
     var contador = 0
     val rand = new Random();
     for(i <- totalVehiculos){
       for(j <- 0 to i){
         val vel = (rand.nextInt((Vmax - Vmin)) + Vmin).toInt
         val origen = inter((rand.nextInt((inter.length)).toInt))._2
         val destino = inter((rand.nextInt((inter.length)).toInt))._2
         vehiculos += seleccionarVehiculo(contador)
       
         def seleccionarVehiculo(i : Int) : Vehiculo = i match {
           case 0 => new Carro(origen,destino,new Velocidad(vel,Angulo()),Carro.generarPlaca)
           case 1 => new Moto(origen,destino,new Velocidad(vel,Angulo()),Moto.generarPlaca)
           case 2 => new Bus(origen,destino,new Velocidad(vel,Angulo()),Bus.generarPlaca)
           case 3 => new Camion(origen,destino,new Velocidad(vel,Angulo()),Camion.generarPlaca)
           case _ => new MotoTaxi(origen,destino,new Velocidad(vel,Angulo()),MotoTaxi.generarPlaca)
         }
       }
       contador+=1
     }
     vehiculos.toArray
  }
}
