import grafo.GrafoVia
import rectas._
import puntos.Interseccion
import grafo.GraficaTest
import scala.collection.mutable.ArrayBuffer

object Borrar extends App {
  /*val grafito = GrafoVia
  val niquia =new Interseccion(300, 12000, "Niquia") 
  val lauraAuto = new Interseccion(2400, 11400, "M. Laura Auto")  
  val lauraReg = new Interseccion(2400, 12600, "M. Laura Reg")
  val ptoCero = new Interseccion(5400, 12000, "Pto 0") 
  val mino = new Interseccion(6300, 15000, "Minorista")
  val villa = new Interseccion(6300, 19500, "Villanueva")
  val ig65 = new Interseccion(5400, 10500, "65 Igu")  
  val robledo = new Interseccion(5400, 1500, "Exito Rob")
  val colReg = new Interseccion(8250, 12000, "Col Reg") 
  val colFerr = new Interseccion(8250, 15000, "Col Ferr")
  val col65 = new Interseccion(8250, 10500, "Col 65")
  val col80 = new Interseccion(8250, 1500, "Col 80") 
  val juanOr = new Interseccion(10500, 19500, "Sn Juan Ori")  
  val maca =new Interseccion(10500, 12000, "Macarena")
  val expo = new Interseccion(12000, 13500, "Exposiciones")
  val reg30 = new Interseccion(13500, 15000, "Reg 30")
  val monte = new Interseccion(16500, 15000, "Monterrey") 
  val agua = new Interseccion(19500, 15000, "Aguacatala")  
  val viva = new Interseccion(21000, 15000, "Viva Env")
  val mayor = new Interseccion(23400, 15000, "Mayorca") 
  val ferrCol = new Interseccion(8250, 15000, "Ferr Col")
  val ferrJuan = new Interseccion(10500, 15000, "Alpujarra")
  val sanDiego = new Interseccion(12000, 19500, "San Diego") 
  val premium = new Interseccion(13500, 19500, "Premium")  
  val pp = new Interseccion(16500, 19500, "Parque Pob")
  val santafe = new Interseccion(19500, 18750, "Santa Fe")  
  val pqEnv = new Interseccion(21000, 18000, "Envigado")
  val juan65 = new Interseccion(10500, 10500, "Juan 65")  
  val juan80 = new Interseccion(10500, 1500, "Juan 80") 
  val _33_65 = new Interseccion(12000, 10500, "33 con 65")  
  val bule = new Interseccion(12000, 7500, "Bulerias")
  val gema = new Interseccion(12000, 1500, "St Gema") 
  val _30_65 = new Interseccion(13500, 10500, "30 con 65")  
  val _30_70 = new Interseccion(13500,4500, "30 con 70")
  val _30_80 = new Interseccion(13500, 1500, "30 con 80")
  val bol65 = new Interseccion(11100, 10500, "Boliv con 65")  
  val gu10 = new Interseccion(16500, 12000, "Guay con 10") 
  val terminal = new Interseccion(16500, 10500, "Term Sur") 
  val gu30 = new Interseccion(13500, 12000, "Guay 30")
  val gu80 = new Interseccion(19500, 12000, "Guay 80")
  val _65_80 = new Interseccion(19500, 10500, "65 con 30")
  val gu_37S = new Interseccion(21000, 12000, "Guay con 37S") 
  
  val vias =Array(new Via(niquia, lauraAuto, 80, TipoVia("Carrera"), Sentido.dobleVia, "64C", "Auto Norte"),new Via(niquia, lauraReg, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),new Via(lauraAuto, lauraReg, 60, TipoVia("Calle"), Sentido.dobleVia, "94", "Pte Madre Laura"),new Via(lauraAuto, ptoCero, 80, TipoVia("Carrera"), Sentido.dobleVia, "64C", "Auto Norte"),new Via(lauraReg, ptoCero, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),new Via(ptoCero, mino, 60, TipoVia("Calle"), Sentido.dobleVia, "58", "Oriental"),new Via(mino, villa, 60, TipoVia("Calle"), Sentido.dobleVia, "58", "Oriental"),new Via(ptoCero, ig65, 60, TipoVia("Calle"), Sentido.dobleVia, "55", "Iguaná"),new Via(ig65, robledo, 60, TipoVia("Calle"), Sentido.dobleVia, "55", "Iguaná"),new Via(ptoCero, colReg, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),new Via(colReg, maca, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),new Via(maca, expo, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),new Via(expo, reg30, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),new Via(reg30, monte, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),new Via(monte, agua, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),new Via(agua, viva, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),
                  new Via(viva, mayor, 80, TipoVia("Carrera"), Sentido.dobleVia, "62", "Regional"),new Via(mino, ferrCol, 60, TipoVia("Carrera"), Sentido.dobleVia, "55", "Ferrocarril"),new Via(ferrCol, ferrJuan, 60, TipoVia("Carrera"), Sentido.dobleVia, "55", "Ferrocarril"),new Via(ferrJuan, expo, 60, TipoVia("Carrera"), Sentido.dobleVia, "55", "Ferrocarril"),new Via(villa, juanOr, 60, TipoVia("Carrera"), Sentido.dobleVia, "46", "Oriental"),new Via(juanOr, sanDiego, 60, TipoVia("Carrera"), Sentido.dobleVia, "46", "Oriental"),new Via(sanDiego, premium, 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),new Via(premium, pp, 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),new Via(pp,santafe, 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),new Via(santafe, pqEnv, 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),new Via(pqEnv, mayor, 60, TipoVia("Carrera"), Sentido.dobleVia, "43A", "Av Pob"),new Via(ferrCol, colReg, 60, TipoVia("Calle"), Sentido.dobleVia, "450", "Colombia"),new Via(colReg, col65, 60, TipoVia("Calle"), Sentido.dobleVia, "450", "Colombia"),new Via(col65, col80, 60, TipoVia("Calle"), Sentido.dobleVia, "450", "Colombia"),new Via(juanOr, ferrJuan, 60, TipoVia("Calle"), Sentido.dobleVia, "44", "Sn Juan"),new Via(ferrJuan, maca, 60, TipoVia("Calle"), Sentido.dobleVia, "44", "Sn Juan"),new Via(maca, juan65, 60, TipoVia("Calle"), Sentido.dobleVia, "44", "Sn Juan"),new Via(juan65, juan80, 60, TipoVia("Calle"), Sentido.dobleVia, "44", "Sn Juan"),new Via(sanDiego, expo, 60, TipoVia("Calle"), Sentido.dobleVia, "33", "33"),new Via(expo, _33_65, 60, TipoVia("Calle"), Sentido.dobleVia, "33","33"),new Via(_33_65, bule, 60, TipoVia("Calle"), Sentido.dobleVia, "33", "33"),new Via(bule, gema, 60, TipoVia("Calle"), Sentido.dobleVia, "33", "33"),new Via(premium, reg30, 60, TipoVia("Calle"), Sentido.dobleVia, "30", "30"),new Via(reg30, _30_65, 60, TipoVia("Calle"), Sentido.dobleVia, "30", "30"),new Via(_30_65, _30_70, 60, TipoVia("Calle"), Sentido.dobleVia, "30", "30"),new Via(_30_70, _30_80, 60, TipoVia("Calle"), Sentido.dobleVia, "30", "30"),new Via(maca, bol65, 60, TipoVia("Diagonal"), Sentido.dobleVia, "74B", "Boliv"),new Via(bol65, bule, 60, TipoVia("Diagonal"), Sentido.dobleVia, "74B", "Boliv"),new Via(bule, _30_70, 60, TipoVia("Diagonal"), Sentido.dobleVia, "74B", "Boliv"),new Via(juan80, bule, 60, TipoVia("Transversal"), Sentido.dobleVia, "39B", "Nutibara"),new Via(pp, monte, 60, TipoVia("Calle"), Sentido.dobleVia, "10", "10"),new Via(monte, gu10, 60, TipoVia("Calle"), Sentido.dobleVia, "10", "10"),new Via(gu10, terminal, 60, TipoVia("Calle"), Sentido.dobleVia, "10", "10"),new Via(expo, gu30, 60, TipoVia("Carrera"), Sentido.dobleVia, "52", "Av Guay"),new Via(gu30, gu10, 60, TipoVia("Carrera"), Sentido.dobleVia, "52", "Av Guay"),new Via(gu10, gu80, 60, TipoVia("Carrera"), Sentido.dobleVia, "52", "Av Guay"),new Via(gu80, gu_37S, 60, TipoVia("Carrera"), Sentido.dobleVia, "52", "Av Guay"),new Via(lauraAuto, ig65, 60, TipoVia("Carrera"), Sentido.dobleVia, "65", "65"),new Via(ig65, col65, 60, TipoVia("Carrera"), Sentido.dobleVia, "65", "65"),new Via(juan65, col65, 60, TipoVia("Carrera"), Sentido.unaVia, "65", "65"),new Via(bol65, juan65, 60, TipoVia("Carrera"), Sentido.unaVia, "65", "65"),new Via(_33_65, bol65, 60, TipoVia("Carrera"), Sentido.unaVia, "65", "65"),new Via(_30_65, _33_65, 60, TipoVia("Carrera"), Sentido.unaVia, "65", "65"),new Via(_30_65,terminal, 60, TipoVia("Carrera"), Sentido.dobleVia, "65", "65"),new Via(terminal, _65_80, 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "65"),new Via(robledo, col80, 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),new Via(col80, juan80, 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),new Via(juan80, gema, 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),new Via(gema, _30_80, 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),new Via(_30_80, _65_80, 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),new Via(_65_80, gu80, 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),new Via(gu80, agua, 60, TipoVia("Carrera"), Sentido.dobleVia, "80", "80"),new Via(agua, santafe, 60, TipoVia("Calle"), Sentido.dobleVia, "12S", "80"),new Via(viva, pqEnv, 60, TipoVia("Calle"), Sentido.dobleVia, "37S", "37S"),
                  new Via(viva, gu_37S, 60, TipoVia("Calle"), Sentido.dobleVia, "63", "37S"))
  grafito.construir(vias)
  val g = new GraficaTest(vias)
  println("NI MERGAS")*/
  println(movil.tiposVehiculos.MotoTaxi.generarPlaca)
}