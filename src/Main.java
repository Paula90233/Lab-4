import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Sistema s = new Sistema();
        int op=-1;
        while(op!=0){
            System.out.println("\\n=== TORREGT === Hora "+s.getHora()+" (día "+s.getHora()%24+")");
            System.out.println("1 Registrar oficina | 2 Registrar dispositivo | 3 Encender | 4 Apagar | 5 Ajustar nivel");
            System.out.println("6 Registrar lectura | 7 Movimiento cámara | 8 Avanzar hora | 9 Atender alerta");
            System.out.println("10 Oficinas | 11 Dispositivos de oficina | 12 Bandeja | 13 Alertas retrasadas | 14 Facturas | 0 Salir");
            try{
                System.out.print("Opción: ");
                op = Integer.parseInt(sc.nextLine());
                switch(op){
                    case 1:
                        System.out.print("Código oficina: ");
                        String co = sc.nextLine();
                        System.out.print("Inquilino: ");
                        s.registrarOficina(co, sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Código oficina: ");
                        String of = sc.nextLine();
                        System.out.print("Código dispositivo: ");
                        String cd = sc.nextLine();
                        System.out.print("Potencia W: ");
                        double p = Double.parseDouble(sc.nextLine());
                        System.out.print("Tipo 1 Luminaria, 2 Climatizador, 3 Inverter, 4 Sensor, 5 Cámara: ");
                        s.registrarDispositivo(of, cd, p, Integer.parseInt(sc.nextLine()));
                        break;
                    case 3:System.out.print("Código: ");s.encender(sc.nextLine());break;
                    case 4:System.out.print("Código: ");s.apagar(sc.nextLine());break;
                    case 5:System.out.print("Código: ");String cn=sc.nextLine();System.out.print("Nivel: ");s.ajustar(cn,Integer.parseInt(sc.nextLine()));break;
                    case 6:System.out.print("Código: ");String cl=sc.nextLine();System.out.print("Lectura: ");s.lectura(cl,Double.parseDouble(sc.nextLine()));break;
                    case 7:System.out.print("Código cámara: ");s.movimiento(sc.nextLine());break;
                    case 8:s.avanzar();break;
                    case 9:s.atender();break;
                    case 10:s.oficinas();break;
                    case 11:System.out.print("Código oficina: ");s.dispositivos(sc.nextLine());break;
                    case 12:s.alertas();break;
                    case 13:s.retrasadas();break;
                    case 14:s.facturas();break;
                    case 0:System.out.println("Hasta luego.");break;
                    default:System.out.println("Opción inválida.");
                }
            }catch(NumberFormatException e){System.out.println("Entrada incorrecta: ingrese un número válido.");}catch(RuntimeException e){System.out.println("Operación rechazada: "+e.getMessage());}
        }sc.close();}
}
