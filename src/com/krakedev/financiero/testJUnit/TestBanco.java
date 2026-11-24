package com.krakedev.financiero.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		assertEquals("A", cuenta1.getTipo());
		assertEquals(0, cuenta1.getSaldoActual());
		assertEquals(cliente1, cuenta1.getPropietario());
		assertEquals(cliente2, cuenta2.getPropietario());
	}
}