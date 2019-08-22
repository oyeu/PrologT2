package simulacion
import puntos._

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
import ResultadosSimulacion._
import parametros._
import resultados._
import scalax.collection.Graph
import scalax.collection.GraphPredef._, scalax.collection.GraphEdge._
import scalax.collection.edge.WDiEdge
import scalax.collection.edge.Implicits._
import scalax.collection.GraphTraversal._
import scalax.collection.GraphLike



object Simulacion extends App with Runnable{
  
   //implicit val formats = DefaultFormats
   //val readmeText : Iterator[String] = Source.fromFile("C:/Users/Daniel Gallego/Desktop/Proyecto/src/tests/ParametrosSimulacion.json").getLines
   //val json = parse(readmeText.toString())
    
   val json = new Json()
   var parametros = json.cargarDatos()
  //a.escribirDatos("C:/Users/Daniel Gallego/Desktop/PrologT2-master/src/" + "resultadosSimulacion.json", new ResultadosSimulacion(3))
     
   var t=0
   var dt= parametros.dt
   var tRefresh = parametros.tRefresh
   val grafito = GrafoVia
   val intersecciones = Interseccion.cargarIntersecciones
   val vias = Via.cargarVias(intersecciones)
   grafito.construir(vias)
   val vehiculos =  Vehiculo.crearVehiculos(parametros.vehiculos.minimo, parametros.velocidad.minimo, 
       Array(parametros.proporciones.carros, parametros.proporciones.motos, parametros.proporciones.buses, parametros.proporciones.camiones,
           parametros.proporciones.motoTaxis), intersecciones,parametros.vehiculos.maximo,parametros.velocidad.maximo)
   
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
   val resultados = ResultadosSimulacion(resulV,malla,time,vel,dist)
   json.escribirDatos(resultados)
   
   run()
   
   override def run(){
   Grafica.graficarVias(vias)
   Grafica.graficarVehiculos(vehiculos)
     while(true){
       vehiculos.map(_.mover(dt))
       t=t+dt
       Grafica.graficarVehiculos(vehiculos)
       var cont=0
       for (x<-vehiculos) if(!x.fin) cont+=1
       if(cont==vehiculos.length) {println(t); break}
       Thread.sleep(tRefresh)
     }
   
  }
   
}