package grafo
import math.sqrt , math.pow
import puntos._
import rectas.Via
import scalax.collection.Graph
import scalax.collection.GraphPredef._, scalax.collection.GraphEdge._
import scalax.collection.edge.WDiEdge
import scalax.collection.edge.Implicits._
import scalax.collection.GraphTraversal._
import scalax.collection.GraphLike


object GrafoVia {
  var _g = Graph[Punto,WDiEdge]()
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
  
  def rutaMasCorta(a:Punto,b:Punto,grafo:Graph[Punto,WDiEdge]):List[Punto] = {
    type T = grafo.NodeT
    val a1:T=grafo.get(a)
    val a3:T=grafo.get(b)
    val fin=a1.shortestPathTo(a3).get.nodes.map(_.toOuter).toList
    fin
  }
  
}


