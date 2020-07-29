package br.com.itaumon.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.itaumon.projeto.dao.AlarmeDAO;
import br.com.itaumon.projeto.model.Alarme;

@CrossOrigin("*")
@RestController
public class AlarmeController {
	
	@Autowired
	private AlarmeDAO dao;

	@GetMapping("/alarmes")
	public ResponseEntity<ArrayList<Alarme>> exibirTodosAlarmes(){
	ArrayList<Alarme> lista = (ArrayList<Alarme>) dao.findAll();
	if(lista.size()==0) {
	return ResponseEntity.notFound().build();
	}else {
	return ResponseEntity.ok(lista);
	}
	}
	@GetMapping("/alarmes/{id}")
	public ResponseEntity<Alarme> getAlarmeId(@PathVariable int id){
	Alarme resposta = dao.findById(id).orElse(null);
	if (resposta == null) {
	return ResponseEntity.status(404).build();
	} else {
	return ResponseEntity.ok(resposta);
	}
	}

}
