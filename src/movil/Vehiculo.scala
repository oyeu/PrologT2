package movil
import puntos._
import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import movil.tiposVehiculos._

abstract class Vehiculo (var posicion : Punto, var velocidad : Velocidad, p: String, _destino:Punto) extends Movil(posicion, velocidad) with MovimientoUniforme{
  def placa = p
  def destino = _destino
}

object Vehiculo {
  def crearVehiculos(minV:Int,Vmin:Int,proporciones:Array[Double],intersecciones:Map[String,Interseccion]):Array[Vehiculo]={
    val anguloinicial = new Angulo(0) 
    var vehiculos:ArrayBuffer[Vehiculo] = ArrayBuffer()
    val inter = intersecciones.toArray
    var numAutos = scala.util.Random.nextInt(minV)+minV
    val totalVehiculos = for(x<-proporciones) yield (x*numAutos).round.toInt
    numAutos = totalVehiculos.reduce(_+_)
    
    //se crean los Carros
    for (i <- 0 to totalVehiculos(0)-1){
      val vel = scala.util.Random.nextInt(Vmin)
      val origen = inter(scala.util.Random.nextInt(inter.length-1))._2
      val destino = inter(scala.util.Random.nextInt(inter.length-1))._2
      vehiculos += new Carro(origen,destino,new Velocidad(vel,anguloinicial),Carro.generarPlaca)
    }
    //se crean las motos
    for (i <- 0 to totalVehiculos(1)-1){
      val vel = scala.util.Random.nextInt(Vmin)
      val origen = inter(scala.util.Random.nextInt(inter.length-1))._2
      val destino = inter(scala.util.Random.nextInt(inter.length-1))._2
      vehiculos += new Moto(origen,destino,new Velocidad(vel,anguloinicial),Moto.generarPlaca)
    }
    //se crean los buses
    for (i <- 0 to totalVehiculos(2)-1){
      val vel = scala.util.Random.nextInt(Vmin)
      val origen = inter(scala.util.Random.nextInt(inter.length-1))._2
      val destino = inter(scala.util.Random.nextInt(inter.length-1))._2
      vehiculos += new Bus(origen,destino,new Velocidad(vel,anguloinicial),Bus.generarPlaca)
    }
    //se crean los Camiones
    for (i <- 0 to totalVehiculos(3)-1){
      val vel = scala.util.Random.nextInt(Vmin)
      val origen = inter(scala.util.Random.nextInt(inter.length-1))._2
      val destino = inter(scala.util.Random.nextInt(inter.length-1))._2
      vehiculos += new Camion(origen,destino,new Velocidad(vel,anguloinicial),Camion.generarPlaca)
    }
    
    for (i <- 0 to totalVehiculos(4)-1){
      val vel = scala.util.Random.nextInt(Vmin)
      val origen = inter(scala.util.Random.nextInt(inter.length-1))._2
      val destino = inter(scala.util.Random.nextInt(inter.length-1))._2
      vehiculos += new MotoTaxi(origen,destino,new Velocidad(vel,anguloinicial),MotoTaxi.generarPlaca)
    }
    vehiculos.toArray
  }
}

