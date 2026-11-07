public abstract class DispositivoControlable extends Dispositivo implements Controlable {
    public DispositivoControlable(String codigo,Oficina oficina,double potencia,boolean encendido){
        super(codigo,oficina,potencia,encendido);
    }
    public void encender(){
        encendido=true;
    } 
    public void apagar(){
        encendido=false;
    }
}
