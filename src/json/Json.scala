package json
import puntos._

import resultados._
import parametros._
import java.io._
import scala.io.Source
import movil._
import movil.tiposVehiculos._
import grafo._
import rectas._
import net.liftweb.json._
import net.liftweb.json.JsonDSL._
import simulacion._
import scala.reflect.ManifestFactory.classType


class Json{
  
  def cargarDatos(): Parametros = {
    implicit val formats = DefaultFormats
    val url = "./src/"
    val archivo = "parametros.json"
    val cadena: String = Source.fromFile(url+archivo).getLines.mkString
    val json = parse(cadena)
    val parametros = json.extract[Parametros]
    parametros
  }
  
  def escribirDatos(resultados: ResultadosSimulacion) = {
    
    val json =
      ("resultadosSimulacion" ->
        ("vehiculos" ->
          ("total" -> resultados.vehiculos.total) ~
          ("carros" -> resultados.vehiculos.carros) ~
          ("motos" -> resultados.vehiculos.motos) ~
          ("buses" -> resultados.vehiculos.buses) ~
          ("camiones" -> resultados.vehiculos.camiones) ~
          ("motoTaxis" -> resultados.vehiculos.motoTaxis)) ~
          
        ("mallaVial" -> 
          ("vias" -> resultados.mallaVial.vias) ~
          ("intersecciones" -> resultados.mallaVial.intersecciones) ~
          ("viasUnSentido" -> resultados.mallaVial.viasUnSentido) ~
          ("viasDobleSentido" -> resultados.mallaVial.viasDobleSentido) ~
          ("velocidadMinima" -> resultados.mallaVial.velocidadMinima) ~
          ("velocidadMaxima" -> resultados.mallaVial.velocidadMaxima) ~
          ("longitudPromedio" -> resultados.mallaVial.longitudPromedio) ~
          ("vehiculosEnInterseccion" ->
            ("promedioOrigen" -> resultados.mallaVial.vehiculosEnInterseccion.promedioOrigen) ~
            ("promedioDestino" -> resultados.mallaVial.vehiculosEnInterseccion.promedioDestino) ~
            ("sinOrigen" -> resultados.mallaVial.vehiculosEnInterseccion.sinOrigen) ~
            ("sinDestino" -> resultados.mallaVial.vehiculosEnInterseccion.sinDestino))) ~
        
        ("tiempo" ->
          ("simulacion" -> resultados.tiempos.simulacion) ~
          ("realidad" -> resultados.tiempos.realidad)) ~
          
        ("velocidades" ->
          ("minima" -> resultados.velocidades.minima) ~
          ("maxima" -> resultados.velocidades.maxima) ~
          ("promedio" -> resultados.velocidades.promedio)) ~
          
        ("distancias" ->
          ("minima" -> resultados.distancias.minima) ~
          ("maxima" -> resultados.distancias.maxima) ~
          ("promedio" -> resultados.distancias.promedio)) ~
        ("comparendos" ->
          ("cantidad" -> resultados.comparendos.cantidad) ~
          ("promedioPorcentajeExceso" -> resultados.comparendos.promedioPorcentajeExceso)))
  
    println(prettyRender(json))
    println(json.toString())
    val fw = new FileWriter("./src/resultadosSimulacion.json")
    
    fw.write(json.toString())
    fw.close()
  }
}
  
  /*def escribirDatos(ruta: String, resultados: ResultadosSimulacion) = {
    implicit val formats = DefaultFormats
    import net.liftweb.json.Serialization.write
    val pw = new PrintWriter(new File(ruta))
    pw.write(write(resultados))
    pw.close
  }*/