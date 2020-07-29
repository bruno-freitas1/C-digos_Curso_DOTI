package br.com.itaumon.projeto.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itaumon.projeto.model.Alarme;

public interface AlarmeDAO extends CrudRepository<Alarme, Integer> {
	
}
