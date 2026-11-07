import java.util.ArrayList;
public class Sistema {
 private ArrayList<Oficina> oficinas=new ArrayList<Oficina>(); private GestorAlertas gestor=new GestorAlertas(); private int hora=0;
 public Sistema(){Oficina a=new Oficina("OF1","Inquilino A"),b=new Oficina("OF2","Inquilino B"),c=new Oficina("OF3","Inquilino C");oficinas.add(a);oficinas.add(b);oficinas.add(c);
 agregarInicial(new Luminaria("L1",a,1000));agregarInicial(new Luminaria("L2",b,800));
 agregarInicial(new Climatizador("CL1",a,1500));agregarInicial(new Climatizador("CL2",c,1200));
 agregarInicial(new ClimatizadorInverter("CI1",b,1500));agregarInicial(new ClimatizadorInverter("CI2",c,1300));
 agregarInicial(new SensorHumo("S1",a,500));agregarInicial(new SensorHumo("S2",b,450));
 agregarInicial(new Camara("CA1",a,800));agregarInicial(new Camara("CA2",c,900));}
 private void agregarInicial(Dispositivo d){d.getOficina().agregarDispositivo(d);}
 public Oficina buscarOficina(String c){for(Oficina o:oficinas)if(o.getCodigo().equalsIgnoreCase(c))return o;return null;}
 public Dispositivo buscarDispositivo(String c){for(Oficina o:oficinas)for(Dispositivo d:o.getDispositivos())if(d.getCodigo().equalsIgnoreCase(c))return d;return null;}
 public void registrarOficina(String c,String n){if(buscarOficina(c)!=null)throw new IllegalArgumentException("Código repetido.");oficinas.add(new Oficina(c,n));}
 public void registrarDispositivo(String co,String c,double p,int t){Oficina o=buscarOficina(co);if(o==null)throw new IllegalArgumentException("Oficina inexistente.");if(buscarDispositivo(c)!=null)throw new IllegalArgumentException("Código repetido.");Dispositivo d;if(t==1)d=new Luminaria(c,o,p);else if(t==2)d=new Climatizador(c,o,p);else if(t==3)d=new ClimatizadorInverter(c,o,p);else if(t==4)d=new SensorHumo(c,o,p);else if(t==5)d=new Camara(c,o,p);else throw new IllegalArgumentException("Tipo inválido.");o.agregarDispositivo(d);}
 public void encender(String c){Dispositivo d=buscarDispositivo(c);if(d==null)throw new IllegalArgumentException("Dispositivo inexistente.");if(!(d instanceof Controlable))throw new IllegalArgumentException("No admite encendido/apagado.");((Controlable)d).encender();}
 public void apagar(String c){Dispositivo d=buscarDispositivo(c);if(d==null)throw new IllegalArgumentException("Dispositivo inexistente.");if(d instanceof SensorHumo)throw new IllegalArgumentException("El sensor permanece encendido.");if(!(d instanceof Controlable))throw new IllegalArgumentException("No admite apagado.");((Controlable)d).apagar();}
 public void ajustar(String c,int n){Dispositivo d=buscarDispositivo(c);if(d==null)throw new IllegalArgumentException("Dispositivo inexistente.");if(!(d instanceof Regulable))throw new IllegalArgumentException("No es regulable.");((Regulable)d).ajustarNivel(n);}
 public void lectura(String c,double v){Dispositivo d=buscarDispositivo(c);if(d==null)throw new IllegalArgumentException("Dispositivo inexistente.");if(!d.estaEncendido())throw new IllegalStateException("Debe estar encendido.");if(!(d instanceof Medible))throw new IllegalArgumentException("No mide.");Medible m=(Medible)d;if(!m.validarLectura(v))throw new IllegalArgumentException("Lectura fuera de rango.");gestor.generar(d,m.evaluarLectura(v),hora,m.getNombreMedicion()+": "+v);}
 public void movimiento(String c){Dispositivo d=buscarDispositivo(c);if(d==null)throw new IllegalArgumentException("Dispositivo inexistente.");if(!d.estaEncendido())throw new IllegalStateException("La cámara debe estar encendida.");if(!(d instanceof DetectorMovimiento))throw new IllegalArgumentException("No detecta movimiento.");gestor.generar(d,((DetectorMovimiento)d).evaluarMovimiento(hora%24),hora,"Movimiento detectado");}
 public void avanzar(){int h=hora%24;for(Oficina o:oficinas)for(Dispositivo d:o.getDispositivos()){double k=d.calcularConsumoHora();d.acumularConsumo(k);o.registrarConsumo(k,h);}hora++;if(hora%24==0){System.out.println("*** CIERRE DEL DÍA "+(hora/24)+" ***");for(Oficina o:oficinas)System.out.println(o+" -> "+o.cerrarDia(hora/24));}System.out.println("Hora simulada: "+hora+" (hora del día "+hora%24+")");}
 public void atender(){gestor.atender(hora);} public void alertas(){gestor.mostrarPendientes();} public void retrasadas(){gestor.mostrarRetrasadas();}
 public void oficinas(){for(Oficina o:oficinas)System.out.println(o);}
 public void dispositivos(String co){Oficina o=buscarOficina(co);if(o==null)throw new IllegalArgumentException("Oficina inexistente.");ArrayList<Dispositivo> l=o.getDispositivos();for(int i=0;i<l.size()-1;i++)for(int j=0;j<l.size()-1-i;j++)if(l.get(j).getCodigo().compareToIgnoreCase(l.get(j+1).getCodigo())>0){Dispositivo x=l.get(j);l.set(j,l.get(j+1));l.set(j+1,x);}for(Dispositivo d:l)System.out.println(d);System.out.println(o.resumen());}
 public void facturas(){for(Oficina o:oficinas){System.out.println(o);if(o.getFacturas().isEmpty())System.out.println("Sin facturas.");for(Factura f:o.getFacturas())System.out.println(f);}}
 public int getHora(){return hora;}
}
