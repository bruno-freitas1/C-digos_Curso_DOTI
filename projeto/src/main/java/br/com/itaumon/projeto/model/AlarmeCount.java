package br.com.itaumon.projeto.model;

public class AlarmeCount {
	
	private String descricao;
	private int qtd_alarme;
	
	
	
	public AlarmeCount() {
		super();
	}
	public AlarmeCount(String descricao, int qtd_alarme) {
		super();
		this.descricao = descricao;
		this.qtd_alarme = qtd_alarme;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQtd_alarme() {
		return qtd_alarme;
	}
	public void setQtd_alarme(int qtd_alarme) {
		this.qtd_alarme = qtd_alarme;
	}
	
	
	
	
	
	

}
