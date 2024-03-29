package simulacion
import puntos._
import objetosTransito.NodoSemaforo
import objetosTransito.Comparendo
import conexion.Conexion
import scala.collection.mutable.ArrayBuffer
import objetosTransito.Semaforo
import scala.io.Source
import movil._
import movil.tiposVehiculos._
import grafo._
import rectas._
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.data.xy.XYSeriesCollection
import org.jfree.data.xy.XYSeries
import org.jfree.chart.plot.PlotOrientation
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
import org.jfree.chart.annotations.XYTextAnnotation
import org.jfree.chart.axis.CategoryAxis
import util.control.Breaks._
import json._
import resultados.ResultadoIntersecciones
import parametros._
import resultados._
import scalax.collection.Graph
import scalax.collection.GraphPredef._, scalax.collection.GraphEdge._
import scalax.collection.edge.WDiEdge
import scalax.collection.edge.Implicits._
import scalax.collection.GraphTraversal._
import scalax.collection.GraphLike
import java.util.Random
import objetosTransito.CamaraFotoDeteccion

object Simulacion extends App with Runnable{
  
   val json = new Json()
   var parametros = json.cargarDatos()
   var t=0
   var dt= parametros.dt
   var tRefresh = parametros.tRefresh
   //Conexion.insertarDatosViales() //DESCOMENTAR ESTA LINEA LA PRIMERA VEZ QUE SE EJECUTE PARA AÑADIR DATOS A NEO4J
   val grafito = GrafoVia
   val intersecciones = Conexion.obtenerIntersecciones()
   val vias = Conexion.obtenerVias()
   val tiempoVerde =  (Math.random()*parametros.semaforos.minTiempoVerde) + parametros.semaforos.maxTiempoVerde
   val tiempoAmarillo = parametros.semaforos.tiempoAmarillo
   for(i <- vias){
     i.semaforoD = Semaforo(tiempoVerde.toInt,i.fin)
     if(i.sentido.isDobleVia){
       i.semaforoO = Semaforo(tiempoVerde.toInt,i.origen)

     }
   }
   var nodosSemaforos = NodoSemaforo.nodosSemaforos(intersecciones,vias,tiempoAmarillo)
   grafito.construir(vias)
   val vehiculos =  Vehiculo.crearVehiculos(parametros.vehiculos.minimo, parametros.velocidad.minimo, 
       Array(parametros.proporciones.carros, parametros.proporciones.motos, parametros.proporciones.buses, parametros.proporciones.camiones,
           parametros.proporciones.motoTaxis),parametros.vehiculos.maximo,parametros.velocidad.maximo)
   val rutas =grafito.rutas(intersecciones.toArray,grafito.g,vias,vehiculos.length)
   val viajes =Viaje.crearViajes(vehiculos,rutas)
   val cantCarro = vehiculos.filter(_.isInstanceOf[Carro]).length
   val cantMoto = vehiculos.filter(_.isInstanceOf[Moto]).length
   val cantBus = vehiculos.filter(_.isInstanceOf[Bus]).length
   val cantCamion = vehiculos.filter(_.isInstanceOf[Camion]).length
   val cantMotoTaxi = vehiculos.filter(_.isInstanceOf[MotoTaxi]).length
   val cantVehiculos = vehiculos.length
   val viasDobleSentido = vias.filter(_.sentido.isDobleVia).length
   val viasUnSentido = vias.filter(!_.sentido.isDobleVia).length
   val cantVias = vias.length
   val longitudProm = {val longitudes=for(x<-grafito.g.edges.toEdgeInSet) yield x.weight
    longitudes.sum/longitudes.size}
   val cantIntersecciones = intersecciones.size
   val resultInter = ResultadoIntersecciones(50,46,5,3)
   val b = grafito.g.edges
   val resulV = ResultadoVehiculos(cantVehiculos,cantCarro,cantMoto,cantBus,cantCamion,cantMotoTaxi)
   val malla = ResultadoMallaVial(cantVias,cantIntersecciones,viasUnSentido,viasDobleSentido,50,100,longitudProm.toInt,resultInter)
   val time = ResultadoTiempos(150,12)
   val vel = ResultadoVelocidades(97,51,77)
   val dist = ResultadoDistancias(100,100,100)
   val prom = 10.4//{val porcentaje = for(x <- Comparendo.listaComparendos) yield 100*x.velVehiculo/x.velMax-100)}
   val comp = ResultadoComparendos(Comparendo.listaComparendos.size,prom)
   val resultados = ResultadosSimulacion(resulV,malla,time,vel,dist,comp)
   //json.escribirDatos(resultados)
   
   val camaras =  {
     var arreglo = ArrayBuffer[CamaraFotoDeteccion]()
     for(i <- vias){
       arreglo += new CamaraFotoDeteccion(i)
     }
     arreglo
   }
   run()
   
   override def run(){
   Grafica.graficarVias(vias)
   Grafica.graficarCamaras(camaras.toArray)
   Grafica.graficarVehiculos(vehiculos)
     while(true){
       viajes.map(_.movimiento(dt))
       t=t+dt
       nodosSemaforos.map(_.incrementarTiempo)
       Grafica.graficarVehiculos(vehiculos)
       var cont=0
       for (x<-viajes) if(x.fin) cont+=1
       if(cont==viajes.length) {println(t); break}
       Thread.sleep(tRefresh)
     }
   
  }
}