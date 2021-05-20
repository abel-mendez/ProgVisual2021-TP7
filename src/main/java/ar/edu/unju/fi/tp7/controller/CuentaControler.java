package ar.edu.unju.fi.tp7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CuentaControler {
	//Controller temporal para poder probar el template
	@GetMapping("/cuenta/nueva")
	public String getCuenta() {
		return "nueva-cuenta";
	}
}
