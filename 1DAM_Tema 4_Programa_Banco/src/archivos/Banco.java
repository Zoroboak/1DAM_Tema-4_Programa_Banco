package archivos;

import java.util.Scanner;

public class Banco {
	
	private static long nºcuenta = 0;
	static Cuenta cuenta_cliente[]=new Cuenta[1000]; //crear vector de 100 clientes
		
	//Metodo: pedirle datos al usuario
	public static String getDato(String text,int parametro) {
		/*
		 * Parametro 1: Metodo devuelve un numero dado por el usuario 
		 * en el rango [1-4], lo uso para la opción del menu
		 * 
		 * Parametro 2: Devuelve la siguiente palabra introducida por el usuario
		 * 
		 * Parametro 3: Devuelve un DNI valido
		 * 
		 * Parametro 4: Devuelve varias palabras en un String
		 * 
		 * Parametro 5: Devuelve un valor numerico dado por el usuario en un string
		 * 
		 * El metodo muestra por pantalla el texto que le pasemos 
		 * devuelve un string con la salida validada según el parametro pasado
		 * 
		 * */
		
		
		//Variables locales del metodo
		String auxs = "-"; //Variable auxiliar que almacena un strings
		int aux = 0; //Variable auxiliar que almacena un valor entero
		double auxd = 0; //Variable auxiliar que almacena un valor de tipo long
		boolean v = false; //Flag que marca si el valor es valido o no
		
		//Declaro el objeto Scanner
		Scanner t = new Scanner(System.in);
		
		switch(parametro) {
		case 1: //Valor a solicitar: Entero positivo del 1 al 4
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido un numero entero
					aux = t.nextInt();
					
					//Si el rango no es correcto, repetimos el while
					if(aux<1||aux>4) {
						System.out.println("Debes introducir un numero en el rango [1-4]");
						v=false;
					}
				}
				catch(Exception e){
					System.out.println("¡El caracter introducido no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			auxs = Integer.toString(aux);
			break;
		case 2: //Valor a solicitar: Palabra introducida por el usuario
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido una Palabra entre 3 y 15 caracteres
					auxs = t.next();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<3||auxs.length()>15) {
						System.out.println("Debes introducir una palabra entre 3 y 15 caracteres");
						v=false;
					}
					//Si hay un numero, lo volvemos a pedir
					for (int i = 0; i < auxs.length(); i++) {
						if((auxs.charAt(i)>=48)&&(auxs.charAt(i)<=57)) {
							i=auxs.length();
							System.out.println("Debes introducir una palabra entre 3 y 15 caracteres, no numeros");
							v=false;
							
						}
					}
					
					
				}
				catch(Exception e){
					System.out.println("¡La palabra introducida no es valida!");
					t.next();
					v=false;
				}
			}while(!v);
			
