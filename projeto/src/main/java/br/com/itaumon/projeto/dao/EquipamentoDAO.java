package br.com.itaumon.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itaumon.projeto.model.Equipamento;

public interface EquipamentoDAO extends CrudRepository<Equipamento, Integer> {
	
	

}
