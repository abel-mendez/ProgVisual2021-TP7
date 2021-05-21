package ar.edu.unju.fi.tp7.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Cliente;
import ar.edu.unju.fi.tp7.repository.IClienteRepository;
import ar.edu.unju.fi.tp7.service.IClienteService;
@Service("clienteServiceMysql")
public class ClienteServiceImpMysql implements IClienteService {
	
	@Autowired
	private IClienteRepository clienteRepo;
	@Autowired
	private Cliente cliente;

	@Override
	public void generarTablaCLiente() {
		// TODO Auto-generated method stub
		
		guardarCliente(new Cliente("DNI", 111, "Vilte", "vilte@Hotmail.com", "1234", LocalDate.of(1989, 4, 3), 388, 4212121, LocalDate.of(2021, 4, 16)));
	
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepo.save(cliente);
	}

	@Override
	public List<Cliente> getAllClientes() {
		// TODO Auto-generated method stub
		List<Cliente> clientes=(List<Cliente>)clienteRepo.findAll();
		return clientes;
	}

	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return this.cliente;
	}

	@Override
	//recupera el empleado por id
	public Optional<Cliente> getClienteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente=clienteRepo.findById(id);
		return cliente;
	}

	@Override
	public void deletClienteById(Long id) {
		// TODO Auto-generated method stub
		clienteRepo.deleteById(id);
		
	}

}
