package banco;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaBancariaTest {

	@Test
	void testIngresar1() {
		CuentaBancaria cb1 = new CuentaBancaria("Jason Momoa", "5794", "9906", "66", "6137475351");
			cb1.setSaldo(3000);
			cb1.ingresar(1000);
			double nuevoSaldo = cb1.getSaldo();
			assertEquals(4000, nuevoSaldo);
	}
	
	/*@Test
	void testIngresar2() {
		CuentaBancaria cb1 = new CuentaBancaria("Jason Momoa", "5794", "9906", "66", "6137475351");
			cb1.setSaldo(3000);
			cb1.ingresar(- 1000);
			//double nuevoSaldo = cb1.getSaldo();
			assertThrows(IllegalArgumentException.class,() -> cb1.ingresar(-1000));
	}*/

	@Test
	void testRetirar1() {
		CuentaBancaria cb1 = new CuentaBancaria("Jason Momoa", "5794", "9906", "66", "6137475351");
		cb1.setSaldo(3000);
		cb1.retirar(1500);
		double nuevoSaldo = cb1.getSaldo();
		assertEquals(1500, nuevoSaldo);
	}
	
	/*@Test
	void testRetirar2() {
		CuentaBancaria cb1 = new CuentaBancaria("Jason Momoa", "5794", "9906", "66", "6137475351");
		cb1.setSaldo(3000);
		cb1.retirar(-1500);
		//double nuevoSaldo = cb1.getSaldo();
		assertThrows(IllegalArgumentException.class,() -> cb1.retirar(-1500));
	}*/
	
	/*@Test
	void testRetirar3() {
		CuentaBancaria cb1 = new CuentaBancaria("Jason Momoa", "5794", "9906", "66", "6137475351");
		cb1.setSaldo(3000);
		cb1.retirar(4000);
		//double nuevoSaldo = cb1.getSaldo();
		assertThrows(IllegalArgumentException.class,() -> cb1.retirar(4000));
	}*/

	/*@Test
	void testComprobarCCC1() {
		CuentaBancaria cb1 = new CuentaBancaria("Jason Momoa", "5794", "9906", "66", "6137475351");
		String nuevoCCC = cb1.getEntidad() + cb1.getOficina() + cb1.getDigitoControl() + cb1.getNumCuenta();
		Boolean comprobacion = cb1.comprobarCCC(nuevoCCC);
		assertEquals(true, comprobacion);
	}*/
	
	@Test
	void testComprobarCCC2() {
		CuentaBancaria cb1 = new CuentaBancaria("Jason Momoa", "5794", "9906", "66", "6137475351");
		String nuevoCCC = "123456789098765432112";
		Boolean comprobacion = cb1.comprobarCCC(nuevoCCC);
		assertEquals(false, comprobacion);
	}

	/*@Test
	void testObtenerDigitosControl() {
		CuentaBancaria cb1 = new CuentaBancaria("Jason Momoa", "5794", "9906", "66", "6137475351");
		String nuevoDC = "66";
		String comprobacion = cb1.obtenerDigitosControl("5794", "9906", "6137475351");
		assertEquals(nuevoDC, comprobacion);
	}
*/
}
