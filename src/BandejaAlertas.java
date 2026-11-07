import java.util.ArrayList;
public class BandejaAlertas {
    private ArrayList<Alerta> pendientes = new ArrayList<Alerta>();
    
    public void agregar(Alerta a){
        pendientes.add(a);
    }
    
    public void ordenar(){
        for(int i=1;i<pendientes.size();i++){
            Alerta x=pendientes.get(i);
            int j=i-1;
            while(j>=0&&pendientes.get(j).compareTo(x)>0){
                pendientes.set(j+1,pendientes.get(j));
                j--;
            }
        pendientes.set(j+1,x);
        }
    }
    
    public Alerta obtenerPrimera(){
        ordenar();
        return pendientes.isEmpty()?null:pendientes.get(0);
    }
    
    public void eliminar(Alerta a){
        pendientes.remove(a);
    }
    
    public ArrayList<Alerta> getPendientes(){
        ordenar();
        return pendientes;
    }
}
