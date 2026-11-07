public class Climatizador extends DispositivoRegulable implements Medible {
    public Climatizador(String codigo,Oficina oficina,double potencia){
        this(codigo,oficina,potencia,20);
    }
    protected Climatizador(String codigo,Oficina oficina,double potencia,int minimo){
        super(codigo,oficina,potencia,50,minimo);
    }
    public double calcularConsumoHora(){
        return encendido?potencia*(0.30+0.70*nivel/100.0)/1000.0:0;
    }
    public boolean validarLectura(double t){
        return t>=-10&&t<=60;
    }
    public Severidad evaluarLectura(double t){
        if(!validarLectura(t)) 
            throw new IllegalArgumentException("Temperatura válida: -10 a 60 °C.");
        if(t>=40)
            return new Critica(); 
        if(t>=32)
            return new Alta(); 
        if(t>=28)
            return new Baja(); 
            return null;
    }
    public String getNombreMedicion(){
        return "temperatura";
    }
}
