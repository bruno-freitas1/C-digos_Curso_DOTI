package br.com.itaumon.projeto.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.itaumon.projeto.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer> {
	
	
	@Query(value="SELECT * FROM PROJETO.ITMN_EVENTO WHERE DATA_EVT >= :inicio AND DATA_EVT <= :fim", 
			nativeQuery=true)
	ArrayList<Evento> getByNumSeq(@Param("inicio") Date inicio, @Param("fim") Date fim);
	
	
	/*
	@Query(value="SELECT new br.com.itaumon.projeto.model "
			+ "(ITMN_EVENTO.ALARME.ID_ALARME, ITMN_EVENTO.ALARME.DESCRICAO, COUNT (ITMN_EVENTO.NUM_SEQ)) "
			+ "FROM PROJETO.ITMN_EVENTO "
			+ "WHERE ITMN_EVENTO.DATA_EVT >= :inicio AND ITMN_EVENTO.DATA_EVT <= :fim "
			+ "GROUP BY ITMN_EVENTO.ALARME_ID_ALARME", nativeQuery=true)
	ArrayList<AlarmeCount> getByAlarmeCount(@Param("inicio") Date inicio, @Param("fim") Date fim);
	*/
	
}

 

    
