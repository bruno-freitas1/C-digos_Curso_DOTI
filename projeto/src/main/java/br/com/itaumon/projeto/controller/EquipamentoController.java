package br.com.itaumon.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.itaumon.projeto.dao.EquipamentoDAO;
import br.com.itaumon.projeto.model.Equipamento;

@CrossOrigin("*")
@RestController
public class EquipamentoController {
	
	@Autowired
	private EquipamentoDAO dao;

	@GetMapping("/equipamentos")
	public ResponseEntity<ArrayList<Equipamento>> exibirTodosEquipamentos(){
	ArrayList<Equipamento> lista = (ArrayList<Equipamento>) dao.findAll();
	if(lista.size()==0) {
	return ResponseEntity.notFound().build();
	}else {
	return ResponseEntity.ok(lista);
	}
	}
	@GetMapping("/equipamentos/{id}")
	public ResponseEntity<Equipamento> getEquipamentoId(@PathVariable int id){
	Equipamento resposta = dao.findById(id).orElse(null);
	if (resposta == null) {
	return ResponseEntity.status(404).build();
	} else {
	return ResponseEntity.ok(resposta);
	}
	}

}