package puntos
import scala.collection.mutable.ArrayBuffer

class Interseccion(x: Double,y: Double, _nombre : Option[String]) extends Punto(x,y){

  def nombre=_nombre.getOrElse("sin nombre")
  override def toString() : String =nombre
}
object Interseccion {
  def cargarIntersecciones:Map[String,Interseccion] = {
    var intersecciones = Map("niquia" ->new Interseccion(300, 12000, Some("Niquia")),
  "lauraAuto" -> new Interseccion(2400, 11400, Some("M. Laura Auto")),
  "lauraReg" -> new Interseccion(2400, 12600, Some("M. Laura Reg")),
  "ptoCero" -> new Interseccion(5400, 12000, Some("Pto 0")),
  "mino" -> new Interseccion(6300, 15000, Some("Minorista")),
  "villa" -> new Interseccion(6300, 19500, Some("Villanueva")),
  "ig65" -> new Interseccion(5400, 10500, Some("65 Igu")),
  "robledo" -> new Interseccion(5400, 1500, Some("Exito Rob")),
  "colReg" -> new Interseccion(8250, 12000, Some("Col Reg")),
  //"colFerr" -> new Interseccion(8250, 15000, Some("Col Ferr")),
  "col65" -> new Interseccion(8250, 10500, Some("Col 65")),
  "col80" -> new Interseccion(8250, 1500, Some("Col 80")),
  "juanOr" -> new Interseccion(10500, 19500, Some("Sn Juan Ori")),  
  "maca" ->new Interseccion(10500, 12000, Some("Macarena")),
  "expo" -> new Interseccion(12000, 13500, Some("Exposiciones")),
  "reg30" -> new Interseccion(13500, 15000, Some("Reg 30")),
  "monte" -> new Interseccion(16500, 15000, Some("Monterrey")),
  "agua" -> new Interseccion(19500, 15000, Some("Aguacatala")),
  "viva" -> new Interseccion(21000, 15000, Some("Viva Env")),
  "mayor" -> new Interseccion(23400, 15000, Some("Mayorca") ),
  "ferrCol" -> new Interseccion(8250, 15000, Some("Ferr Col")),
  "ferrJuan" -> new Interseccion(10500, 15000, Some("Alpujarra")),
  "sanDiego" -> new Interseccion(12000, 19500, Some("San Diego")),
  "premium" -> new Interseccion(13500, 19500, Some("Premium")),
  "pp" -> new Interseccion(16500, 19500, Some("Parque Pob")),
  "santafe" -> new Interseccion(19500, 18750, Some("Santa Fe")),
  "pqEnv" -> new Interseccion(21000, 18000, Some("Envigado")),
  "juan65" -> new Interseccion(10500, 10500, Some("Juan 65")),
  "juan80" -> new Interseccion(10500, 1500, Some("Juan 80")),
  "_33_65" -> new Interseccion(12000, 10500, Some("33 con 65")),
  "bule" -> new Interseccion(12000, 7500, Some("Bulerias")),
  "gema" -> new Interseccion(12000, 1500, Some("St Gema")),
  "_30_65" -> new Interseccion(13500, 10500, Some("30 con 65")),
  "_30_70" -> new Interseccion(13500,4500, Some("30 con 70")),
  "_30_80" -> new Interseccion(13500, 1500, Some("30 con 80")),
  "bol65" -> new Interseccion(11100, 10500, Some("Boliv con 65")),
  "gu10" -> new Interseccion(16500, 12000, Some("Guay con 10")),
  "terminal" -> new Interseccion(16500, 10500, Some("Term Sur")),
  "gu30" -> new Interseccion(13500, 12000, Some("Guay 30")),
  "gu80" -> new Interseccion(19500, 12000, Some("Guay 80")),
  "_65_80" -> new Interseccion(19500, 10500, Some("65 con 30")),
  "gu_37S" -> new Interseccion(21000, 12000, Some("Guay con 37S")))

  intersecciones
  }

}
