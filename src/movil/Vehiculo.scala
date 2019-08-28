package movil
import puntos._
import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import movil.tiposVehiculos._
import grafo._
import rectas._

abstract case class Vehiculo (_placa: String)(_posicion:Punto, vel : Velocidad, aceleracion:Double) extends Movil(_posicion, vel,aceleracion) with MovimientoUniformeAcelerado{
  def placa = _placa
}

object Vehiculo {
  val crearVehiculos=(minV:Int,Vmin:Int,proporciones:Array[Double],maxV : Int, Vmax : Int)=>{
     var vehiculos = ArrayBuffer[Vehiculo]()
     var numAutos = 1//(Math.random()*minV) + maxV
     val totalVehiculos = for(x<-proporciones) yield (x*numAutos).round.toInt
     var contador = 0
     val rand = new Random();
     for(i <- totalVehiculos){
       for(j <- 0 to i){
         val vel = (rand.nextInt((Vmax - Vmin)) + Vmin).toInt
         val aceleracion = (rand.nextInt(15))+5
         vehiculos += seleccionarVehiculo(contador)
         
         def seleccionarVehiculo(i : Int) : Vehiculo = i match {
           case 0 => new movil.tiposVehiculos.Carro(Carro.generarPlaca)(new Punto(0,0),Velocidad(0,Angulo(),vel),aceleracion)
           case 1 => new movil.tiposVehiculos.Moto(Moto.generarPlaca)(new Punto(0,0),Velocidad(0,Angulo(),vel),aceleracion)
           case 2 => new movil.tiposVehiculos.Bus(Bus.generarPlaca)(new Punto(0,0),Velocidad(0,Angulo(),vel),aceleracion)
           case 3 => new movil.tiposVehiculos.Camion(Camion.generarPlaca)(new Punto(0,0),Velocidad(0,Angulo(),vel),aceleracion)
           case _ => new MotoTaxi(MotoTaxi.generarPlaca)(new Punto(0,0),Velocidad(0,Angulo(),vel),aceleracion)
         }
       }
       contador+=1
     }
     vehiculos.toArray
  }
}
