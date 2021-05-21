package ar.edu.unju.fi.tp7.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.model.Compra;
import ar.edu.unju.fi.tp7.service.ICompraService;
import ar.edu.unju.fi.tp7.service.IProductoService;

@Controller
public class CompraController {
	
	@Autowired
	private ICompraService compraService;
	@Autowired
	@Qualifier("productoServiceImpMysql")
	private IProductoService productoService;
	
	private static final Log LOGGER = LogFactory.getLog(CompraController.class);

	@GetMapping("/compra/guardar")
	public String getAddCompraGuardarPage(Model model,@RequestParam(name="cantidad")String cantidad,
			@RequestParam(name="id")String id,
			@RequestParam(name="codigo")String codigo) {
		Compra comp = new Compra();
		comp.setCantidad(Integer.valueOf(cantidad));
		comp.setId(Long.valueOf(id));
		comp.setProducto(this.productoService.getUnProducto(Integer.valueOf(codigo)));
		comp.setTotal(comp.getTotal());
		LOGGER.info("CONTROLLER : CompraController with /guardarCompra post method");
		compraService.guardarCompra(comp);
		model.addAttribute("compras",compraService.getCompra());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA resultadoCompra.html ");
		return "resultadoCompra";
	}
	
	@GetMapping("/compra")
	public String getCompraFormPage(Model model) {
		LOGGER.info("CONTROLLER : CompraController with / Formulario get method");
		LOGGER.info("METHOD : getCompraFormPage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA compra.html");
		model.addAttribute("compra",compraService.getCompra());
		model.addAttribute("producto",productoService.getAllProductos());
		return "compra";
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getComprasListPage() {
		LOGGER.info("CONTROLLER : CompraController with / compra/listado get method");
		LOGGER.info("METHOD : getComprasListPage()");
		ModelAndView modelView = new ModelAndView("listacompras");
		if (compraService.obtenerCompras().isEmpty()) {
			compraService.generarTablaCompra();
		}
		modelView.addObject("compras",compraService.obtenerCompras());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA listacompras.html");
		return modelView;
	
	}
	
	
}
