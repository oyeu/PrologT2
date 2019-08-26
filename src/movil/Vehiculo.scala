package movil
import puntos._
import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import movil.tiposVehiculos._
import grafo._
import rectas._

abstract case class Vehiculo (_placa: String)(_posicion:Punto, vel : Velocidad, aceleracion:Int) extends Movil(_posicion, vel,aceleracion) with MovimientoUniforme{
  def placa = _placa
}

object Vehiculo {
  def crearVehiculos(minV:Int,Vmin:Int,proporciones:Array[Double],maxV : Int, Vmax : Int):Array[Vehiculo]={
     var vehiculos = ArrayBuffer[Vehiculo]()
     var numAutos = (Math.random()*minV) + maxV
     val totalVehiculos = for(x<-proporciones) yield (x*numAutos).round.toInt
     var contador = 0
     val rand = new Random();
     for(i <- totalVehiculos){
       for(j <- 0 to i){
         val vel = (rand.nextInt((Vmax - Vmin)) + Vmin).toInt
         val aceleracion = (rand.nextInt(30))
         vehiculos += seleccionarVehiculo(contador)
         
         def seleccionarVehiculo(i : Int) : Vehiculo = i match {
           case 0 => new movil.tiposVehiculos.Carro(Carro.generarPlaca)(new Punto(0,0),new Velocidad(vel,Angulo()),aceleracion)
           case 1 => new movil.tiposVehiculos.Moto(Moto.generarPlaca)(new Punto(0,0),new Velocidad(vel,Angulo()),aceleracion)
           case 2 => new movil.tiposVehiculos.Bus(Bus.generarPlaca)(new Punto(0,0),new Velocidad(vel,Angulo()),aceleracion)
           case 3 => new movil.tiposVehiculos.Camion(Camion.generarPlaca)(new Punto(0,0),new Velocidad(vel,Angulo()),aceleracion)
           case _ => new MotoTaxi(MotoTaxi.generarPlaca)(new Punto(0,0),new Velocidad(vel,Angulo()),aceleracion)
         }
       }
       contador+=1
     }
     vehiculos.toArray
  }
}
