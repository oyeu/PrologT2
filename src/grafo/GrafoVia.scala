package grafo
import math.sqrt , math.pow
import puntos._
import rectas._
import scalax.collection.Graph
import scalax.collection.GraphPredef._, scalax.collection.GraphEdge._
import scalax.collection.edge.WDiEdge
import scalax.collection.edge.Implicits._
import scalax.collection.GraphTraversal._
import scalax.collection.GraphLike
import scala.util.Random
import scala.collection.mutable.ArrayBuffer


object GrafoVia {
  var _g = Graph[Interseccion,WDiEdge]()
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
  
  /*def rutaMasCorta(a:Interseccion,b:Interseccion,grafo:Graph[Interseccion,WDiEdge]):List[Punto] = {
    type T = grafo.NodeT
    val a1:T=grafo.get(a)
    val a3:T=grafo.get(b)
    val fin=a1.shortestPathTo(a3).get.nodes.map(_.toOuter).toList
    fin
  }*/
  
  val rutas =(intersecciones:Array[(String,Interseccion)],grafo:Graph[Interseccion,WDiEdge],vias:Array[Via],cantidad:Int) => {
    type T = grafo.NodeT
    val r = new Random()
    var rutas = ArrayBuffer[Array[(Boolean,Via)]]()
    for (i<-0 to cantidad-1){
      val origen = intersecciones(r.nextInt(intersecciones.length))._2
      var destino = intersecciones(r.nextInt(intersecciones.length))._2
      while (origen==destino) destino = intersecciones(r.nextInt(intersecciones.length))._2
      val a1:T=grafo.get(origen)
      val a2:T=grafo.get(destino)
      val ruta = a1.shortestPathTo(a2).get.edges.map(_.toOuter).toList
      var conjuntovias:Array[(Boolean,Via)] = camino(ruta,vias) 
      rutas.append(conjuntovias)
    }
    rutas.toArray
  }
  
  val camino=(path: List[WDiEdge[Interseccion]],vias:Array[Via]) => {
    type T = ArrayBuffer[(Boolean,Via)]
    var conjuntovias:T =ArrayBuffer[(Boolean,Via)]()
    for (x<-path){
        val origen = x._1
        val fin = x._2
        val via=vias.find(x=>x.origen==origen && x.fin==fin)
        via match{
          case Some(Via(_,_))=> conjuntovias.append((true,via.get))
          case None => conjuntovias.append((false,vias.find(x=>x.origen==fin && x.fin==origen).get))
        }
    }
    conjuntovias.toArray
  }
  
}


