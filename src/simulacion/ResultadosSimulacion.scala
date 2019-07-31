package simulacion
import scalax.collection.Graph
import scalax.collection.GraphPredef._, scalax.collection.GraphEdge._
import scalax.collection.edge.WDiEdge
import scalax.collection.edge.Implicits._
import scalax.collection.GraphTraversal._
import scalax.collection.GraphLike
import puntos._
import movil._

class ResultadosSimulacion {
  def longitudPromedio(grafo:Graph[Punto,WDiEdge]):Double ={
    val longitudes=for(x<-grafo.edges) yield x.weight
    longitudes.sum/longitudes.size
  }
  
  def distanciaRecorrida(vehiculos:Array[Vehiculo],grafo:Graph[Punto,WDiEdge]):Array[Double]={
   type T = grafo.NodeT
   val distancias =for(x<-vehiculos) yield (grafo.get(x.posicion).shortestPathTo(grafo.get(x.destino))).get.weight 
   distancias
  }
}