public class Luminaria extends DispositivoRegulable {
    public Luminaria(String codigo,Oficina oficina,double potencia){
        super(codigo,oficina,potencia,100,10);
    }
    public double calcularConsumoHora(){
        return encendido?(potencia*nivel/100.0)/1000.0:0;
    }
}
