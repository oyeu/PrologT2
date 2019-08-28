
package parametros

case class Parametros(var dt: Int,var tRefresh: Int ,
          var vehiculos: ParametroVehiculos,var velocidad: ParametrosVelocidad,var proporciones: Proporciones,
          var aceleracion: Aceleracion,var semaforos: Semaforos, var distanciasFrenadoVehiculos: DistanciaFrenado) {
  
}