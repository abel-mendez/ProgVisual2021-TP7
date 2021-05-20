package ar.edu.unju.fi.tp7.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CuentaControler {

	@GetMapping("/cuenta")
	public String getCuenta() {
		return "nueva-cuenta";
	}
}
