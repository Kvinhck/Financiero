package com.krakedev.financiero.servicios;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class Banco {
	private int ultimoCodigo = 1000;

	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}
	
	public Cuenta crearCuenta (Cliente cliente ) {
		String codigoStr = ultimoCodigo + "";
		ultimoCodigo++;
		
		Cuenta c1 = new Cuenta(codigoStr);
		c1.setTipo("A");
		c1.setPropietario(cliente);

		return c1;
	}
	
	public boolean depositar(double monto, Cuenta cuenta) {
		if (monto <= 0) {
			return false;
		}
		if (cuenta == null) {
			return false;
		}

		double nuevoSaldo = cuenta.getSaldoActual() + monto;
		cuenta.setSaldoActual(nuevoSaldo);
		return true;
	}
	
	public boolean retirar(double monto, Cuenta cuenta) {
		if (monto <= 0) {
			return false;
		}
		if (cuenta == null) {
			return false;
		}
		if (monto > cuenta.getSaldoActual()) {
			return false;
		}

		double nuevoSaldo = cuenta.getSaldoActual() - monto;
		cuenta.setSaldoActual(nuevoSaldo);
		return true;
	}
}
