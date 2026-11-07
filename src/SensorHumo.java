public class SensorHumo extends Dispositivo implements Medible {
 public SensorHumo(String c,Oficina o,double p){super(c,o,p,true);}
 public double calcularConsumoHora(){return encendido?potencia/1000.0:0;}
 public boolean validarLectura(double ppm){return ppm>=0&&ppm<=1000;}
 public Severidad evaluarLectura(double ppm){
  if(!validarLectura(ppm))throw new IllegalArgumentException("Lectura válida: 0 a 1000 ppm.");
  if(ppm>=300)return new Critica(); if(ppm>=150)return new Alta(); return null;
 }
 public String getNombreMedicion(){return "humo (ppm)";}
}