			break;
		case 3: //Devuelve un DNI en String 
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido una Palabra entre 3 y 15 caracteres
					auxs = t.next();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<8||auxs.length()>9) {
						System.out.println("Debes introducir un DNI(Sin letra) de 8 Numeros enteros");
						v=false;
					}
					//Si hay un caracter, lo volvemos a pedir
					for (int i = 0; i < auxs.length(); i++) {
						if((auxs.charAt(i)>=48)&&(auxs.charAt(i)<=57)) {
							v=true;
							//Numero correcto
							
						}else { //Hay un caracter
							System.out.println("Debes introducir un DNI(Sin letra) de 8 Numeros enteros");
							i=auxs.length();
							v=false;							
							
						}
					}
					
				}
				catch(Exception e){
					System.out.println("¡El numero introducido no es valido!!");
					t.next();
					v=false;
				}
			}while(!v);
			break;
		case 4: //Parametro 4: Devuelve varias palabras en un String 
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Guardo la siguiente linea completa
					auxs = t.nextLine();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<4) {
						System.out.println("Debes introducir un minimo de 4 caracteres para este elemento");
						v=false;
					}
					
				}
				catch(Exception e){
					System.out.println("¡El texto introducida no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			break;
			
		case 5: //Parametro 5: Devuelve un valor numerico dado por el usuario en un string
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Guardo la siguiente linea completa
					auxd = t.nextDouble();
					
					//Si el rango no es correcto, repetimos el while
					if(auxd<=-1) {
						System.out.println("Debes introducir un valor positivo");
						v=false;
					}
					
				}
				catch(Exception e){
					System.out.println("¡El valor introducido no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			auxs = Double.toString(auxd);
			
			break;
		
		}
		
		
		
		//Devuelvo un String
		return auxs;
	}
	
	//Metodo que rellena con "0" a la isquierda para dar forma al numero de cuenta
	public static String formaCuenta(long ndecuenta) {
		
		/*
		 * El Numero de la cuenta debe tener 10 digitos, por lo 
		 * que si tiene 5 digitos, le añado 5 "0" a la isquierda
		 * 
		 * */
		
		String auxs="0000000000";
		
		switch(Long.toString(ndecuenta).length()) {
		case 1: //Si Long solo tiene un digito, entonces le añado 9 "0"
			auxs = "000000000"+Long.toString(ndecuenta);
			break;			
		case 2: //Si Long tiene 2 digito, entonces le añado 8 "0"
			auxs = "00000000"+Long.toString(ndecuenta);
			break;			
		case 3: //Si Long tiene 3 digito, entonces le añado 7 "0"
			auxs = "0000000"+Long.toString(ndecuenta);
			break;			
		case 4: //Si Long tiene 4 digito, entonces le añado 6 "0"
			auxs = "000000"+Long.toString(ndecuenta);
			break;			
		case 5: //Si Long tiene 5 digito, entonces le añado 5 "0"
			auxs = "00000"+Long.toString(ndecuenta);
			break;			
		case 6: //Si Long tiene 6 digito, entonces le añado 4 "0"
			auxs = "0000"+Long.toString(ndecuenta);
			break;			
		case 7: //Si Long tiene 7 digito, entonces le añado 3 "0"
			auxs = "000"+Long.toString(ndecuenta);
			break;			
		case 8: //Si Long tiene 8 digito, entonces le añado 2 "0"
			auxs = "00"+Long.toString(ndecuenta);
			break;			
		case 9: //Si Long tiene 9 digito, entonces le añado 1 "0"
			auxs = "0"+Long.toString(ndecuenta);
			break;			
		}
		return auxs;
	}
	
	//Metodo que calcula el NIF del DNI
	public static String NIF(int aux) {
		
		//Variable local donde alojare la Letra
		char letra = 'D';
		int dni = aux;
		String nif;
		
		//ejecuto la formula para calcular el NIF
		aux%=23;
		
		//Tabla de comprobación
		switch(aux) {
		case 0: 
			letra = 'T';
			break;
		case 1: 
			letra = 'R';
			break;
		case 2: 
			letra = 'W';
			break;
		case 3: 
			letra = 'A';
			break;
		case 4: 
			letra = 'G';
			break;
		case 5: 
			letra = 'M';
			break;
		case 6: 
			letra = 'Y';
			break;
		case 7: 
			letra = 'F';
			break;
		case 8: 
			letra = 'P';
			break;
		case 9: 
			letra = 'D';
			break;
		case 10: 
			letra = 'X';
			break;
		case 11: 
			letra = 'B';
			break;
		case 12: 
			letra = 'N';
			break;
		case 13: 
			letra = 'J';
			break;
		case 14: 
			letra = 'Z';
			break;
		case 15: 
			letra = 'S';
			break;
		case 16: 
			letra = 'Q';
			break;
		case 17: 
			letra = 'V';
			break;
		case 18: 
			letra = 'H';
			break;
		case 19: 
			letra = 'L';
			break;
		case 20: 
			letra = 'C';
			break;
		case 21: 
			letra = 'K';
			break;
		case 22: 
			letra = 'E';
			break;
		}
		
		nif = Integer.toString(dni)+"-"+letra;		
		
		//Devolvemos la Letra correspondiente a dicho DNI
		return nif;
	}
	
	/*##################### CREAR PRODUCTOS  ########################*/ 
	
	//Metodo que creara la cuenta
	public static void crearCuenta(String iban, String entidad, String ofi, String cd) {
		
		String opc = "0"; // Variable auxiliar para guardar valores
		
		
		Cuenta temporal = new Cuenta();
		
		temporal.setDNI(getDato("Introduce el DNI del nuevo cliente", 3));
		System.out.println("NIF: "+NIF(Integer.parseInt(temporal.getDNI())));
		temporal.setNombre(getDato("Introduce el Nombre del cliente", 4));
		temporal.setApellido1(getDato("Introduce el primer Apellido del nuevo cliente", 2));
		temporal.setApellido2(getDato("Introduce el segundo Apellido del nuevo cliente", 2));
		temporal.setDirección(getDato("Introduce la dirección del nuevo cliente", 4));
		
		System.out.println();
		
		temporal.setSaldo(getDato("Introduce saldo inicial", 5));
		temporal.setNºObjeto(iban, entidad, ofi, cd, (nºcuenta+1));
		
		System.out.println("¿Desea crear una nueva cuenta con los siguientes datos?: ");
		System.out.println("-------------------------------------------------------");
		System.out.println("Nombre del cliente: "+temporal.getNombre()+" "+temporal.getApellido1()+" "+temporal.getApellido2());
		System.out.println("DNI: "+NIF(Integer.parseInt(temporal.getDNI())));
		System.out.println("Dirección: "+temporal.getDirección());
		System.out.println("Saldo Inicial: "+temporal.getSaldo()+"€");
		System.out.println("-------------------------------------------------------");
		
		opc = getDato("Escriba 1 para confirmar o escriba 2 para cancelar: ",1);
		
		if(Integer.parseInt(opc)==1) {
			nºcuenta++;
			cuenta_cliente[(int) nºcuenta] = new Cuenta(temporal);
			
			System.out.println("Se ha creado la cuenta bancaria.");
			System.out.print("Su numero de cuenta es ");
			
			System.out.println(iban+" "+entidad+" "+ofi+" "+cd+" "+formaCuenta(nºcuenta));
			
		}else {
			System.out.println("Se ha cancelado la creación de la nueva cuenta");
		}
	}
	
	//Metodo que creara un fondo de pensiones
	public static void crearFondoPensiones() {
		
	}
	
	//Metodo que creara un fondo a plazo fijo
	public static void crearFondoPlazoFijo() {
		
	}
	
	/*##################### BUSCAR PRODUCTOS  #######################*/ 
	
	//Metodo: Buscar Cuenta bancaria
	public static void buscarCuentaBancaria() {
		
		
	}
	
	//Buscar Fondo de Pensiones
	public static void buscarFondodePensiones() {
	
	}
	
	//Buscar Fondo a Plazo Fijo
	public static void buscarFondoPlazoFijo() {
		
	}
	
	//Metodo que muestra los ultimos productos agregados
	private static void mostrarUltimosAgregados() {
		
		for (int i = 1; i <= nºcuenta; i++) {
			
			System.out.println("---------------------------------");
			System.out.print("Producto: "+cuenta_cliente[i].getTipo());
			System.out.print(" A nombre de "+cuenta_cliente[i].getNombre()+" "+cuenta_cliente[i].getApellido1()+" "+cuenta_cliente[i].getApellido2());
			System.out.println("NIF: "+NIF(Integer.parseInt(cuenta_cliente[i].getDNI())));
			System.out.println("Saldo: "+cuenta_cliente[i].getSaldo()+"€");
			
		}
		
	}

	//Metodo Principal a Ejecutar
	public static void main(String[] args) {
		/*
		 *  MÉTODO PRINCIPAL A EJECUTAR 
		 *  
		 *  Contiene el flujo Global del programa
		 *  
		 *  */
		
		
		// DECLARACIÓN DE VARIABLES DE CABECERA 
		int aux = 0; //Variable local que almacena posición del menu
		String auxs; //Variable local que almacena un Strins
		
		
		//### TEST ### si hay argumentos, pedimos menos palabras
		if(args.length > 0) {
			System.out.println("Hay Argumentos");
		}
		
		
		// CABECERA DEL PROGRAMA 
		System.out.println("+--------------------------------------+");
		System.out.println("|                                      |");
		System.out.println("| Programa: Software Gestión del Banco |");
		System.out.println("|                                      |");
		System.out.println("|  30/01/2019            By Zoroboak   |");
		System.out.println("+--------------------------------------+");
				
		
		do {
			
			System.out.println();
			System.out.println("+-------------------------+");
			System.out.println("|    Gestión bancaria     |");
			System.out.println("+-------------------------+");
			System.out.println("| 1.- Crear Producto      |");
			System.out.println("| 2.- Buscar Producto     |");
			System.out.println("| 3.- Salir               |");
			System.out.println("+-------------------------+");
			
			//Le paso al metodo getDato un String, el parametro que indica lo que 
			//tiene que hacer con el dato, y un array de Strings que no usaremos en este caso
			auxs = getDato("Escoge opción del menu: ",1);
			//Paso el String a entero para trabajar con el
			aux = Integer.parseInt(auxs);
			
			switch(aux) {
			case 1: //1.- Crear Producto
				
				//------------------------------------------------------------#
				do {
					System.out.println();
					System.out.println("+-------------------------------+");
					System.out.println("|     Crear Producto            |");
					System.out.println("+-------------------------------+");
					System.out.println("| 1.- Crear Cuenta              |");
					System.out.println("| 2.- Crear fondos de pensiones |");
					System.out.println("| 3.- Crear fondo a plazo fijo  |");
					System.out.println("| 4.- Volver                    |");
					System.out.println("+-------------------------------+");
					
					//Le paso al metodo getDato un String, el parametro que indica lo que 
					//tiene que hacer con el dato, y un array de Strings que no usaremos en este caso
					auxs = getDato("Escoge opción del menu: ",1);
					//Paso el String a entero para trabajar con el
					aux = Integer.parseInt(auxs);
					
					switch(aux) {
					case 1: //1.- Crear Cuenta  
						
						crearCuenta(args[0], args[1], args[2], args[3]);
						
						break;
					case 2: //2.- Crear fondos de pensiones
						
						crearFondoPensiones();
					
						break;
					case 3: //2.- Crear fondo a plazo fijo
						
						crearFondoPlazoFijo();
						
						break;
					case 4: //3. - Volver
						System.out.println();
						System.out.println("Volviendo a Gestión Bancaria");
						break;
						
					}
					
				}while(aux!=4);
				//Hago reset a aux
				aux=0;
				
				//------------------------------------------------------------#
				break;
			case 2: //2.- Buscar Producto 
				
				//------------------------------------------------------------#
				do {
					System.out.println();
					System.out.println("+----------------------------------------+");
					System.out.println("|     Buscar Producto                    |");
					System.out.println("+----------------------------------------+");
					System.out.println("| 1.- Buscar Cuenta Bancaria             |");
					System.out.println("| 2.- Buscar Fondo de Pensiones          |");
					System.out.println("| 3.- Buscar Fondo a Plazo Fijo          |");
					System.out.println("| 4.- Mostrar Ultimos Productos Añadidos |");
					System.out.println("| 5.- Volver                             |");
					System.out.println("+----------------------------------------+");
					
					//Le paso al metodo getDato un String, el parametro que indica lo que 
					//tiene que hacer con el dato, y un array de Strings que no usaremos en este caso
					auxs = getDato("Escoge opción del menu: ",1);
					//Paso el String a entero para trabajar con el
					aux = Integer.parseInt(auxs);
					
					switch(aux) {
					case 1: // 1.- Buscar Cuenta bancaria   
						
						buscarCuentaBancaria();
						
						break;
					case 2: // 2.- Buscar Fondo de Pensiones  
						
						buscarFondodePensiones();
					
						break;
					case 3: // 3.- Buscar Fondo a Plazo Fijo 
						
						buscarFondoPlazoFijo();
					
						break;
					case 4: // 4.- Mostrar Ultimos Productos Añadido 
	
						mostrarUltimosAgregados();

						break;
					case 5: // 5.- Volver 
						System.out.println();
						System.out.println("Volviendo a Gestión Bancaria");
						break;
						
					}
					
				}while(aux!=3);
				//Hago reset a aux
				aux=0;
				
				//------------------------------------------------------------#
			
				break;
			case 3: //3. - SALIR DEL PROGRAMA
				System.out.println();
				System.out.println("Gracias por utilizar este programa. º/(^_^)/º");
				break;
				
			}
			
		}while(aux!=4);
	}
	

}
