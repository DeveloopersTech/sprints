/*
Modelar el movimiento de dinero como una clase de Java

Es posible crear una nueva instancia de la clase "MovimientoDinero"
Es posible leer y modificar el monto del movimiento
Es posible crear montos positivos y negativos
Es posible leer y modificar el concepto del movimiento
Es posible definir qué usuario fue encargado de registrar el movimiento
 */
package Sprint;

/**
 *
 * @author fermi
 */
public class MovimientoDinero {
    private double monto;
    private String concepto;
    private String usuario;

    public MovimientoDinero(String usuario) {  
        this.usuario = usuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    //Modificar Monto
    public void consignar(int cantidad)
    {
    	this.monto = this.monto + cantidad;    
    }
    
    //Modificar el concepto del movimiento
    public void modificarConcepto(String concepto)
    {
       this.concepto = concepto;
    }
    
    //Metodo Consulta General
    public String mostrarDatos(){
       return "Monto: "+monto+"\nConcepto: "+concepto+"\nRealizado por: "+usuario+"\n";
    }
    
    
}
