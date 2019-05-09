package archivos;

public class Cuenta {
	
	
	/*
	 * 
	 *   ESXX   XXXX   XXXXX  XX XXXXXXXXXX
	 *   Iban Entidad Oficina DC Cuenta
	 * 
	 * */
	
	//Atributos privados
	private String NºObjeto; //Numero de cuenta unico para cada cliente
	private String Saldo;
	
	//Resto de Atributos	
	public String Nombre;
	public String Apellido1;
	public String Apellido2;
	public String DNI = "00000000";
	public String Dirección;
	public String tipo = "Cuenta Bancaria";

	
	
	Cuenta(){	
	}
	
	Cuenta(Cuenta uno){	
		this.Nombre = uno.Nombre;
	}
	
	public String getNombre(){
		return this.Nombre;
	}
	
	public String getApellido1(){
		return this.Apellido1;
	}
	
	public String getApellido2(){
		return this.Apellido2;
	}
	
	public String getDNI(){
		return this.DNI;
	}
	
	public String getDirección(){
		return this.Dirección;
	}
	
	public String getNºObjeto(){
		return this.NºObjeto;
	}
	
	public String getSaldo(){
		return this.Saldo;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	//-------------------------------
	
	public void setNombre(String nombre){
		this.Nombre = nombre;
	}
	
	public void setApellido1(String apellido1){
		this.Apellido1 = apellido1;
	}
	
	public void setApellido2(String apellido2){
		this.Apellido2 = apellido2;

	}
	
	public void setDNI(String dni){
		this.DNI = dni;
	}
	
	public void setDirección(String direccion){
		this.Dirección = direccion;

	}
	
	public void setNºObjeto(String iban,String entidad,String ofi,String cd,long ncuenta){
		NºObjeto = iban+" "+entidad+" "+ofi+" "+cd+" "+Long.toString(ncuenta);

	}
	
	public void setSaldo(String saldo){
		this.Saldo = saldo;
	}
	
	

}
