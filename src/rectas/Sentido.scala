package rectas

protected case class Sentido(var isDobleVia : Boolean) {
}

object Sentido {
  def dobleVia : Sentido = {
    Sentido(true)
  }
  
  def unaVia : Sentido = {
    Sentido(false)
  }
}

