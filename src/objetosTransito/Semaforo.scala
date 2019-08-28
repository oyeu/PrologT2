package objetosTransito
import puntos._

case class Semaforo(val tiempoVerde : Int,val interseccion:Interseccion) {
  private var _estado : String = "Rojo"
  
  def estado =  _estado
  
  def cambiarEstado = _estado match{
    case "Amarillo" => _estado = "Rojo"
    case "Rojo" => _estado = "Verde"
    case "Verde" => _estado = "Amarillo"
  }
}