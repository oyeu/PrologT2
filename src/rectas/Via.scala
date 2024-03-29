package rectas
import puntos._
import scala.collection.mutable.ArrayBuffer
import objetosTransito.Semaforo

case class Via(origenR : Interseccion, finR : Interseccion)(_velMax : Int,
          tipo : TipoVia,val sentido : Sentido,numero : String,val _nombre : String) extends Recta{
  type T = Interseccion
  val origen:T = origenR
  val fin:T = finR
  var semaforoO : Semaforo = null
  var semaforoD : Semaforo = null
  calcular()
  def nombre=_nombre
  def velMax = _velMax
}
object Via{
  var vias = ArrayBuffer[Via]()
  
  def cargarVias(intersecciones:Map[String,Interseccion]):Array[Via] = {
     vias ++= ArrayBuffer(
     new Via(intersecciones.get("niquia").get, intersecciones.get("lauraAuto").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "64C", "Auto Norte"),
     new Via(intersecciones.get("niquia").get, intersecciones.get("lauraReg").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("lauraAuto").get, intersecciones.get("lauraReg").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "94", "Pte Madre Laura"),
     new Via(intersecciones.get("lauraAuto").get, intersecciones.get("ptoCero").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "64C", "Auto Norte"),
     new Via(intersecciones.get("lauraReg").get, intersecciones.get("ptoCero").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("ptoCero").get, intersecciones.get("mino").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "58", "Oriental"),
     new Via(intersecciones.get("mino").get, intersecciones.get("villa").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "58", "Oriental"),
     new Via(intersecciones.get("ptoCero").get, intersecciones.get("ig65").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "55", "Iguaná"),
     new Via(intersecciones.get("ig65").get, intersecciones.get("robledo").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "55", "Iguaná"),
     new Via(intersecciones.get("ptoCero").get, intersecciones.get("colReg").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("colReg").get, intersecciones.get("maca").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("maca").get, intersecciones.get("expo").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("expo").get, intersecciones.get("reg30").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("reg30").get,intersecciones.get("monte").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("monte").get, intersecciones.get("agua").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("agua").get,intersecciones.get("viva").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("viva").get, intersecciones.get("mayor").get)( 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
     new Via(intersecciones.get("mino").get, intersecciones.get("ferrCol").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "55", "Ferrocarril"),
     new Via(intersecciones.get("ferrCol").get, intersecciones.get("ferrJuan").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "55", "Ferrocarril"),
     new Via(intersecciones.get("ferrJuan").get,intersecciones.get("expo").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "55", "Ferrocarril"),
     new Via(intersecciones.get("villa").get, intersecciones.get("juanOr").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "46", "Oriental"),
     new Via(intersecciones.get("juanOr").get, intersecciones.get("sanDiego").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "46", "Oriental"),
     new Via(intersecciones.get("sanDiego").get, intersecciones.get("premium").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),
     new Via(intersecciones.get("premium").get, intersecciones.get("pp").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),
     new Via(intersecciones.get("pp").get, intersecciones.get("santafe").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),
     new Via(intersecciones.get("santafe").get,intersecciones.get("pqEnv").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),
     new Via(intersecciones.get("pqEnv").get, intersecciones.get("mayor").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),
     new Via(intersecciones.get("ferrCol").get, intersecciones.get("colReg").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "450", "Colombia"),
     new Via(intersecciones.get("colReg").get, intersecciones.get("col65").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "450", "Colombia"),
     new Via(intersecciones.get("col65").get, intersecciones.get("col80").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "450", "Colombia"),
     new Via(intersecciones.get("juanOr").get, intersecciones.get("ferrJuan").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "44", "Sn Juan"),
     new Via(intersecciones.get("ferrJuan").get, intersecciones.get("maca").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "44", "Sn Juan"),
     new Via(intersecciones.get("maca").get, intersecciones.get("juan65").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "44", "Sn Juan"),
     new Via(intersecciones.get("juan65").get, intersecciones.get("juan80").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "44", "Sn Juan"),
     new Via(intersecciones.get("sanDiego").get, intersecciones.get("expo").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "33", "33"),
     new Via(intersecciones.get("expo").get, intersecciones.get("_33_65").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "33", "33"),
     new Via(intersecciones.get("_33_65").get, intersecciones.get("bule").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "33", "33"),
     new Via(intersecciones.get("bule").get, intersecciones.get("gema").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "33", "33"),
     new Via(intersecciones.get("premium").get, intersecciones.get("reg30").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "30", "30"),
     new Via(intersecciones.get("reg30").get, intersecciones.get("_30_65").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "30", "30"),
     new Via(intersecciones.get("_30_65").get, intersecciones.get("_30_70").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "30", "30"),
     new Via(intersecciones.get("_30_70").get,intersecciones.get("_30_80").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "30", "30"),
     new Via(intersecciones.get("maca").get, intersecciones.get("bol65").get)( 60, TipoVia("Diagonal"), Sentido.dobleVia, "74B", "Boliv"),
     new Via(intersecciones.get("bol65").get, intersecciones.get("bule").get)( 60, TipoVia("Diagonal"), Sentido.dobleVia, "74B", "Boliv"),
     new Via(intersecciones.get("bule").get, intersecciones.get("_30_70").get)( 60, TipoVia("Diagonal"), Sentido.dobleVia, "74B", "Boliv"),
     new Via(intersecciones.get("juan80").get, intersecciones.get("bule").get)( 60, TipoVia("Transversal"), Sentido.dobleVia, "39B", "Nutibara"),
     new Via(intersecciones.get("pp").get, intersecciones.get("monte").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "10", "10"),
     new Via(intersecciones.get("monte").get, intersecciones.get("gu10").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "10", "10"),
     new Via(intersecciones.get("gu10").get, intersecciones.get("terminal").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "10", "10"),
     new Via(intersecciones.get("expo").get, intersecciones.get("gu30").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "52", "Av Guay"),
     new Via(intersecciones.get("gu30").get, intersecciones.get("gu10").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "52", "Av Guay"),
     new Via(intersecciones.get("gu10").get, intersecciones.get("gu80").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "52", "Av Guay"),
     new Via(intersecciones.get("gu80").get, intersecciones.get("gu_37S").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "52", "Av Guay"),
     new Via(intersecciones.get("lauraAuto").get, intersecciones.get("ig65").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "65", "65"),
     new Via(intersecciones.get("ig65").get, intersecciones.get("col65").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "65", "65"),
     new Via(intersecciones.get("juan65").get, intersecciones.get("col65").get)( 60, TipoVia("Carrera"), Sentido.unaVia, "65", "65"),
     new Via(intersecciones.get("bol65").get, intersecciones.get("juan65").get)( 60, TipoVia("Carrera"), Sentido.unaVia, "65", "65"),
     new Via(intersecciones.get("_33_65").get, intersecciones.get("bol65").get)( 60, TipoVia("Carrera"), Sentido.unaVia, "65", "65"),
     new Via(intersecciones.get("_30_65").get, intersecciones.get("_33_65").get)( 60, TipoVia("Carrera"), Sentido.unaVia, "65", "65"),
     new Via(intersecciones.get("_30_65").get, intersecciones.get("terminal").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "65", "65"),
     new Via(intersecciones.get("terminal").get, intersecciones.get("_65_80").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "65"),
     new Via(intersecciones.get("robledo").get, intersecciones.get("col80").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),
     new Via(intersecciones.get("col80").get, intersecciones.get("juan80").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),
     new Via(intersecciones.get("juan80").get, intersecciones.get("gema").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),
     new Via(intersecciones.get("gema").get, intersecciones.get("_30_80").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),
     new Via(intersecciones.get("_30_80").get, intersecciones.get("_65_80").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),
     new Via(intersecciones.get("_65_80").get, intersecciones.get("gu80").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),
     new Via(intersecciones.get("gu80").get, intersecciones.get("agua").get)( 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),
     new Via(intersecciones.get("agua").get, intersecciones.get("santafe").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "12S", "80"),
     new Via(intersecciones.get("viva").get, intersecciones.get("pqEnv").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "37S", "37S"),
     new Via(intersecciones.get("viva").get, intersecciones.get("gu_37S").get)( 60, TipoVia("Calle"), Sentido.dobleVia, "63", "37S"))
     vias.toArray
  }
}
