package banco;


/**
 * @author: Daniel Candelas, Pablo Longás, Enrique Haba y Jose Luis.
 * @version: 1.0.0
 * NOMBRE DE LA CLASE: Cuenta Bancaria
 * DESCRIPCIÓN: Esta clase se utiliza para la creacion de una cuenta bancaria, la obtención de los diferentes datos de esta y su consiguiente modificación. 
 *	
 */

public class CuentaBancaria {

	// ATRIBUTOS
	private String titular;
	private double saldo;
	private String entidad;
	private String oficina;
	private String numCuenta;
	private String digitoControl;

	
	private double cantidad;
	private String ccc;

	// CONSTRUCTORES:

	
	/**
	 * 
	 * Atributos básicos de la cuenta corriente
	 * Constructor para crear el numero de cuenta.
	 * 
	 * @param titular: Nombre y Apellidos del titular
	 * @param entidad: Numero que identifica a la entidad
	 * @param oficina: Numero que identifica a la sucursal
	 * @param digitoControl: Numero para comprobar la validez del CCC
	 * @param numCuenta: Numero de cuenta del usuario
	 * 
	 
	 */
	public CuentaBancaria(String titular, String entidad, String oficina, String digitoControl, String numCuenta) {
		this.titular = titular;
		this.entidad = entidad;
		this.oficina = oficina;
		this.digitoControl = obtenerDigitosControl(entidad, oficina, numCuenta);
		this.numCuenta = numCuenta;
		
		if (!this.titular.equals(titular) || !this.entidad.equals(entidad) || !this.oficina.equals(oficina) 
				|| !this.digitoControl.equals(obtenerDigitosControl(entidad, oficina, numCuenta)) || !this.numCuenta.equals(numCuenta)) {
			throw new IllegalArgumentException("Error");
		}
	} //Cierre del constructor

	 
	/**
	 * 
	 * @param titular: Nombre y Apellidos del titular
	 * @param CCC: Numero de la cuenta bancaria
	 * 
	 * Parametros titular y CCC sin descomponer
	 * Constructor que descompone el CCC
	 */
	public void constructor2(String titular, String ccc) { // TO DO
		this.titular = titular;
		this.ccc = ccc;
		
		entidad = ccc.substring(0, 3);
		oficina = ccc.substring(4, 7);
		digitoControl = ccc.substring(8, 9);
		numCuenta = ccc.substring(10, 20);		
	} //Cierre del constructor
	

	// GETTERS titular, saldo, entidad, oficina y numCuenta.
	// SETTER titular
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	

	public String getDigitoControl() {
		return digitoControl;
	}


