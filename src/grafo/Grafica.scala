package grafo
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.data.xy.XYSeriesCollection
import org.jfree.data.xy.XYSeries
import org.jfree.chart.plot.PlotOrientation
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
import org.jfree.chart.annotations.XYTextAnnotation
import org.jfree.chart.axis.CategoryAxis
import java.awt.Color
import java.awt.BasicStroke
import rectas.Via
import scala.collection.mutable.ArrayBuffer
import puntos._
import movil._
import movil.tiposVehiculos._
import javax.swing.JFrame
import javax.swing.JPanel
import java.util.Random
import org.jfree.util.ShapeUtilities
object Grafica extends JFrame{
  var datos : XYSeriesCollection = new XYSeriesCollection()
  
  
  val grafica = ChartFactory.createScatterPlot("simuMed", "", "", datos, PlotOrientation.VERTICAL, false, false ,false);
  val rendered = new XYLineAndShapeRenderer()
  val carros:XYSeries = new XYSeries("carros")
  val motos:XYSeries = new XYSeries("motos")
  val camiones:XYSeries = new XYSeries("camiones")
  val motoTaxis:XYSeries = new XYSeries("motoTaxis")
  val buses:XYSeries = new XYSeries("buses")
  
  def graficarVias (arreglo : Array[Via]){
        for(a <- arreglo){
      val s = new XYSeries(a.toString())
      var x = a.origen.x.toDouble
      var y = a.origen.y.toDouble
      s.add(a.origen.x,a.origen.y)
      var auxX = true
      var auxY = true
      s.add(a.fin.x.toInt,a.fin.y.toInt)
      datos.addSeries(s)
    }
    val plot = grafica.getXYPlot()
    for(i <- 0 to datos.getSeries.size() ) rendered.setSeriesPaint(i, Color.LIGHT_GRAY)
    for(i <- 0 to datos.getSeries.size() ) rendered.setSeriesStroke(i, new BasicStroke(4f))
    var array = new ArrayBuffer[String]()
    val agregarAnotaciones = (via : Via) => {
      if(!array.contains(via.origen.nombre)){
        val textAnnotaion = new XYTextAnnotation(via.origen.nombre, via.origen.x, via.origen.y);
        plot.addAnnotation(textAnnotaion);
        array.+=:(via.origen.nombre)
      }
      if(!array.contains(via.fin.nombre)){
        val textAnnotaion = new XYTextAnnotation(via.fin.nombre, via.fin.x, via.fin.y);
        val rand = new Random();
        textAnnotaion.setPaint(via.fin.Color)
        plot.addAnnotation(textAnnotaion);
        array.+=:(via.fin.nombre)
      }
    }
    arreglo.foreach(agregarAnotaciones(_))
    val categoryAxisD  = plot.getDomainAxis();
    categoryAxisD.setAxisLineVisible(false);
    categoryAxisD.setTickMarksVisible(false);
    categoryAxisD.setVisible(false);
    val categoryAxisR  = plot.getRangeAxis();
    categoryAxisR.setAxisLineVisible(false);
    categoryAxisR.setTickMarksVisible(false);
    categoryAxisR.setVisible(false);
    plot.setDomainGridlinesVisible(false)
    plot.setRangeGridlinesVisible(false)
    plot.setBackgroundPaint(Color.white)
    plot.setRenderer(rendered)
  
    datos.addSeries(carros)
    datos.addSeries(motos)
    datos.addSeries(camiones)
    datos.addSeries(buses)
    datos.addSeries(motoTaxis)
    var panel = Grafica.obtienePanel()
    this.setSize(2000,600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(panel);
    this.setVisible(true);
  }

  def graficarVehiculos (vehiculos:Array[Vehiculo]){
    carros.clear()
    motos.clear()
    camiones.clear()
    buses.clear()
    motoTaxis.clear()
    val arregloCarros = vehiculos.filter(_.isInstanceOf[movil.tiposVehiculos.Carro])
    val arregloMotos = vehiculos.filter(_.isInstanceOf[movil.tiposVehiculos.Moto])
    val arregloCamiones = vehiculos.filter(_.isInstanceOf[movil.tiposVehiculos.Camion])
    val arregloMotoTaxi = vehiculos.filter(_.isInstanceOf[MotoTaxi])
    val arregloBus = vehiculos.filter(_.isInstanceOf[movil.tiposVehiculos.Bus])
    for(x<-arregloCarros) {
      carros.add(x.posicion.x, x.posicion.y)
    }
    for(x<-arregloCamiones) {
      camiones.add(x.posicion.x, x.posicion.y)
    }
    for(x<-arregloMotoTaxi) {
      motoTaxis.add(x.posicion.x, x.posicion.y)
    }
    for(x<-arregloBus) {
      buses.add(x.posicion.x, x.posicion.y)
    }
    for(x<-arregloMotos) {
      motos.add(x.posicion.x, x.posicion.y)
    }
    
    val plot = grafica.getXYPlot()
    
    rendered.setSeriesLinesVisible(datos.getSeriesCount - 1, false)
    rendered.setSeriesPaint(datos.getSeriesCount - 1, Color.BLACK)
    rendered.setSeriesShapesVisible(datos.getSeriesCount - 1, true)
    rendered.setSeriesShape(datos.getSeriesCount - 1, ShapeUtilities.createRegularCross(5, 5))
    
    
    rendered.setSeriesLinesVisible(datos.getSeriesCount - 2, false)
    rendered.setSeriesPaint(datos.getSeriesCount - 2, Color.ORANGE)
    rendered.setSeriesShapesVisible(datos.getSeriesCount - 2, true)
    rendered.setSeriesShape(datos.getSeriesCount - 2, ShapeUtilities.createDiagonalCross(5, 5))
    
    
    rendered.setSeriesLinesVisible(datos.getSeriesCount - 3, false)
    rendered.setSeriesPaint(datos.getSeriesCount - 3, Color.YELLOW)
    rendered.setSeriesShapesVisible(datos.getSeriesCount - 3, true)
    rendered.setSeriesShape(datos.getSeriesCount - 3, ShapeUtilities.createUpTriangle(5))
    
    
    rendered.setSeriesLinesVisible(datos.getSeriesCount - 4, false)
    rendered.setSeriesPaint(datos.getSeriesCount - 4, Color.GREEN)
    rendered.setSeriesShapesVisible(datos.getSeriesCount - 4, true)
    rendered.setSeriesShape(datos.getSeriesCount - 4, ShapeUtilities.createDiagonalCross(5, 5))
    
    
    rendered.setSeriesLinesVisible(datos.getSeriesCount - 5, false)
    rendered.setSeriesPaint(datos.getSeriesCount - 5, Color.RED)
    rendered.setSeriesShapesVisible(datos.getSeriesCount - 5, true)
    rendered.setSeriesShape(datos.getSeriesCount - 5, ShapeUtilities.createDiamond(5))
    
    
    
  }
  
  def obtienePanel() = {
    new ChartPanel(grafica)
  }  
}


