package classemployed;

public class Empleado {
   
   private String nombre;
   private String correo;
   private String empresaAPertenecer;
   private String rol;
   
   public Empleado(String nombre, String correo, String empresaAPertenecer, String rol) {
	  super();
	  this.nombre = nombre;
	  this.correo = correo;
	  this.empresaAPertenecer = empresaAPertenecer;
	  this.rol = rol;
   }
   
   public String getNombre() {
	  return nombre;
   }
   public void setNombre(String nombre) {
	  this.nombre = nombre;
   }
   public String getCorreo() {
	  return correo;
   }
   public void setCorreo(String correo) {
	  this.correo = correo;
   }
   public String getEmpresaAPertenecer() {
	  return empresaAPertenecer;
   }
   public void setEmpresaAPertenecer(String empresaAPertenecer) {
	  this.empresaAPertenecer = empresaAPertenecer;
   }
   public String getRol() {
	  return rol;
   }
   public void setRol(String rol) {
	   
	   if(rol.equals("administrador")) {
		   this.rol= "administrador";
	   }
	       this.rol= "operativo";
   }

@Override
public String toString() {
	return "Empleado [nombre=" + nombre + ", correo=" + correo + ", empresaAPertenecer=" + empresaAPertenecer 
			+ ", rol=" + rol + "]";
}
   
   
}
