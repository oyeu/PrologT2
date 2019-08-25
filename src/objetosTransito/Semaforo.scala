package objetosTransito

class Semaforo(val tiempoVerde : Int,_nombre : String) {
  private var _estado : String = "Rojo"
  
  def estado =  _estado
  def nombre = _nombre
  
  def cambiarEstado = _estado match{
    case "Amarillo" => _estado = "Rojo"
    case "Rojo" => _estado = "Verde"
    case "Verde" => _estado = "Amarillo"
  }
}