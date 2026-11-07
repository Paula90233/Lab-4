public interface Medible { 
    boolean validarLectura(double valor); 
    Severidad evaluarLectura(double valor); 
    String getNombreMedicion(); 
}
