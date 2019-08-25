package rectas

protected case class Sentido(var _isDobleVia : Boolean) {
  def isDobleVia = _isDobleVia
}

object Sentido {
  def dobleVia : Sentido = {
    Sentido(true)
  }
  
  def unaVia : Sentido = {
    Sentido(false)
  }
}

