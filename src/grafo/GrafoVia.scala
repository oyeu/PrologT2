package grafo
import math.sqrt , math.pow
import puntos.Interseccion
import rectas.Via
import scalax.collection.Graph
import scalax.collection.edge.WDiEdge

object GrafoVia {
  private var _g = Graph[Interseccion,WDiEdge]()
  
  def g = _g
  
  def construir(arreglo : Array[Via]) = {
    val convertir = (a : Via) => {
        val origen = a.origen
        val fin = a.fin
        _g += WDiEdge(origen,fin)(sqrt(pow(origen.x - fin.x,2) + pow(origen.y-fin.y,2)))
        if(a.sentido.isDobleVia){
          _g += WDiEdge(fin,origen)(sqrt(pow(origen.x - fin.x,2) + pow(origen.y-fin.y,2)))
        }
        
      }
    arreglo.foreach(convertir(_))
  }

}


