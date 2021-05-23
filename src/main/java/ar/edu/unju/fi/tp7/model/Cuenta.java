package ar.edu.unju.fi.tp7.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Entity
@Table(name="CUENTAS")
@Component("unaCuenta")
public class Cuenta {
	@Id
	@Column(name="cue_Id")
	private Long id;
	@Column(name="cue_Saldo")
	private Double saldo;
	@Column(name="cue_FechaCreacion")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion;
	@Column(name="cue_Estado")
	private String estado;
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

	public Cuenta(Long id, Double saldo, LocalDate fechaCreacion, String estado) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ "]";
	}
	
	
}
