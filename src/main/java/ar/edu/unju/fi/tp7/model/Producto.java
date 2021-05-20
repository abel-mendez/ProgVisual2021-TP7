package ar.edu.unju.fi.tp7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="PRODUCTOS")
@Component("unProducto")
public class Producto {
	@Id
	@Column(name="PRO_CODIGO")
	 private int codigo;
	@Column(name="PRO_NOMBRE")
	 private String nombre;
	@Column(name="PRO_PRECIO")
	 private Double precio;
	@Column(name="PRO_MARCA")
	 private String marca;
	@Column(name="PRO_STOCK")
	 private int stock;
	 
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	 
	
	/**
	 * @param codigo
	 * @param nombre
	 * @param precio
	 * @param marca
	 * @param stock
	 */
	public Producto(int codigo, String nombre, Double precio, String marca, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Producto [Codigo= " + codigo + "\nNombre= " + nombre + "\nPrecio= " + precio + "\nMarca= " + marca
				+ "\nStock= " + stock + "]";
	}
	
	
	
}