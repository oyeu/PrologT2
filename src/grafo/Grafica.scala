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
import javax.swing.JFrame
import javax.swing.JPanel
import java.util.Random

object Grafica extends JFrame{
  var datos : XYSeriesCollection = new XYSeriesCollection()
  
  
  val grafica = ChartFactory.createScatterPlot("simuMed", "", "", datos, PlotOrientation.VERTICAL, false, false ,false);
  
  def graficarVias(arreglo : Array[Via]) : Unit = {
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
    val rendered = new XYLineAndShapeRenderer()
    for(i <- 0 to datos.getSeries.size() + 1) rendered.setSeriesPaint(i, Color.LIGHT_GRAY)
    for(i <- 0 to datos.getSeries.size() + 1) rendered.setSeriesStroke(i, new BasicStroke(4f))
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
        textAnnotaion.setPaint(new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat()))
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
    var panel = Grafica.obtienePanel()
    this.setSize(2000,600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(panel);
    this.setVisible(true);
  
  }
  
  def graficarVehiculos(vehiculos:Array[Vehiculo])={
    for(x<-vehiculos) {
      var vehi : XYSeries = new XYSeries(x.placa)
      vehi.add(x.posicion.x + 300, x.posicion.y + 300)
      datos.addSeries(vehi)
    }
    var panel = Grafica.obtienePanel()
    this.setSize(2000,600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(panel);
    this.setVisible(true);
  }
  
  def obtienePanel() = {
    new ChartPanel(grafica)
  }
  
}

