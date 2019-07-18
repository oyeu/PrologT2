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

object Grafica {
  var datos : XYSeriesCollection = new XYSeriesCollection()
  val grafica = ChartFactory.createScatterPlot("", "", "", datos, PlotOrientation.VERTICAL, false, false ,false);
  
  def agregarGrafica(arreglo : Array[Via]) : Unit = {
    val convertir = (a : Via) => {
      val s = new XYSeries(a.origen.toString().concat(a.fin.toString()))
      var x = a.origen.x.toDouble
      var y = a.origen.y.toDouble
      s.add(a.origen.x,a.origen.y)
      var auxX = true
      var auxY = true
      while(auxX || auxY){ 
        if(a.origen.x < a.fin.x && x < a.fin.x){
          x+=(math.abs(a.origen.x - a.fin.x)) / (math.sqrt(math.pow(a.origen.x - a.fin.x, 2)+math.pow(a.origen.y - a.fin.y, 2)))
        }else if(a.origen.x > a.fin.x && x > a.fin.x){
          x-=(math.abs(a.origen.x - a.fin.x)) / (math.sqrt(math.pow(a.origen.x - a.fin.x, 2)+math.pow(a.origen.y - a.fin.y, 2)))
        }
        if(a.origen.y < a.fin.y && y < a.fin.y){
          y+=(math.abs(a.origen.y - a.fin.y)) / (math.sqrt(math.pow(a.origen.x - a.fin.x, 2)+math.pow(a.origen.y - a.fin.y, 2)))
        }else if(a.origen.y > a.fin.y && y > a.fin.y){
          y-=(math.abs(a.origen.y - a.fin.y)) / (math.sqrt(math.pow(a.origen.x - a.fin.x, 2)+math.pow(a.origen.y - a.fin.y, 2)))
        }
        
        if(x.toInt == a.fin.x - 1 || x.toInt == a.fin.x + 1 || x.toInt == a.fin.x){
          auxX = false
        }
        if(y.toInt == a.fin.y - 1 || y.toInt == a.fin.y + 1 || y.toInt == a.fin.y){
          auxY = false
        }
        s.add(x,y)
      }
      datos.addSeries(s)
    }
    arreglo.foreach(convertir(_))
    
    val plot = grafica.getXYPlot()
    val rendered = new XYLineAndShapeRenderer()
    for(i <- 0 to datos.getSeries.size() + 1) rendered.setSeriesPaint(i, Color.LIGHT_GRAY)
    for(i <- 0 to datos.getSeries.size() + 1) rendered.setSeriesStroke(i, new BasicStroke(7f))
    
    plot.setDomainGridlinesVisible(false)
    plot.setRangeGridlinesVisible(false)
    plot.setBackgroundPaint(Color.white)
    plot.setRenderer(rendered)
  }
  
  def obtienePanel() = {
    new ChartPanel(grafica)
  }
}


