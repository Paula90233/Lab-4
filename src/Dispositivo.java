public abstract class Dispositivo {
    protected String codigo; 
    protected Oficina oficina; 
    protected double potencia; 
    protected boolean encendido; 
    protected double consumoDia;

    public Dispositivo(String codigo,Oficina oficina,double potencia,boolean encendido){
        if(codigo==null||codigo.trim().isEmpty()||potencia<=0) 
            throw new IllegalArgumentException("Código y potencia deben ser válidos.");
        this.codigo=codigo;
        this.oficina=oficina;
        this.potencia=potencia;
        this.encendido=encendido;
        this.consumoDia=0;
    }
    public abstract double calcularConsumoHora();

    public String getCodigo(){
        return codigo;
    } 
    public Oficina getOficina(){
        return oficina;
    }
    public boolean estaEncendido(){
        return encendido;
    } 
    public double getConsumoDia(){
        return consumoDia;
    }
    public void acumularConsumo(double k){
        consumoDia+=k;
    } 
    public void reiniciarConsumo(){
        consumoDia=0;
    }
    public String getEstado(){
        return encendido?"Encendido":"Apagado";
    }
    public String toString(){
        return codigo+" | "+getClass().getSimpleName()+" | "+getEstado()+" | "+String.format("%.3f",consumoDia)+" kWh";
    }
}
