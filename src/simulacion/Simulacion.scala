package simulacion
import puntos._
import scala.io.Source
import movil._
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


object Simulacion extends App with Runnable{
  override def run(){
   var t=0
   var dt=1
   var tRefresh = 1
   val grafito = GrafoVia
   val intersecciones = Interseccion.cargarIntersecciones
   val vias = Via.cargarVias(intersecciones)
   val vehiculos =  Vehiculo.crearVehiculos(50, 40, Array(0.4,0.3,0.15,0.1,0.05),intersecciones)
   grafito.construir(vias)
   //val g = new GraficaTest(vias)
   Grafica.agregarCarros(vehiculos)
   println(grafito)
   val (n1,n2) = (-8,-8)
   println(n2-n1)
   
     println(grafito.g)
   
   
  
   
   
   
   
   
   
   
   
   
   
   
   
  // for(x<-vehiculos) println(s"${x.posicion} con placas ${x.placa} con destino a ${x.destino}")
  //println(s"En total hay ${vehiculos.length} vehiculos")
  }
  run()
  
}