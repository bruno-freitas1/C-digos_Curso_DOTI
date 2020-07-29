package br.com.itaumon.projeto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itaumon.projeto.dao.AlarmeDAO;
import br.com.itaumon.projeto.dao.EventoDAO;
import br.com.itaumon.projeto.model.Alarme;
import br.com.itaumon.projeto.model.AlarmeCount;
import br.com.itaumon.projeto.model.Evento;
import br.com.itaumon.projeto.model.Intervalo;

@CrossOrigin("*")
@RestController
public class EventoController {
	
	@Autowired
	private EventoDAO dao;
	
	@Autowired
	private AlarmeDAO daoA;
	
	
	@PostMapping("eventos/alarme")
    public ResponseEntity<ArrayList<AlarmeCount>> getEventoAlarmeCount2(@RequestBody Intervalo intervalo) {
        ArrayList<Evento> lista = dao.getByNumSeq(intervalo.getInicio(), intervalo.getFim());
        ArrayList<Alarme> tiposAlarmes = (ArrayList<Alarme>) daoA.findAll();
        if (lista.size()==0) {
            return ResponseEntity.notFound().build();
        }else {
        	ArrayList<AlarmeCount> resposta = new ArrayList<AlarmeCount>();
        	
        	for (int cont=0;cont<tiposAlarmes.size();cont++) {
        		AlarmeCount objeto = new AlarmeCount();
        		objeto.setDescricao(tiposAlarmes.get(cont).getDescricao());
        		objeto.setQtd_alarme(0);
        		for (int cont2=0;cont2<lista.size();cont2++) {
        			if (lista.get(cont2).getAlarme().getId() == tiposAlarmes.get(cont).getId()) {
        				objeto.setQtd_alarme(objeto.getQtd_alarme()+1);	
        			}
            	}	
        		
        		resposta.add(objeto);
	        	
	        }
        	
        	return ResponseEntity.ok(resposta);
        }
    }
	
	

	
	
	@PostMapping("eventos/intervalo")
    public ResponseEntity<ArrayList<Evento>> getEventoIntervalo(@RequestBody Intervalo intervalo) {
        ArrayList<Evento> lista = dao.getByNumSeq(intervalo.getInicio(), intervalo.getFim());
        if (lista.size()==0) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(lista);
        }
    }
	
	
	
	@GetMapping("/eventos/{num_seq}")
	public ResponseEntity<Evento> getEventoId(@PathVariable int num_seq){
		Evento resposta = dao.findById(num_seq).orElse(null);
		if (resposta == null) {
			return ResponseEntity.status(404).build();
		} else {
			return ResponseEntity.ok(resposta);
		}
	}
	
	
	@GetMapping("/eventos")
	public ResponseEntity<ArrayList<Evento>> exibirTodosEventos(){
		ArrayList<Evento> lista = (ArrayList<Evento>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	

}
