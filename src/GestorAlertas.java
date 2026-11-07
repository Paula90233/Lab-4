import java.util.ArrayList;
public class GestorAlertas {
    private BandejaAlertas bandeja = new BandejaAlertas(); 
    private ArrayList<Alerta> historial = new ArrayList<Alerta>(); 
    private int siguiente=1;

    public void generar(Dispositivo dispositivo,Severidad severidad,int hora,String mensaje){
        if(severidad==null)return;
        Alerta a = new Alerta(String.valueOf(siguiente++), dispositivo, hora, severidad, mensaje);
        bandeja.agregar(a);
        historial.add(a);
        System.out.println("Se generó "+a);
    }

    public void atender(int hora){
        Alerta a=bandeja.obtenerPrimera();
        if(a==null){
            System.out.println("No hay alertas pendientes.");
            return;
        }
        double c=a.atender(hora);
        a.getDispositivo().getOficina().agregarCredito(c);
        bandeja.eliminar(a);
        System.out.println("Atendida: "+a);
    }
    public void mostrarPendientes(){
        if(bandeja.getPendientes().isEmpty())System.out.println("No hay alertas pendientes.");
        for(Alerta a:bandeja.getPendientes())System.out.println(a);
    }
    public void mostrarRetrasadas(){
        boolean hay = false;
        for(Alerta a:historial)
            if(a.estaAtendida()&&a.getRetraso()>0){
                System.out.println(a);hay=true;
            }
            if(!hay)System.out.println("No hay alertas atendidas con retraso.");
    }
}
