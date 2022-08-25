package Sprint;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author fermi
 */
public class App
{
    Scanner sc = new Scanner(System.in);
    
    private MovimientoDinero movimiento;
    private int opcion;
    private int cantidad = 0;
    private String concepto = "";
    private String usuario = "";
    
    

    public void realizarMovimiento()
    {      
        usuario = JOptionPane.showInputDialog("Digite el Nombre del Usuario: ");
        
        movimiento = new MovimientoDinero(usuario);       
    
    
    do{
        opcion = Integer.parseInt(JOptionPane.showInputDialog("\n\tQue Desea Realizar?"
                + "\n1. Ingresar Monto"
                + "\n2. Modificar Monto"
                + "\n3. Modificar Concepto"
                + "\n4. Consulta General"
                + "\n5. SALIR"
                + "\nDigite la Opcion:"));           
        
        switch(opcion)
        {
            case 1:                
                System.out.print("Digite el valor del Monto: ");                
                cantidad = sc.nextInt();
                movimiento.consignar(cantidad); 
                System.out.print("Digite el nombre del Concepto: ");                
                concepto = sc.next();
                movimiento.modificarConcepto(concepto);
                System.out.println("Consulta\n: "+movimiento.mostrarDatos());
            break;
            case 2: 
                System.out.println("Actualmente tiene: "+movimiento.getMonto());
                System.out.print("Digite el valor del Monto: ");                
                cantidad = sc.nextInt();
                movimiento.consignar(cantidad);
                System.out.println("Monto Modificado"); 
                System.out.println("Consulta\n: "+movimiento.mostrarDatos());

            break;
            case 3: 
                System.out.print("Concepto Actual: "+movimiento.getConcepto());                
                System.out.print("Digite el nombre del Concepto: ");                
                concepto = sc.next();
                movimiento.modificarConcepto(concepto);
                System.out.println("Concepto Modificado"); 
                System.out.println("Consulta\n: "+movimiento.mostrarDatos());

            break;
            case 4:   
                System.out.println("Consulta\n: "+movimiento.mostrarDatos());
            break;
            case 5:
                JOptionPane.showMessageDialog(null, "Gracias Por Utilizar el Servicio");
            break;
            default: System.out.println("Digite una Opcion Correcta entre 1 - 4");

        }
        
        }while(opcion !=5);
    }
    
    public static void main(String[] args){
        App miApp = new App();
        miApp.realizarMovimiento();
    }
    
}

