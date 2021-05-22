package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Compra;
import ar.edu.unju.fi.tp7.repository.ICompraRepository;
import ar.edu.unju.fi.tp7.service.ICompraService;
import ar.edu.unju.fi.tp7.util.TablaCompra;

@Service("compraServiceMysql")
public class CompraServiceImpMysql implements ICompraService{
	
	private List<Compra> compras=TablaCompra.listCompras;
	private static final Log LOGGER =LogFactory.getLog(CompraServiceImp.class);
	@Autowired
	@Qualifier("unaCompra")
	Compra compra;
	@Autowired
	ICompraRepository compraRepo;
	
	@Override
	public void generarTablaCompra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarCompra(Compra compra) {
		// TODO Auto-generated method stub
		//LOGGER.info("METHOD: se agrego un obj compra a la lista -> "+compras.get(compras.size()-1));
		compraRepo.save(compra);
	}

	@Override
	public List<Compra> obtenerCompras() {
		// TODO Auto-generated method stub
		LOGGER.info("METHOD: mostrar obj de la lista ");
		List<Compra> compras=(List<Compra>) compraRepo.findAll();
		return compras;
	}

	@Override
	public Compra getCompra() {
		// TODO Auto-generated method stub
		return this.compra;
	}


}
