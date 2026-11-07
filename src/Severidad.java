public abstract class Severidad {
 private String nombre; private int prioridad, plazo; private double creditoHora;
 public Severidad(String n,int p,int pl,double c){nombre=n;prioridad=p;plazo=pl;creditoHora=c;}
 public String getNombre(){return nombre;} public int getPrioridad(){return prioridad;}
 public int getPlazo(){return plazo;} public double getCreditoHora(){return creditoHora;}
 public String toString(){return nombre;}
}
