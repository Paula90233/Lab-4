import java.util.ArrayList;
public class Oficina {
    private String codigo;
    private String inquilino; 
    private ArrayList<Dispositivo> dispositivos; 
    private ArrayList<Factura> facturas;
    private double valle;
    private double normal;
    private double punta;
    private double creditos;

    public Oficina(String codigo,String inquilino){
        if(codigo==null||codigo.trim().isEmpty()||inquilino==null||inquilino.trim().isEmpty())throw new IllegalArgumentException("Código y nombre obligatorios.");
        this.codigo=codigo;
        this.inquilino=inquilino;
        this.dispositivos = new ArrayList<Dispositivo>();
        this.facturas = new ArrayList<Factura>();
        this.valle=0;
        this.normal=0;
        this.punta=0;
        this.creditos=0;
    }

    public void agregarDispositivo(Dispositivo dispositivo){
        for(Dispositivo x:dispositivos)if(x.getCodigo().equalsIgnoreCase(dispositivo.getCodigo()))throw new IllegalArgumentException("Código de dispositivo repetido.");
        this.dispositivos.add(dispositivo);
    }
    public void registrarConsumo(double k,int hora){
        if(hora>=22||hora<6)this.valle+=k;
        else if(hora>=18)this.punta+=k;
        else this.normal+=k;
    }

    public void agregarCredito(double credito){
        if(credito>0)this.creditos+=credito;
    }
    public Factura cerrarDia(int dia){
        Factura f = new Factura(dia, this.valle, this.normal, this.punta, this.creditos, 0, 0, 0, 0);
        this.facturas.add(f);
        this.valle=this.normal=this.punta=this.creditos=0;
        for(Dispositivo d:this.dispositivos)d.reiniciarConsumo();
        return f;
    }
    public String getCodigo(){
        return this.codigo;
    } 
    public String getInquilino(){
        return this.inquilino;
    }
    public ArrayList<Dispositivo> getDispositivos(){
        return this.dispositivos;
    } 
    public ArrayList<Factura> getFacturas(){
        return this.facturas;
    }
    public String resumen(){
        return "Valle "+String.format("%.3f",this.valle)+", Normal "+String.format("%.3f",this.normal)+", Punta "+String.format("%.3f",this.punta)+" kWh; créditos Q"+String.format("%.2f",this.creditos);
    }
    public String toString(){
        return this.codigo+" - "+this.inquilino;
    }
}
