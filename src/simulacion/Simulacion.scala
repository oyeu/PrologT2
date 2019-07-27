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
   val grafito = GrafoVia
   val intersecciones = Interseccion.cargarIntersecciones
   val vias = Via.cargarVias(intersecciones)
   val vehiculos =  Vehiculo.crearVehiculos(50, 40, Array(0.4,0.3,0.15,0.1,0.05),intersecciones)
   grafito.construir(vias)
   val g = new GraficaTest(vias)
   Grafica.agregarCarros(vehiculos)
   
  
   
   
   
   
   
   
   
   
   
   
   
   
  // for(x<-vehiculos) println(s"${x.posicion} con placas ${x.placa} con destino a ${x.destino}")
  //println(s"En total hay ${vehiculos.length} vehiculos")
  }
  run()
  
}