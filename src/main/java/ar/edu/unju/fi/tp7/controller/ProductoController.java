package ar.edu.unju.fi.tp7.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.model.Producto;
import ar.edu.unju.fi.tp7.service.IProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	@Qualifier("productoServiceImpMysql")
	private IProductoService productoService;
	
	private static final Log LOGGER = LogFactory.getLog(ProductoController.class);
	
	@GetMapping("/{detail}")
	public ModelAndView getHomePage(@PathVariable(value="detail")String param) {
		LOGGER.info("CONTROLLER : ProductoController with /home get method");
		LOGGER.info("METHOD : getHomePage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA home.html");
		ModelAndView modelView = new ModelAndView ("home");
		
		return modelView;
	}
	
	@GetMapping("/producto")
	public String getNuevoPage(Model model) {
		LOGGER.info("CONTROLLER : ProductoController with /nuevo get method");
		LOGGER.info("METHOD : getNuevoPage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA nuevo.html");
		model.addAttribute(productoService.getProducto());
		return "nuevo";
	}
	
	@PostMapping("/producto/guardar")
	public String addProducto(@ModelAttribute("producto") Producto unProducto) {
		LOGGER.info("CONTROLLER : ProductoController with /addProducto post method");
		productoService.addProducto(unProducto);
		LOGGER.info("RESULT : VISUALIZA LA PAGINA resultado.html ");
		return "resultado";
	}
	
	
	@GetMapping("/producto/ultimo")
	public ModelAndView getUltimoProducto() {
		LOGGER.info("CONTROLLER : ProductoController with /getUltimoProducto get method");
		LOGGER.info("METHOD : getUltimoProducto() ------ PARAMS: producto '"+ productoService.getUltimoProducto() +" '");
		ModelAndView model2 = new ModelAndView("ultimo-producto");
		model2.addObject("producto", productoService.getUltimoProducto());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA ultimo-producto.html ");
		return model2;
	}
	
	@GetMapping("/producto/lista")
	public String getProdList(Model model) {
		model.addAttribute("productoList", productoService.getAllProductos());
		return "lista-productos";
	}
	
	@GetMapping("/producto/borrar/{id}")
	public ModelAndView getProductoDeletPage(@PathVariable(value = "id")int id) {
		ModelAndView modelView = new ModelAndView("redirect:/producto/lista");
		productoService.deleteProducto(id);
		return modelView;
	}
	
	@GetMapping("/producto/editar/{id}")
	public ModelAndView getProductoModPage(@PathVariable(value = "id")int id) {
		ModelAndView modelView=new ModelAndView("nuevo");
		Optional <Producto> productoOP=productoService.getUnProducto(id);
		Producto producto=new Producto();
		producto.setCodigo(productoOP.get().getCodigo());
		producto.setMarca(productoOP.get().getMarca());
		producto.setNombre(productoOP.get().getNombre());
		producto.setPrecio(productoOP.get().getPrecio());
		modelView.addObject("producto", producto);
		
		return modelView;
	}
	
	
	
}
