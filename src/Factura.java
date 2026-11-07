public class Factura {
    private int dia; 
    private double kv;
    private double kn;
    private double kp;
    private double mv;
    private double mn;
    private double mp;
    private double creditos;
    private double total;

    public Factura(int dia,double kv,double kn,double kp,double creditos, double total, double mv, double mn, double mp) {
        this.dia = dia;
        this.kv = kv;
        this.kn = kn;
        this.kp = kp;
        this.mv = kv * 0.85;
        this.mn = kn * 1.40;
        this.mp = kp * 2.10;
        this.creditos = creditos;
        this.total = Math.max(0, this.mv + this.mn + this.mp - creditos);
        this.total = Math.round(this.total * 100.0) / 100.0;
    }

    public double getTotal(){
        return total;
    }
    public String toString(){
        return "Día "+dia+" | Valle "+String.format("%.3f kWh Q%.2f",kv,mv)+" | Normal "+String.format("%.3f kWh Q%.2f",kn,mn)+" | Punta "+String.format("%.3f kWh Q%.2f",kp,mp)+" | Créditos Q"+String.format("%.2f",creditos)+" | TOTAL Q"+String.format("%.2f",total);}
}
