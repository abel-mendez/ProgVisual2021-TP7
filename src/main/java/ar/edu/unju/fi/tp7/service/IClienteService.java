package ar.edu.unju.fi.tp7.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp7.model.Cliente;

public interface IClienteService {
	
	public void generarTablaCLiente();
	public void guardarCliente(Cliente cliente);
	public List<Cliente> getAllClientes();
	public Cliente getCliente();
	public Optional<Cliente> getClienteById(Long id);
	public void deletClienteById(Long id);

}
