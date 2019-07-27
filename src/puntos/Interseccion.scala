package puntos
import scala.collection.mutable.ArrayBuffer

class Interseccion(x: Int,y: Int, _nombre : String = "") extends Punto(x,y){
  override def toString() : String = {
    nombre
  }
  def nombre=_nombre
}
object Interseccion {
  def cargarIntersecciones:Map[String,Interseccion] = {
    var intersecciones = Map("niquia" ->new Interseccion(300, 12000, "Niquia"),
  "lauraAuto" -> new Interseccion(2400, 11400, "M. Laura Auto"),
  "lauraReg" -> new Interseccion(2400, 12600, "M. Laura Reg"),
  "ptoCero" -> new Interseccion(5400, 12000, "Pto 0"),
  "mino" -> new Interseccion(6300, 15000, "Minorista"),
  "villa" -> new Interseccion(6300, 19500, "Villanueva"),
  "ig65" -> new Interseccion(5400, 10500, "65 Igu"),
  "robledo" -> new Interseccion(5400, 1500, "Exito Rob"),
  "colReg" -> new Interseccion(8250, 12000, "Col Reg"),
  "colFerr" -> new Interseccion(8250, 15000, "Col Ferr"),
  "col65" -> new Interseccion(8250, 10500, "Col 65"),
  "col80" -> new Interseccion(8250, 1500, "Col 80"),
  "juanOr" -> new Interseccion(10500, 19500, "Sn Juan Ori"),  
  "maca" ->new Interseccion(10500, 12000, "Macarena"),
  "expo" -> new Interseccion(12000, 13500, "Exposiciones"),
  "reg30" -> new Interseccion(13500, 15000, "Reg 30"),
  "monte" -> new Interseccion(16500, 15000, "Monterrey"),
  "agua" -> new Interseccion(19500, 15000, "Aguacatala"),
  "viva" -> new Interseccion(21000, 15000, "Viva Env"),
  "mayor" -> new Interseccion(23400, 15000, "Mayorca") ,
  "ferrCol" -> new Interseccion(8250, 15000, "Ferr Col"),
  "ferrJuan" -> new Interseccion(10500, 15000, "Alpujarra"),
  "sanDiego" -> new Interseccion(12000, 19500, "San Diego"),
  "premium" -> new Interseccion(13500, 19500, "Premium"),
  "pp" -> new Interseccion(16500, 19500, "Parque Pob"),
  "santafe" -> new Interseccion(19500, 18750, "Santa Fe"),
  "pqEnv" -> new Interseccion(21000, 18000, "Envigado"),
  "juan65" -> new Interseccion(10500, 10500, "Juan 65"),
  "juan80" -> new Interseccion(10500, 1500, "Juan 80"),
  "_33_65" -> new Interseccion(12000, 10500, "33 con 65"),
  "bule" -> new Interseccion(12000, 7500, "Bulerias"),
  "gema" -> new Interseccion(12000, 1500, "St Gema"),
  "_30_65" -> new Interseccion(13500, 10500, "30 con 65"),
  "_30_70" -> new Interseccion(13500,4500, "30 con 70"),
  "_30_80" -> new Interseccion(13500, 1500, "30 con 80"),
  "bol65" -> new Interseccion(11100, 10500, "Boliv con 65"),
  "gu10" -> new Interseccion(16500, 12000, "Guay con 10"),
  "terminal" -> new Interseccion(16500, 10500, "Term Sur"),
  "gu30" -> new Interseccion(13500, 12000, "Guay 30"),
  "gu80" -> new Interseccion(19500, 12000, "Guay 80"),
  "_65_80" -> new Interseccion(19500, 10500, "65 con 30"),
  "gu_37S" -> new Interseccion(21000, 12000, "Guay con 37S"))
  
  intersecciones
  }
  
}


