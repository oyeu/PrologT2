package conexion

import org.neo4j.driver.v1._
import scala.collection.mutable.ArrayBuffer
import rectas._
import puntos.Interseccion


object Conexion {
  
  val url = "bolt://localhost/7687"
  val user = "neo4j"
  val pass = "123"
  
  def getSession(): (Driver,Session) = {
    val driver = GraphDatabase.driver(url, AuthTokens.basic(user, pass))
    val session = driver.session
    (driver, session)
  }
  
  def borrarTodo() = {
    borrarRelaciones()
    borrarNodos()
  }
  
  def borrarRelaciones() = {
    val (driver, session) = getSession()
    val script = s"MATCH ()-[R]->() DELETE R "
    val result = session.run(script)
    session.close()
    driver.close()
  }
  
  def borrarNodos() = {
    val (driver, session) = getSession()
    val script = s"MATCH (P) DELETE P"
    val result = session.run(script)
    session.close()
    driver.close()
  }
  
  def obtenerIntersecciones() = {
    val (driver, session) = getSession()
    val script = s"MATCH (I:Interseccion) RETURN I"
    val result = session.run(script)
    val intersecciones = ArrayBuffer.empty[Interseccion]
    val resultado = scala.collection.mutable.Map[String,Interseccion]()
    while (result.hasNext()) {
      val values = result.next().values()
      val inter = values.get(0)
      intersecciones += new Interseccion(inter.get("x").toString().toInt,inter.get("y").toString().toInt,Some(inter.get("nombre").toString()))
    }  
    session.close()
    driver.close()
    for(x <- intersecciones) {resultado += (x.nombre -> x)}
    resultado.toMap
  }
  
  def obtenerVias() = {
    val (driver, session) = getSession()
    val script = s"MATCH (V:Via), (Io:Interseccion)-[:ES_ORIGEN]->(V)<-[:ES_DESTINO]-(If:Interseccion), (S:Sentido)-[:ES]->(V)<-[:ES_TIPO]-(T:TipoVia) RETURN V,If,Io,S,T"
    val result = session.run(script)
    val vias = ArrayBuffer.empty[Via]
    while (result.hasNext()) {
      val values = result.next().values()
      val via = values.get(0)
      val interFin = values.get(1)
      val interOri = values.get(2)
      val sentido = values.get(3)
      val tipo = values.get(4)
      vias += Via(new Interseccion(interOri.get("x").toString().toInt,interOri.get("y").toString().toInt,Some(interOri.get("nombre").toString())),
      new Interseccion(interFin.get("x").toString().toInt,interFin.get("y").toString().toInt,Some(interFin.get("nombre").toString())))(via.get("velMax").toString().toInt,
      TipoVia(tipo.get("tipo").toString()), Sentido(sentido.get("isDobleVia").asBoolean()),via.get("numero").toString(),via.get("nombre").toString())
    }
    session.close()
    driver.close()
    vias.toArray
  }
  
