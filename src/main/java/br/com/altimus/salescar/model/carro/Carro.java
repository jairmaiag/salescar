package br.com.altimus.salescar.model.carro;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.altimus.salescar.model.modelo.Modelo;
import br.com.altimus.salescar.model.opcional.Opcional;

@Table(name = "carro")
@Entity
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "placa", length = 7, unique = true, nullable = false)
	private String placa;

	@Column(name = "renavam", length = 9, unique = true, nullable = false)
	private String renavam;

	@Column(name = "valorvenda")
	private Double valorvenda;

	@Column(name = "cadastro")
	@Temporal(TemporalType.DATE)
	private Calendar cadastro;

	@OneToOne
	@JoinColumn(name = "idmodelo")
	private Modelo modelo;

	@ManyToMany
	@JoinTable(name = "carro_opcional", joinColumns = { @JoinColumn(name = "idcarro") }, inverseJoinColumns = {
			@JoinColumn(name = "idopcional") })
	private List<Opcional> opcionais;

	
	public Carro() {
	}

	public Carro(String renavam) {
		super();
		this.renavam = renavam;
	}


	public Carro(Integer id, String placa, String renavam, Double valorvenda, Calendar cadastro) {
		super();
		this.id = id;
		this.placa = placa;
		this.renavam = renavam;
		this.valorvenda = valorvenda;
		this.cadastro = cadastro;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public Double getValorvenda() {
		return valorvenda;
	}

	public void setValorvenda(Double valorvenda) {
		this.valorvenda = valorvenda;
	}

	public Calendar getCadastro() {
		return cadastro;
	}

	public void setCadastro(Calendar cadastro) {
		this.cadastro = cadastro;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Opcional> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadastro == null) ? 0 : cadastro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((renavam == null) ? 0 : renavam.hashCode());
		result = prime * result + ((valorvenda == null) ? 0 : valorvenda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (renavam == null) {
			if (other.renavam != null)
				return false;
		} else if (!renavam.equals(other.renavam))
			return false;
		if (valorvenda == null) {
			if (other.valorvenda != null)
				return false;
		} else if (!valorvenda.equals(other.valorvenda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", placa=" + placa + ", renavam=" + renavam + ", valorvenda=" + valorvenda
				+ ", cadastro=" + cadastro + ", modelo=" + modelo + ", opcionais=" + opcionais + "]";
	}

}
