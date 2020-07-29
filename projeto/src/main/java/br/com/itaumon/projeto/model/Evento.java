package br.com.itaumon.projeto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn_evento")
public class Evento {
	
	@Column(name="num_seq")
	@Id        			
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numSeq;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="data_evt")
	private Date data;
	
	@JsonIgnoreProperties("eventos")
	@ManyToOne
	private Equipamento equipamento;
	
	@JsonIgnoreProperties("eventos")
	@ManyToOne
	private Alarme alarme;
	
	
	public Evento() {
		super();
	}
	public Evento(int numSeq, Date data, Equipamento equipamento, Alarme alarme) {
		super();
		this.numSeq = numSeq;
		this.data = data;
		this.equipamento = equipamento;
		this.alarme = alarme;
	}
	public int getNumSeq() {
		return numSeq;
	}
	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public Alarme getAlarme() {
		return alarme;
	}
	public void setAlarme(Alarme alarme) {
		this.alarme = alarme;
	}
	
	

}
