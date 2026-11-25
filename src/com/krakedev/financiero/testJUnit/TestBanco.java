package com.krakedev.financiero.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestBanco {

	@Test
	public void probarCodigosConsecutivos() {
		Banco banco = new Banco();
		Cliente cliente1 = new Cliente("1755073123", "Andres", "Vera");
		Cliente cliente2 = new Cliente("1712345678", "Camila", "Lopez");

		Cuenta cuenta1 = banco.crearCuenta(cliente1);
		Cuenta cuenta2 = banco.crearCuenta(cliente2);
		Cuenta cuenta3 = banco.crearCuenta(cliente1);

		assertNotNull(cuenta1);
		assertNotNull(cuenta2);
		assertNotNull(cuenta3);

		assertEquals("1000", cuenta1.getId());
		assertEquals("1001", cuenta2.getId());
		assertEquals("1002", cuenta3.getId());

		assertEquals(1003, banco.getUltimoCodigo());
	}

	@Test
	public void probarDepositoValido() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("1755073123", "Andres", "Vera");
		Cuenta cuenta = banco.crearCuenta(cliente);

		boolean resultado = banco.depositar(150.50, cuenta);

		assertTrue(resultado);
		assertEquals(150.50, cuenta.getSaldoActual());
	}

	@Test
	public void probarDepositoMontoCeroONegativo() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("1755073123", "Andres", "Vera");
		Cuenta cuenta = banco.crearCuenta(cliente);
		banco.depositar(100.0, cuenta);

		assertFalse(banco.depositar(0.0, cuenta));
		assertFalse(banco.depositar(-25.0, cuenta));
		assertEquals(100.0, cuenta.getSaldoActual());
	}

	@Test
	public void probarDepositoCuentaNula() {
		Banco banco = new Banco();

		assertFalse(banco.depositar(50.0, null));
	}
}