  def insertarDatosViales() = {
     val (driver, session) = getSession()
     val script = s"""CREATE (I1:Interseccion{clave: "niquia", x: 300, y: 12000, nombre: "Niquia"}),
                      (I2:Interseccion{clave: "lauraAuto", x: 2400, y: 11400, nombre: "M. Laura Auto"}),
                      (I3:Interseccion{clave: "lauraReg", x: 2400, y: 12600, nombre: "M. Laura Reg"}),
                      (I4:Interseccion{clave: "ptoCero", x: 5400, y: 12000, nombre: "Pto 0"}),
                      (I5:Interseccion{clave: "mino", x: 6300, y: 15000, nombre: "Minorista"}),
                      (I6:Interseccion{clave: "villa", x: 6300, y: 19500, nombre: "Villanueva"}),
                      (I7:Interseccion{clave: "ig65", x: 5400, y: 10500, nombre: "65 Igu"}),
                      (I8:Interseccion{clave: "robledo", x: 5400, y: 1500, nombre: "Exito Rob"}),
                      (I9:Interseccion{clave: "colReg", x: 8250, y: 12000, nombre: "Col Reg"}),
                      (I10:Interseccion{clave: "col65", x: 8250, y: 10500, nombre: "Col 65"}),
                      (I11:Interseccion{clave: "col80", x: 8250, y: 1500, nombre: "Col 80"}),
                      (I12:Interseccion{clave: "juanOr", x: 10500, y: 19500, nombre: "Sn Juan Ori"}),
                      (I13:Interseccion{clave: "maca", x: 10500, y: 12000, nombre: "Macarena"}),
                      (I14:Interseccion{clave: "expo", x: 12000, y: 13500, nombre: "Exposiciones"}),
                      (I15:Interseccion{clave: "reg30", x: 13500, y: 15000, nombre: "Reg 30"}),
                      (I16:Interseccion{clave: "monte", x: 16500, y: 15000, nombre: "Monterrey"}),
                      (I17:Interseccion{clave: "agua", x: 19500, y: 15000, nombre: "Aguacatala"}),
                      (I18:Interseccion{clave: "viva", x: 21000, y: 15000, nombre: "Viva Env"}),
                      (I19:Interseccion{clave: "mayor", x: 23400, y: 15000, nombre: "Mayorca"}),
                      (I20:Interseccion{clave: "ferrCol", x: 8250, y: 15000, nombre: "Ferr Col"}),
                      (I21:Interseccion{clave: "ferrJuan", x: 10500, y: 15000, nombre: "Alpujarra"}),
                      (I22:Interseccion{clave: "sanDiego", x: 12000, y: 19500, nombre: "San Diego"}),
                      (I23:Interseccion{clave: "premium", x: 13500, y: 19500, nombre: "Premium"}),
                      (I24:Interseccion{clave: "pp", x: 16500, y: 19500, nombre: "Parque Pob"}),
                      (I25:Interseccion{clave: "santafe", x: 19500, y: 18750, nombre: "Santa Fe"}),
                      (I26:Interseccion{clave: "pqEnv", x: 21000, y: 18000, nombre: "Envigado"}),
                      (I27:Interseccion{clave: "juan65", x: 10500, y: 10500, nombre: "Juan 65"}),
                      (I28:Interseccion{clave: "juan80", x: 10500, y: 1500, nombre: "Juan 80"}),
                      (I29:Interseccion{clave: "_33_65", x: 12000, y: 10500, nombre: "33 con 65"}),
                      (I30:Interseccion{clave: "bule", x: 12000, y: 7500, nombre: "Bulerias"}),
                      (I31:Interseccion{clave: "gema", x: 12000, y: 1500, nombre: "St Gema"}),
                      (I32:Interseccion{clave: "_30_65", x: 13500, y: 10500, nombre: "30 con 65"}),
                      (I33:Interseccion{clave: "_30_70", x: 13500, y: 4500, nombre: "30 con 70"}),
                      (I34:Interseccion{clave: "_30_80", x: 13500, y: 1500, nombre: "30 con 80"}),
                      (I35:Interseccion{clave: "bol65", x: 11100, y: 10500, nombre: "Boliv con 65"}),
                      (I36:Interseccion{clave: "gu10", x: 16500, y: 12000, nombre: "Guay con 10"}),
                      (I37:Interseccion{clave: "terminal", x: 16500, y: 10500, nombre: "Term Sur"}),
                      (I38:Interseccion{clave: "gu30", x: 13500, y: 12000, nombre: "Guay 30"}),
                      (I39:Interseccion{clave: "gu80", x: 19500, y: 12000, nombre: "Guay 80"}),
                      (I40:Interseccion{clave: "_65_80", x: 19500, y: 10500, nombre: "65 con 30"}),
                      (I41:Interseccion{clave: "gu_37S", x: 21000, y: 12000, nombre: "Guay con 37S"}),
                      
                      (T1:TipoVia{tipo: "Carrera"}),
                      (T2:TipoVia{tipo: "Calle"}),
                      (T3:TipoVia{tipo: "Transversal"}),
                      (T4:TipoVia{tipo: "Diagonal"}),
                      
                      (S1:Sentido{doble: "true", isDobleVia: true}),
                      (S2:Sentido{doble: "false", isDobleVia: false}),
                      
                      
                      (V1:Via{id: 1, velMax: 80, numero: "64C", nombre: "Auto Norte"}),
                      (V2:Via{id: 2, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V3:Via{id: 3, velMax: 60, numero: "94", nombre: "Pte Madre Laura"}),
                      (V4:Via{id: 4, velMax: 80, numero: "64C", nombre: "Auto Norte"}),
                      (V5:Via{id: 5, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V6:Via{id: 6, velMax: 60, numero: "58", nombre: "Oriental"}),
                      (V7:Via{id: 7, velMax: 60, numero: "58", nombre: "Oriental"}),
                      (V8:Via{id: 8, velMax: 60, numero: "55", nombre: "Iguaná"}),
                      (V9:Via{id: 9, velMax: 60, numero: "55", nombre: "Iguaná"}),
                      (V10:Via{id: 10, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V11:Via{id: 11, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V12:Via{id: 12, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V13:Via{id: 13, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V14:Via{id: 14, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V15:Via{id: 15, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V16:Via{id: 16, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V17:Via{id: 17, velMax: 80, numero: "62", nombre: "Regional"}),
                      (V18:Via{id: 18, velMax: 60, numero: "55", nombre: "Ferrocarril"}),
                      (V19:Via{id: 19, velMax: 60, numero: "55", nombre: "Ferrocarril"}),
                      (V20:Via{id: 20, velMax: 60, numero: "55", nombre: "Ferrocarril"}),
                      (V21:Via{id: 21, velMax: 60, numero: "46", nombre: "Oriental"}),
                      (V22:Via{id: 22, velMax: 60, numero: "46", nombre: "Oriental"}),
                      (V23:Via{id: 23, velMax: 60, numero: "43A", nombre: "Av Pob"}),
                      (V24:Via{id: 24, velMax: 60, numero: "43A", nombre: "Av Pob"}),
                      (V25:Via{id: 25, velMax: 60, numero: "43A", nombre: "Av Pob"}),
                      (V26:Via{id: 26, velMax: 60, numero: "43A", nombre: "Av Pob"}),
                      (V27:Via{id: 27, velMax: 60, numero: "43A", nombre: "Av Pob"}),
                      (V28:Via{id: 28, velMax: 60, numero: "450", nombre: "Colombia"}),
                      (V29:Via{id: 29, velMax: 60, numero: "450", nombre: "Colombia"}),
                      (V30:Via{id: 30, velMax: 60, numero: "450", nombre: "Colombia"}),
                      (V31:Via{id: 31, velMax: 60, numero: "44", nombre: "Sn Juan"}),
                      (V32:Via{id: 32, velMax: 60, numero: "44", nombre: "Sn Juan"}),
                      (V33:Via{id: 33, velMax: 60, numero: "44", nombre: "Sn Juan"}),
                      (V34:Via{id: 34, velMax: 60, numero: "44", nombre: "Sn Juan"}),
                      (V35:Via{id: 35, velMax: 60, numero: "33", nombre: "33"}),
                      (V36:Via{id: 36, velMax: 60, numero: "33", nombre: "33"}),
                      (V37:Via{id: 37, velMax: 60, numero: "33", nombre: "33"}),
                      (V38:Via{id: 38, velMax: 60, numero: "33", nombre: "33"}),
                      (V39:Via{id: 39, velMax: 60, numero: "30", nombre: "30"}),
                      (V40:Via{id: 40, velMax: 60, numero: "30", nombre: "30"}),
                      (V41:Via{id: 41, velMax: 60, numero: "30", nombre: "30"}),
                      (V42:Via{id: 42, velMax: 60, numero: "30", nombre: "30"}),
                      (V43:Via{id: 43, velMax: 60, numero: "74B", nombre: "Boliv"}),
                      (V44:Via{id: 44, velMax: 60, numero: "74B", nombre: "Boliv"}),
                      (V45:Via{id: 45, velMax: 60, numero: "74B", nombre: "Boliv"}),
                      (V46:Via{id: 46, velMax: 60, numero: "39B", nombre: "Nutibara"}),
                      (V47:Via{id: 47, velMax: 60, numero: "10", nombre: "10"}),
                      (V48:Via{id: 48, velMax: 60, numero: "10", nombre: "10"}),
                      (V49:Via{id: 49, velMax: 60, numero: "10", nombre: "10"}),
                      (V50:Via{id: 50, velMax: 60, numero: "52", nombre: "Av Guay"}),
                      (V51:Via{id: 51, velMax: 60, numero: "52", nombre: "Av Guay"}),
                      (V52:Via{id: 52, velMax: 60, numero: "52", nombre: "Av Guay"}),
                      (V53:Via{id: 53, velMax: 60, numero: "52", nombre: "Av Guay"}),
                      (V54:Via{id: 54, velMax: 60, numero: "65", nombre: "65"}),
                      (V55:Via{id: 55, velMax: 60, numero: "65", nombre: "65"}),
                      (V56:Via{id: 56, velMax: 60, numero: "65", nombre: "65"}),
                      (V57:Via{id: 57, velMax: 60, numero: "65", nombre: "65"}),
                      (V58:Via{id: 58, velMax: 60, numero: "65", nombre: "65"}),
                      (V59:Via{id: 59, velMax: 60, numero: "65", nombre: "65"}),
                      (V60:Via{id: 60, velMax: 60, numero: "65", nombre: "65"}),
                      (V61:Via{id: 61, velMax: 60, numero: "80", nombre: "80"}),
                      (V62:Via{id: 62, velMax: 60, numero: "80", nombre: "80"}),
                      (V63:Via{id: 63, velMax: 60, numero: "80", nombre: "80"}),
                      (V64:Via{id: 64, velMax: 60, numero: "80", nombre: "80"}),
                      (V65:Via{id: 65, velMax: 60, numero: "80", nombre: "80"}),
                      (V66:Via{id: 66, velMax: 60, numero: "80", nombre: "80"}),
                      (V67:Via{id: 67, velMax: 60, numero: "80", nombre: "80"}),
                      (V68:Via{id: 68, velMax: 60, numero: "80", nombre: "80"}),
                      (V69:Via{id: 69, velMax: 60, numero: "12S", nombre: "80"}),
                      (V70:Via{id: 70, velMax: 60, numero: "37S", nombre: "37S"}),
                      (V71:Via{id: 71, velMax: 60, numero: "63", nombre: "37S"}),
                      
                      (I1)-[:ES_ORIGEN]->(V1)<-[:ES_DESTINO]-(I2),
                      (I1)-[:ES_ORIGEN]->(V2)<-[:ES_DESTINO]-(I3),
                      (I2)-[:ES_ORIGEN]->(V3)<-[:ES_DESTINO]-(I3),
                      (I2)-[:ES_ORIGEN]->(V4)<-[:ES_DESTINO]-(I4),
                      (I3)-[:ES_ORIGEN]->(V5)<-[:ES_DESTINO]-(I4),
                      (I4)-[:ES_ORIGEN]->(V6)<-[:ES_DESTINO]-(I5),
                      (I5)-[:ES_ORIGEN]->(V7)<-[:ES_DESTINO]-(I6),
                      (I4)-[:ES_ORIGEN]->(V8)<-[:ES_DESTINO]-(I7),
                      (I7)-[:ES_ORIGEN]->(V9)<-[:ES_DESTINO]-(I8),
                      (I4)-[:ES_ORIGEN]->(V10)<-[:ES_DESTINO]-(I9),
                      (I9)-[:ES_ORIGEN]->(V11)<-[:ES_DESTINO]-(I13),
                      (I13)-[:ES_ORIGEN]->(V12)<-[:ES_DESTINO]-(I14),
                      (I14)-[:ES_ORIGEN]->(V13)<-[:ES_DESTINO]-(I15),
                      (I15)-[:ES_ORIGEN]->(V14)<-[:ES_DESTINO]-(I16),
                      (I16)-[:ES_ORIGEN]->(V15)<-[:ES_DESTINO]-(I17),
                      (I17)-[:ES_ORIGEN]->(V16)<-[:ES_DESTINO]-(I18),
                      (I18)-[:ES_ORIGEN]->(V17)<-[:ES_DESTINO]-(I19),
                      (I5)-[:ES_ORIGEN]->(V18)<-[:ES_DESTINO]-(I20),
                      (I20)-[:ES_ORIGEN]->(V19)<-[:ES_DESTINO]-(I21),
                      (I21)-[:ES_ORIGEN]->(V20)<-[:ES_DESTINO]-(I14),
                      (I6)-[:ES_ORIGEN]->(V21)<-[:ES_DESTINO]-(I12),
                      (I12)-[:ES_ORIGEN]->(V22)<-[:ES_DESTINO]-(I22),
                      (I22)-[:ES_ORIGEN]->(V23)<-[:ES_DESTINO]-(I23),
                      (I23)-[:ES_ORIGEN]->(V24)<-[:ES_DESTINO]-(I24),
                      (I24)-[:ES_ORIGEN]->(V25)<-[:ES_DESTINO]-(I25),
                      (I25)-[:ES_ORIGEN]->(V26)<-[:ES_DESTINO]-(I26),
                      (I26)-[:ES_ORIGEN]->(V27)<-[:ES_DESTINO]-(I19),
                      (I20)-[:ES_ORIGEN]->(V28)<-[:ES_DESTINO]-(I9),
                      (I9)-[:ES_ORIGEN]->(V29)<-[:ES_DESTINO]-(I10),
                      (I10)-[:ES_ORIGEN]->(V30)<-[:ES_DESTINO]-(I11),
                      (I12)-[:ES_ORIGEN]->(V31)<-[:ES_DESTINO]-(I21),
                      (I21)-[:ES_ORIGEN]->(V32)<-[:ES_DESTINO]-(I13),
                      (I13)-[:ES_ORIGEN]->(V33)<-[:ES_DESTINO]-(I27),
                      (I27)-[:ES_ORIGEN]->(V34)<-[:ES_DESTINO]-(I28),
                      (I22)-[:ES_ORIGEN]->(V35)<-[:ES_DESTINO]-(I14),
                      (I14)-[:ES_ORIGEN]->(V36)<-[:ES_DESTINO]-(I29),
                      (I29)-[:ES_ORIGEN]->(V37)<-[:ES_DESTINO]-(I30),
                      (I30)-[:ES_ORIGEN]->(V38)<-[:ES_DESTINO]-(I31),
                      (I23)-[:ES_ORIGEN]->(V39)<-[:ES_DESTINO]-(I15),
                      (I15)-[:ES_ORIGEN]->(V40)<-[:ES_DESTINO]-(I32),
                      (I32)-[:ES_ORIGEN]->(V41)<-[:ES_DESTINO]-(I33),
                      (I33)-[:ES_ORIGEN]->(V42)<-[:ES_DESTINO]-(I34),
                      (I13)-[:ES_ORIGEN]->(V43)<-[:ES_DESTINO]-(I35),
                      (I35)-[:ES_ORIGEN]->(V44)<-[:ES_DESTINO]-(I30),
                      (I30)-[:ES_ORIGEN]->(V45)<-[:ES_DESTINO]-(I33),
                      (I28)-[:ES_ORIGEN]->(V46)<-[:ES_DESTINO]-(I30),
                      (I24)-[:ES_ORIGEN]->(V47)<-[:ES_DESTINO]-(I16),
                      (I16)-[:ES_ORIGEN]->(V48)<-[:ES_DESTINO]-(I36),
                      (I36)-[:ES_ORIGEN]->(V49)<-[:ES_DESTINO]-(I37),
                      (I14)-[:ES_ORIGEN]->(V50)<-[:ES_DESTINO]-(I38),
                      (I38)-[:ES_ORIGEN]->(V51)<-[:ES_DESTINO]-(I36),
                      (I36)-[:ES_ORIGEN]->(V52)<-[:ES_DESTINO]-(I39),
                      (I39)-[:ES_ORIGEN]->(V53)<-[:ES_DESTINO]-(I41),
                      (I2)-[:ES_ORIGEN]->(V54)<-[:ES_DESTINO]-(I7),
                      (I7)-[:ES_ORIGEN]->(V55)<-[:ES_DESTINO]-(I10),
                      (I27)-[:ES_ORIGEN]->(V56)<-[:ES_DESTINO]-(I10),
                      (I35)-[:ES_ORIGEN]->(V57)<-[:ES_DESTINO]-(I27),
                      (I29)-[:ES_ORIGEN]->(V58)<-[:ES_DESTINO]-(I35),
                      (I32)-[:ES_ORIGEN]->(V59)<-[:ES_DESTINO]-(I29),
                      (I32)-[:ES_ORIGEN]->(V60)<-[:ES_DESTINO]-(I37),
                      (I37)-[:ES_ORIGEN]->(V61)<-[:ES_DESTINO]-(I40),
                      (I8)-[:ES_ORIGEN]->(V62)<-[:ES_DESTINO]-(I11),
                      (I11)-[:ES_ORIGEN]->(V63)<-[:ES_DESTINO]-(I28),
                      (I28)-[:ES_ORIGEN]->(V64)<-[:ES_DESTINO]-(I31),
                      (I31)-[:ES_ORIGEN]->(V65)<-[:ES_DESTINO]-(I34),
                      (I34)-[:ES_ORIGEN]->(V66)<-[:ES_DESTINO]-(I40),
                      (I40)-[:ES_ORIGEN]->(V67)<-[:ES_DESTINO]-(I39),
                      (I39)-[:ES_ORIGEN]->(V68)<-[:ES_DESTINO]-(I17),
                      (I17)-[:ES_ORIGEN]->(V69)<-[:ES_DESTINO]-(I25),
                      (I18)-[:ES_ORIGEN]->(V70)<-[:ES_DESTINO]-(I26),
                      (I18)-[:ES_ORIGEN]->(V71)<-[:ES_DESTINO]-(I41),
                      
                      (S1)-[:ES]->(V1)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V2)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V3)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V4)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V5)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V6)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V7)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V8)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V9)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V10)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V11)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V12)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V13)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V14)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V15)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V16)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V17)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V18)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V19)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V20)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V21)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V22)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V23)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V24)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V25)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V26)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V27)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V28)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V29)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V30)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V31)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V32)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V33)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V34)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V35)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V36)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V37)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V38)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V39)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V40)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V41)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V42)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V43)<-[:ES_TIPO]-(T4),
                      (S1)-[:ES]->(V44)<-[:ES_TIPO]-(T4),
                      (S1)-[:ES]->(V45)<-[:ES_TIPO]-(T4),
                      (S1)-[:ES]->(V46)<-[:ES_TIPO]-(T3),
                      (S1)-[:ES]->(V47)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V48)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V49)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V50)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V51)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V52)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V53)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V54)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V55)<-[:ES_TIPO]-(T1),
                      (S2)-[:ES]->(V56)<-[:ES_TIPO]-(T1),
                      (S2)-[:ES]->(V57)<-[:ES_TIPO]-(T1),
                      (S2)-[:ES]->(V58)<-[:ES_TIPO]-(T1),
                      (S2)-[:ES]->(V59)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V60)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V61)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V62)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V63)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V64)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V65)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V66)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V67)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V68)<-[:ES_TIPO]-(T1),
                      (S1)-[:ES]->(V69)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V70)<-[:ES_TIPO]-(T2),
                      (S1)-[:ES]->(V71)<-[:ES_TIPO]-(T2)"""
     
    val result = session.run(script)
    session.close()
    driver.close()
  }
  
}