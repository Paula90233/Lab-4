public abstract class DispositivoRegulable extends DispositivoControlable implements Regulable {
    protected int nivel;
    protected int nivelMinimo;
    protected int nivelMaximo;

    public DispositivoRegulable(String codigo,Oficina oficina,double potencia,int nivelInicial,int nivelMinimo){
        super(codigo,oficina,potencia,false);
        nivel = nivelInicial;
        this.nivelMinimo=nivelMinimo;
        this.nivelMaximo=100;
    }
    public void ajustarNivel(int n){
        if(!encendido) 
            throw new IllegalStateException("El dispositivo debe estar encendido para ajustar el nivel.");
        if(n<nivelMinimo||n>nivelMaximo) 
            throw new IllegalArgumentException("Nivel permitido: "+nivelMinimo+" a 100.");
        nivel=n;
    }
    public int getNivel(){
        return nivel;
    }
}
