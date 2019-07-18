package grafo
import rectas.Via
import javax.swing.JFrame
import javax.swing.JPanel;

class GraficaTest(arreglo : Array[Via]) extends JFrame{
  Grafica.agregarGrafica(arreglo)
  var panel = Grafica.obtienePanel()
  this.setSize(2000,600);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.add(panel);
  this.setVisible(true);
}