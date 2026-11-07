
public class Alerta implements Comparable<Alerta> {
    private String codigo;
    private int hora;
    private int retraso;
    private Dispositivo dispositivo;
    private Severidad severidad;
    private String mensaje;
    private boolean atendida;
    private double credito;

    public Alerta(String codigo, Dispositivo dispositivo, int hora, Severidad severidad, String mensaje) {
        this.codigo = codigo;
        this.dispositivo = dispositivo;
        this.hora = hora;
        this.severidad = severidad;
        this.mensaje = mensaje;
        this.atendida = false;
        this.credito = 0;
        this.retraso = 0;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public boolean estaAtendida() {
        return atendida;
    }

    public int getRetraso() {
        return retraso;
    }

    public double atender(int actual) {
        if (atendida)
            return 0;
        atendida = true;
        retraso = Math.max(0, actual - hora - severidad.getPlazo());
        credito = retraso * severidad.getCreditoHora();
        return credito;
    }

    @Override
    public int compareTo(Alerta a) {
        if (severidad.getPrioridad() != a.severidad.getPrioridad())
            return a.severidad.getPrioridad() - severidad.getPrioridad();
        if (hora != a.hora)
            return hora - a.hora;
        return codigo.compareTo(a.codigo);
    }

    @Override
    public String toString() {
        return "Alerta " + codigo + " | " + severidad + " | " + mensaje
            + " | " + dispositivo.getCodigo() + " | hora " + hora
            + (atendida
            ? " | atendida, retraso " + retraso + " h, crédito Q"
                + String.format("%.2f", credito)
            : " | pendiente");
    }
}