	public void setDigitoControl(String digitoControl) {
		this.digitoControl = digitoControl;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getEntidad() {
		return entidad;
	}

	public String getOficina() {
		return oficina;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	// METODOS:


	/**
	 * @param cantidad: El fondo de loa cuenta o la cantidad a ingresar o retirar
	 * 
	 * ESTE METODO INGRESA EL SALDO EN LA CUENTA -> Este valor tiene que ser positivo. 
	 * Excepción IllegalArgumentException.
	 * 
	 */
	public void ingresar(double cantidad) {
		try {
			if (cantidad > 0) {
				saldo += cantidad;
			} else {
				throw new IllegalArgumentException("No se puede ingresar una cantidad negativa");
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	} //Cierre del método

	
	/**
	 * @param cantidad: El fondo de loa cuenta o la cantidad a ingresar o retirar
	 * 
	 * ESTE METODO RETIRA EL SALDO DE LA CUENTA -> Valor positivo y nunca superior al saldo de la cuenta
	 * Excepción IllegalArgumentException.
	 *  
	 */
	public void retirar(double cantidad) throws IllegalArgumentException {
		try {
			if (cantidad < saldo) {
				saldo -= cantidad;
			} else {
				throw new IllegalArgumentException("No se puede retirar más de lo que posees");
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	} //Cierre del método

	
	/**
	 * 
	 * @param CCC: Numero de la cuenta bancaria
	 * 
	 * ESTE METODO COMPRUEBA LA VALIDEZ DEL CCC 
	 * @return Devuelve true o false indicando si el CCC es válido o no.
	 *  
	 */
	public boolean comprobarCCC(String ccc) {
		//boolean res;
		if (ccc.equals(getEntidad() + getOficina() + digitoControl + getNumCuenta()) ) {
			return true;
		} else {
			return false;
		}
	} //Cierre del método
	

	// CALCULAR DIGITOS DE CONTROL -> 
	
	/**
	 * 
	 * @param entidad: Numero que identifica a la entidad
	 * @param oficina: Numero que identifica a la sucursal
	 * @param numCuenta: Numero de cuenta del usuario
	 * 
	 * @return Devuelve los dos dígitos de control dado los códigos de entidad, oficina y número de cuenta
	 */
	public static String obtenerDigitosControl(String entidad, String oficina, String numCuenta) {

		String primerDC;
		String segundoDC;
		String DC;

		int suma;
		int resto;
		int resto2;

	
		
		suma = 0 + 0 + (Integer.parseInt(entidad.charAt(0)+"") * 4) + (Integer.parseInt(entidad.charAt(1)+"") * 8) + (Integer.parseInt(entidad.charAt(0)+"") * 5) 
				+ (Integer.parseInt(entidad.charAt(3)+"") * 10) + (Integer.parseInt(entidad.charAt(0)+"") * 9) + (Integer.parseInt(entidad.charAt(1)+"") * 7) 
				+ (Integer.parseInt(entidad.charAt(2)+"") * 3) + (Integer.parseInt(entidad.charAt(3)+"") * 6);

		resto = suma % 11;

		resto2 = 11 - resto;
		
		if(resto2 > -1) {
			if (resto2 == 10) {
				resto2 = 1;
				primerDC = Integer.toString(resto2);
			}
			if (resto2 == 11) {
				resto2 = 0;
				primerDC = Integer.toString(resto2);
			}
		}else {
			primerDC = Integer.toString(resto2);
		}
		primerDC = Integer.toString(resto2);

		// SEGUNDO DIGITO

		suma = (Integer.parseInt(numCuenta.charAt(0)+"") * 1) + (Integer.parseInt(numCuenta.charAt(1)+"") * 2) + (Integer.parseInt(numCuenta.charAt(2)+"") * 4)
			+ (Integer.parseInt(numCuenta.charAt(3)+"") * 8)	+ (Integer.parseInt(numCuenta.charAt(4)+"") * 5) + (Integer.parseInt(numCuenta.charAt(5)+"") * 10) 
			+ (Integer.parseInt(numCuenta.charAt(6)+"") * 9) + (Integer.parseInt(numCuenta.charAt(7)+"") * 7) 
				+ (Integer.parseInt(numCuenta.charAt(8)+"") * 3) + (Integer.parseInt(numCuenta.charAt(9)+"") * 6) ;

		resto = suma % 11;

		resto2 = 11 - resto;

		if(resto2>-1) {
			if (resto2 == 10) {
				resto2 = 1;
				segundoDC = Integer.toString(resto2);
			}
			if (resto2 == 11) {
				resto2 = 0;
				segundoDC = Integer.toString(resto2);
			}
		}else {
			segundoDC = Integer.toString(resto2);
		}
		segundoDC = Integer.toString(resto2);
		DC = primerDC + segundoDC;
		return DC;
	}

	@Override //To String
	public String toString() {
		return "Titular: " + titular + "\nentidad: " + entidad + "\noficina: " + oficina
				+ "\nnumCuenta: " + numCuenta + "\ndigitoControl: " + digitoControl + "\ncantidad: " + cantidad + "\nCCC: "
				+ ccc + "\nsaldo: " + saldo;
	}
	/**
	 * 
	 * @return devuelve el CCC
	 */
	public String mostrarCCC() {
		String ccc =  getEntidad() + " " + getOficina() +  " " + digitoControl +  " " + getNumCuenta();
		return "CCC: " + ccc;
	}
	
}
