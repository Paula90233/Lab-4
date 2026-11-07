public class Camara extends DispositivoControlable implements DetectorMovimiento {
    public Camara(String codigo,Oficina oficina,double potencia){
        super(codigo,oficina,potencia,false);
    }
    public double calcularConsumoHora(){
        return encendido?potencia/1000.0:0;
    }
    public Severidad evaluarMovimiento(int hora){
        return (hora<7||hora>=19)?new Alta():null;
    }
}
