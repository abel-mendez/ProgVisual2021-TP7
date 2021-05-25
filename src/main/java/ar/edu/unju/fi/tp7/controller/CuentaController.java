package ar.edu.unju.fi.tp7.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.model.Cuenta;
import ar.edu.unju.fi.tp7.service.ICuentaService;
@Controller
public class CuentaController {
	@Autowired
	@Qualifier("cuentaServiceMysql")
	private ICuentaService cuentaService;

	@GetMapping("/cuenta/nueva")
	public String nuevaCuenta(Model model){
		model.addAttribute(cuentaService.getCuenta());
		return"nueva-cuenta";
	}
	@PostMapping("/cuenta/guardar")
	public ModelAndView guardarCuenta(@ModelAttribute("cuenta")Cuenta cuenta) {
		ModelAndView modelView= new ModelAndView("lista-cuenta");
		cuentaService.guardarCuenta(cuenta);
		modelView.addObject("cuentas", cuentaService.getAllCuentas());
		return modelView;
	}
	@GetMapping("/cuenta/lista")
	public ModelAndView getCuentasPage() {
		ModelAndView modelView = new ModelAndView("lista-cuenta");
		modelView.addObject("cuentas", cuentaService.getAllCuentas());
		return modelView;
	}
	@GetMapping("/cuenta/borrar/{id}")
	public ModelAndView getCompraDeletPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView = new ModelAndView("redirect:/cuenta/lista");
		cuentaService.deletCuentaById(id);
		return modelView;
	}
	@GetMapping("/cuenta/editar/{id}")
	public ModelAndView getCompraModPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView=new ModelAndView("nueva-cuenta");
		Optional<Cuenta> cuenta=cuentaService.getCuentaById(id);
		modelView.addObject("cuenta", cuenta);

		return modelView;
	}
}
