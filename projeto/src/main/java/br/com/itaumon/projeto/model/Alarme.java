package br.com.itaumon.projeto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="itmn_alarme")
public class Alarme {
	
	
	@Column(name="id_alarme")
	@Id        			
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="descricao", length=200)
	private String descricao;
	
	@JsonIgnoreProperties("alarme")
	@OneToMany(mappedBy="alarme", cascade=CascadeType.ALL)
	private List<Evento> eventos;
	
	public Alarme() {
		super();
	}
	public Alarme(int id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
