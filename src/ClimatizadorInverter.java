public class ClimatizadorInverter extends Climatizador {
    public ClimatizadorInverter(String codigo,Oficina oficina,double potencia){
        super(codigo,oficina,potencia,10);
    }
    
    @Override 
    public double calcularConsumoHora(){
        return super.calcularConsumoHora()*0.80;
    }
}
