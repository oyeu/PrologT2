package movil
import puntos._
import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import movil.tiposVehiculos._
import grafo._



abstract class Vehiculo (pos : Punto, vel : Velocidad, p: String, _destino:Punto, camino:List[Punto]) extends Movil(pos, vel,camino) with MovimientoUniforme{
  def placa = p
  val color : java.awt.Color
  def destino=_destino
  vel.direccion.valor_=(pos,camino.head)
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
         var destino = inter((rand.nextInt((inter.length)).toInt))._2
         while(origen==destino){
           destino = inter((rand.nextInt((inter.length)).toInt))._2
         }
         val coordenada = new Coordenada(origen.x,origen.y)
         val camino = GrafoVia.rutaMasCorta(origen, destino, GrafoVia.g).drop(1)
         vehiculos += seleccionarVehiculo(contador)
         def seleccionarVehiculo(i : Int) : Vehiculo = i match {
           case 0 => new movil.tiposVehiculos.Carro(coordenada,destino,new Velocidad(vel,Angulo()),Carro.generarPlaca,camino)
           case 1 => new movil.tiposVehiculos.Moto(coordenada,destino,new Velocidad(vel,Angulo()),Moto.generarPlaca,camino)
           case 2 => new movil.tiposVehiculos.Bus(coordenada,destino,new Velocidad(vel,Angulo()),Bus.generarPlaca,camino)
           case 3 => new movil.tiposVehiculos.Camion(coordenada,destino,new Velocidad(vel,Angulo()),Camion.generarPlaca,camino)
           case _ => new MotoTaxi(coordenada,destino,new Velocidad(vel,Angulo()),MotoTaxi.generarPlaca,camino)
         }
       }
       contador+=1
     }
     vehiculos.toArray
  }
}
