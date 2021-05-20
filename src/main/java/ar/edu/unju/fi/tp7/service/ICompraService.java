package ar.edu.unju.fi.tp7.service;

import java.util.List;

import ar.edu.unju.fi.tp7.model.Compra;

public interface ICompraService {
	public void generarTablaCompra();
	public void guardarCompra(Compra compra);
	public List<Compra> obtenerCompras();
	public Compra getCompra();

}
