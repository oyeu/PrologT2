package rectas

protected class Sentido {
  var isDobleVia : Boolean = _
}

object Sentido {
  def dobleVia : Sentido = {
    var aux = new Sentido
    aux.isDobleVia = true
    aux
  }
  
  def unaVia : Sentido = {
    var aux = new Sentido
    aux.isDobleVia = false
    aux 
  }
}

